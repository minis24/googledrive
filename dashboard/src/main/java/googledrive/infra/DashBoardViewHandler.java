package googledrive.infra;

import googledrive.domain.*;
import googledrive.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DashBoardViewHandler {

    @Autowired
    private DashBoardRepository dashBoardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileUploaded_then_CREATE_1 (@Payload FileUploaded fileUploaded) {
        try {

            if (!fileUploaded.validate()) return;

            // view 객체 생성
            DashBoard dashBoard = new DashBoard();
            // view 객체에 이벤트의 Value 를 set 함
            dashBoard.setId(fileUploaded.getId());
            dashBoard.setFileSize(String.valueOf(fileUploaded.getSize()));
            dashBoard.setFileName(fileUploaded.getName());
            dashBoard.setIsUploaded(true);
            // view 레파지 토리에 save
            dashBoardRepository.save(dashBoard);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenFileIndexed_then_UPDATE_1(@Payload FileIndexed fileIndexed) {
        try {
            if (!fileIndexed.validate()) return;
                // view 객체 조회
            Optional<DashBoard> dashBoardOptional = dashBoardRepository.findById(fileIndexed.getFileId());

            if( dashBoardOptional.isPresent()) {
                 DashBoard dashBoard = dashBoardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashBoard.setIsIndexed(true);    
                // view 레파지 토리에 save
                 dashBoardRepository.save(dashBoard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenVideoProccessed_then_UPDATE_2(@Payload VideoProccessed videoProccessed) {
        try {
            if (!videoProccessed.validate()) return;
                // view 객체 조회
            Optional<DashBoard> dashBoardOptional = dashBoardRepository.findById(Long.valueOf(videoProccessed.getFileKey()));

            if( dashBoardOptional.isPresent()) {
                 DashBoard dashBoard = dashBoardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashBoard.setVideoUrl(videoProccessed.getVideoUrl());    
                // view 레파지 토리에 save
                 dashBoardRepository.save(dashBoard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

