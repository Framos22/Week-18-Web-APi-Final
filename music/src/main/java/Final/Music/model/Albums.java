package Final.Music.model;

import org.springframework.data.relational.core.mapping.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;






import lombok.Data;

@Data
@Entity
@Table(name="albums")
public class Albums {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  
  @Column(value ="title")
  private String title;
  
  @Column(value ="year_released")
  private int year_released;
  
  @Column(value ="label")
  private String label;
  
  @Column(value ="song_id")
  private String song_id;
  
  @Column(value ="artists_id")
  private String artists_id;
  
  @Column(value ="record_label_id")
  private int record_label_id;
  
 
}
