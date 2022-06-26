package Final.Music.service;

import java.util.List;
import Final.Music.model.RecordLabel;

public interface RecordLabelService {
  
  RecordLabel saveRecordLabel(RecordLabel recordlabel);

  List<RecordLabel> getAllRecordLabel();

  RecordLabel getRecordLabelByID(int id);

  RecordLabel updateRecordLabel(RecordLabel recordlabel, int Id);
  
  void deleteRecordLabel(int Id);
  
  
}
