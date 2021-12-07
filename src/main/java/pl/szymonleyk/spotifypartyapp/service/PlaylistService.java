package pl.szymonleyk.spotifypartyapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szymonleyk.spotifypartyapp.model.Playlist;
import pl.szymonleyk.spotifypartyapp.repository.PlaylistRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {

   private final PlaylistRepository playlistRepository;

   public List<Playlist> getPlaylists(){
       return playlistRepository.findAll();
   }
}
