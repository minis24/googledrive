package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class FileIndexed extends AbstractEvent {

    private Long id;
    private Long fileId;
    private List<String> keyword;

    public FileIndexed(Index aggregate){
        super(aggregate);
    }
    public FileIndexed(){
        super();
    }
}
