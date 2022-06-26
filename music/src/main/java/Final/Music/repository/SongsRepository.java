package Final.Music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Final.Music.model.Songs;

@Repository
public interface SongsRepository extends JpaRepository<Songs, Integer> {

}
