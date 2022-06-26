package Final.Music.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Final.Music.exception.ResourceNotFoundException;
import Final.Music.model.Artists;
import Final.Music.repository.ArtistsRepository;
import Final.Music.service.ArtistsService;

@Service
public class ArtistsServiceImpl implements ArtistsService {
  
  private ArtistsRepository artistsRepository;
  
  @Autowired
  public ArtistsServiceImpl(ArtistsRepository artistsRepository) {
    super();
    this.artistsRepository = artistsRepository;
}

  @Override
  public Artists saveArtists(Artists artists) {
        return artistsRepository.save(artists);
  }

  @Override
  public List<Artists> getAllArtists() {
        return artistsRepository.findAll();
  }

  @Override
  public Artists getArtistsById(int id) {
    return artistsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Artist", "Id", id));
  }

  @Override
  public Artists updateArtists(Artists artists, int id) {
    Artists existingArtists = artistsRepository.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Artists", "Id", id));
            existingArtists.setFirst_name(artists.getFirst_name());
            existingArtists.setLast_name(artists.getLast_name());
            
            artistsRepository.save(existingArtists);
        return existingArtists;
  }

  @Override
  public void deleteArtists(int id) {
    Artists existingArtists = artistsRepository.findById(id).orElseThrow(() 
        -> new ResourceNotFoundException("Artists", "Id", id));
    artistsRepository.deleteById(id);
        
  }
  
 
  

}


