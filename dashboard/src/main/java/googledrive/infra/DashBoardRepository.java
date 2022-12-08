package googledrive.infra;

import googledrive.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="dashBoards", path="dashBoards")
public interface DashBoardRepository extends PagingAndSortingRepository<DashBoard, Long> {

    

    
}
