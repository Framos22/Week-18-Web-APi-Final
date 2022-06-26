package Final.Music.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Final.Music.exception.ResourceNotFoundException;
import Final.Music.model.Songs;
import Final.Music.repository.SongsRepository;
import Final.Music.service.SongsService;

@Service
public class SongsServiceImpl implements SongsService {
  
  private SongsRepository songsRepository;
  @Autowired
  
  public SongsServiceImpl(SongsRepository songsRepository) {
    super();
    this.songsRepository = songsRepository;
  }
  
  @Override
  public Songs saveSongs(Songs songs) {
    return songsRepository.save(songs);
  }

  @Override
  public List<Songs> getAllSongs() {
    return songsRepository.findAll();
  }

  @Override
  public Songs getSongsById(int id) {
    return songsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Song", "Id", id));
    
   
  }

  @Override
  public Songs updateSongs(Songs songs, int id) {
    Songs existingSongs = songsRepository.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Song", "Id", id)); existingSongs.setSong(songs.getSong());

        songsRepository.save(existingSongs);
    return existingSongs;
    
  }

  @Override
  public void deleteSongs(int id) {
    Songs existingSongs = songsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Song", "Id", id));
    songsRepository.deleteById(id);    
  }

}
