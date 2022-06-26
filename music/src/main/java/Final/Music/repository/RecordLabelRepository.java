package Final.Music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Final.Music.model.RecordLabel;

@Repository
public interface RecordLabelRepository extends JpaRepository<RecordLabel, Integer> {

}
