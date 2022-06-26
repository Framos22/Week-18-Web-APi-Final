package Final.Music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Final.Music.model.Artists;

@Repository
public interface ArtistsRepository extends JpaRepository<Artists, Integer> {

}
