package Final.Music.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Final.Music.exception.ResourceNotFoundException;
import Final.Music.model.Albums;
import Final.Music.repository.AlbumsRepository;
import Final.Music.service.AlbumsService;

@Service
public class AlbumsServiceImpl implements AlbumsService {
  
  private AlbumsRepository albumsRepository;
  
  @Autowired
  public AlbumsServiceImpl(AlbumsRepository albumsRepository) {
    super();
    this.albumsRepository = albumsRepository;
  }

  @Override
  public Albums saveAlbums(Albums albums) {
        return albumsRepository.save(albums);
  }

  @Override
  public List<Albums> getAllAlbums() {
    return albumsRepository.findAll();
  }

  @Override
  public Albums getAlbumsById(int id) {
        return albumsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Albums", "Id", id));
  }

  @Override
  public Albums updateAlbums(Albums albums, int id) {
    Albums existingAlbums = albumsRepository.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Albums", "Id", id));
    existingAlbums.setTitle(albums.getTitle());
    existingAlbums.setYear_released(albums.getYear_released());
    existingAlbums.setLabel(albums.getLabel());
    existingAlbums.setSong_id(albums.getSong_id());
    existingAlbums.setArtists_id(albums.getArtists_id());
    existingAlbums.setRecord_label_id(albums.getRecord_label_id());
    
    albumsRepository.save(existingAlbums);

    return existingAlbums;
  }

  @Override
  public void deleteAlbums(int id) {
    Albums existingAlbums = albumsRepository.findById(id).orElseThrow(() 
        -> new ResourceNotFoundException("Albums", "Id", id));
    albumsRepository.deleteById(id);
  }



}
