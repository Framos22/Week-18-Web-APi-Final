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
import Final.Music.model.Albums;
import Final.Music.service.AlbumsService;

@RestController
@RequestMapping("/music/albums")
public class AlbumsController {
  
  private AlbumsService albumsService;
  
  public AlbumsController(AlbumsService albumsService ) {
    super();
    this.albumsService = albumsService;
  }

  @PostMapping()
  public ResponseEntity<Albums> saveAlbums(@RequestBody Albums albums){
      return new ResponseEntity<Albums>(albumsService.saveAlbums(albums), HttpStatus.CREATED);
  }
  
  @GetMapping
  public List<Albums> getAllAlbums(){
      return albumsService.getAllAlbums();
  }
  @GetMapping("{albums_id}")
  public ResponseEntity<Albums> getAlbumsById(@PathVariable("albums_id") int albums_id){
      return new ResponseEntity<Albums>(albumsService.getAlbumsById(albums_id), HttpStatus.OK);
  }
  
  @PutMapping("{albums_id}")
  public ResponseEntity<Albums> updateAlbums(@PathVariable("albums_id") int albums_Id, @RequestBody Albums albums){
      return new ResponseEntity<Albums>(albumsService.updateAlbums(albums, albums_Id), HttpStatus.OK);
  }
  
  @DeleteMapping("{albums_id}")
  public ResponseEntity<String> deleteAlbums(@PathVariable("albums_id") int albumsId){
      albumsService.deleteAlbums(albumsId);
      return new ResponseEntity<String>("Album gone!", HttpStatus.OK);
  }
  

}
