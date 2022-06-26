package Final.Music.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Final.Music.exception.ResourceNotFoundException;
import Final.Music.model.RecordLabel;
import Final.Music.repository.RecordLabelRepository;
import Final.Music.service.RecordLabelService;

@Service
public class RecordLabelServiceImpl implements RecordLabelService  {

  
  private RecordLabelRepository recordLabelRepository;
  @Autowired
  public RecordLabelServiceImpl(RecordLabelRepository recordLabelRepository) {
    super();
    this.recordLabelRepository = recordLabelRepository;
  }
  @Override
  public RecordLabel saveRecordLabel(RecordLabel recordLabel) {
    
    return recordLabelRepository.save(recordLabel);
  }
  
  @Override
  public List<RecordLabel> getAllRecordLabel(){
    return recordLabelRepository.findAll();
  }
  
  @Override 
  public RecordLabel getRecordLabelByID(int id) {
    return recordLabelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RecordLabel", "Id", id));
  }
  @Override
  public RecordLabel updateRecordLabel(RecordLabel recordlabel, int id) {
    RecordLabel existingRecordLabel = recordLabelRepository.findById(id).orElseThrow(() -> 
      new ResourceNotFoundException("RecordLabel", "Id", id));
    existingRecordLabel.setLabel_name(recordlabel.getLabel_name());
    existingRecordLabel.setYear_created(recordlabel.getYear_created());

    return existingRecordLabel;
    
  }
  
  @Override
  public void deleteRecordLabel(int id) {
      RecordLabel existingRecordLabel = recordLabelRepository.findById(id).orElseThrow(() -> 
      new ResourceNotFoundException("RecordLabel", "Id", id));
      recordLabelRepository.deleteById(id);
  }

}
