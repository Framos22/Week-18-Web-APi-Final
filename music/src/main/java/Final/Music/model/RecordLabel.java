package Final.Music.model;

import lombok.Data;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Column;


@Data
@Entity
@Table(name="record_label")
public class RecordLabel {
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(value = "label_name")
  private String label_name;
  
  @Column(value = "year_created")
  private String year_created;

}
