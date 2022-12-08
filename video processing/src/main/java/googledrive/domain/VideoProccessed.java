package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class VideoProccessed extends AbstractEvent {

    private Long id;
    private String videoUrl;
    private String fileKey;

    public VideoProccessed(Video aggregate){
        super(aggregate);
    }
    public VideoProccessed(){
        super();
    }
}
