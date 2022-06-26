package Final.Music.service;

import java.util.List;
import Final.Music.model.Songs;

public interface SongsService {
  
  Songs saveSongs(Songs songs);

  List<Songs> getAllSongs();

  Songs getSongsById(int id);

  Songs updateSongs(Songs songs, int Id);

  void deleteSongs(int Id);

}
