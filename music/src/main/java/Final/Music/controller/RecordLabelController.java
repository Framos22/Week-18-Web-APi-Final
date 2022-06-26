package Final.Music.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Final.Music.model.RecordLabel;
import Final.Music.service.RecordLabelService;

@RestController
@RequestMapping("/music/record_label")
public class RecordLabelController {
  
  private RecordLabelService recordLabelService;
  
  public RecordLabelController(RecordLabelService recordLabelService) {
    super();
    this.recordLabelService = recordLabelService;
 
}
 @PostMapping
 public ResponseEntity<RecordLabel> saveRecordLabel(@RequestBody RecordLabel recordLabel) {
   
   return new ResponseEntity<RecordLabel>(recordLabelService.saveRecordLabel(recordLabel), HttpStatus.CREATED);
 }
 
 @GetMapping
 public List<RecordLabel> getAllRecordLabel(){
   return recordLabelService.getAllRecordLabel();
 }
 
 @GetMapping("{record_label_id}")
 public ResponseEntity<RecordLabel> getRecordLabelById(@PathVariable("record_label_id") int recordLabelId){
   return new ResponseEntity<RecordLabel>(recordLabelService.getRecordLabelByID(recordLabelId), HttpStatus.OK);
 }
 
 @PutMapping("{record_label_id}")
 public ResponseEntity<RecordLabel> updateRecordLabel(@PathVariable("record_label_id") 
 int recordLabelId, @RequestBody RecordLabel recordlabel){
   return new ResponseEntity<RecordLabel>(recordLabelService.updateRecordLabel(recordlabel, recordLabelId), HttpStatus.OK);
 }
 
 @DeleteMapping("{record_label_id}")
 public ResponseEntity<String> deleteRecordLabel(@PathVariable("record_label_id") int recordLabelId){
   recordLabelService.deleteRecordLabel(recordLabelId);
   
   return new ResponseEntity<String>("Label Deleted!", HttpStatus.OK);
 
   
   }
}
