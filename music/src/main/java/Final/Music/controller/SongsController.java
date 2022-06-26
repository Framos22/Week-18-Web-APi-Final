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
import Final.Music.model.Songs;
import Final.Music.service.SongsService;

@RestController
@RequestMapping("/music/songs")
public class SongsController {
  
  private SongsService songsService;
  
  public SongsController(SongsService songsService ) {
    super();
    this.songsService = songsService;
  }
  
  @PostMapping
  public ResponseEntity<Songs> saveSongs(@RequestBody Songs songs) {
    
    return new ResponseEntity<Songs>(songsService.saveSongs(songs), HttpStatus.CREATED);
  }
  
  @GetMapping
  public List<Songs> getAllSongs(){
    return songsService.getAllSongs();
  }
  
  @GetMapping("{songs_id}")
  public ResponseEntity<Songs> getSongsById(@PathVariable("songs_id") int songs_Id){
    return new ResponseEntity<Songs>(songsService.getSongsById(songs_Id), HttpStatus.OK);
  }
  
  @PutMapping("{songs_id}")
  public ResponseEntity<Songs> updateSongs(@PathVariable("songs_id") 
  int songs_Id, @RequestBody Songs songs){
    return new ResponseEntity<Songs>(songsService.updateSongs(songs, songs_Id), HttpStatus.OK);
  }
  
  @DeleteMapping("{songs_id}")
  public ResponseEntity<String> deleteSongs(@PathVariable("songs_id") int songsId){
    songsService.deleteSongs(songsId);
    
    return new ResponseEntity<String>("Song Dropped!", HttpStatus.OK);
  
    
    }
 

}
