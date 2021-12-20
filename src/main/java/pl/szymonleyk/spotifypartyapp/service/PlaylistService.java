package pl.szymonleyk.spotifypartyapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szymonleyk.spotifypartyapp.model.Playlist;
import pl.szymonleyk.spotifypartyapp.repository.PlaylistRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaylistService {

   private final PlaylistRepository playlistRepository;

   public List<Playlist> getPlaylists(){
       return playlistRepository.findAll();
   }

    public List<Playlist> findByPartyId(int id) {
       return playlistRepository.findByPartyId(id);
    }

    public Optional<Playlist> findById(int id) {
       return playlistRepository.findById(id);
    }
}
