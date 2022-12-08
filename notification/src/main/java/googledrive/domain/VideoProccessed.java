package googledrive.domain;

import googledrive.domain.*;
import googledrive.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class VideoProccessed extends AbstractEvent {

    private Long id;
    private String videoUrl;
    private String fileKey;
}


