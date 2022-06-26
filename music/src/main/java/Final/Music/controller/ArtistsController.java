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
import Final.Music.model.Artists;
import Final.Music.service.ArtistsService;

@RestController
@RequestMapping("/music/artists")
public class ArtistsController {
  
  private ArtistsService artistsService;
  
  public ArtistsController(ArtistsService artistsService) {
    super();
    this.artistsService = artistsService;
    
  }
  
  @PostMapping
  public ResponseEntity<Artists> saveArtists(@RequestBody Artists artists) {
    
    return new ResponseEntity<Artists>(artistsService.saveArtists(artists), HttpStatus.CREATED);
  }
  
  @GetMapping
  public List<Artists> getAllArtists(){
    return artistsService.getAllArtists();
  }
  
  @GetMapping("{artists_id}")
  public ResponseEntity<Artists> getArtistsById(@PathVariable("artists_id") int artists_Id){
    return new ResponseEntity<Artists>(artistsService.getArtistsById(artists_Id), HttpStatus.OK);
  }
  
  @PutMapping("{artists_id}")
  public ResponseEntity<Artists> updateArtists(@PathVariable("artists_id") 
  int artists_Id, @RequestBody Artists artists){
    return new ResponseEntity<Artists>(artistsService.updateArtists(artists, artists_Id), HttpStatus.OK);
  }
  
  @DeleteMapping("{artists_id}")
  public ResponseEntity<String> deleteArtists(@PathVariable("artists_id") int artistsId){
    artistsService.deleteArtists(artistsId);
    
    return new ResponseEntity<String>("Artist Dropped!", HttpStatus.OK);
  
    
    }
}
