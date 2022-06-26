package Final.Music.service;

import java.util.List;
import Final.Music.model.Albums;
import Final.Music.model.Artists;

public interface ArtistsService {

  Artists saveArtists(Artists artists);

  List<Artists> getAllArtists();

  Artists getArtistsById(int id);

  Artists updateArtists(Artists artists, int id);

  void deleteArtists(int Id);

  
  }

 

