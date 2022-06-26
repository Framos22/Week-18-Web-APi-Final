package Final.Music.service;

import java.util.List;
import Final.Music.model.Albums;

public interface AlbumsService {

  Albums saveAlbums(Albums albums);

  List<Albums> getAllAlbums();

  Albums getAlbumsById(int id);

  Albums updateAlbums(Albums albums, int id);

  void deleteAlbums(int Id);
}
