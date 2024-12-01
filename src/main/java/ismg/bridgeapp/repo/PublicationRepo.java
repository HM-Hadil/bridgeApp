package ismg.bridgeapp.repo;

import ismg.bridgeapp.Publications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepo extends JpaRepository<Publications,Long> {

    List<Publications> findPublicationsByUserId(Long UserId);

}