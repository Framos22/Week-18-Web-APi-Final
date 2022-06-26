package Final.Music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Final.Music.model.Albums;

@Repository
public interface AlbumsRepository extends JpaRepository<Albums, Integer> {

  
  }


