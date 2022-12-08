package googledrive.domain;

import googledrive.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class VideoProccessed extends AbstractEvent {

    private Long id;
    private String videoUrl;
    private String fileKey;
}
