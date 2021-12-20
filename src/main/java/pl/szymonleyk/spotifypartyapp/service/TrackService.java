package pl.szymonleyk.spotifypartyapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szymonleyk.spotifypartyapp.model.Track;
import pl.szymonleyk.spotifypartyapp.repository.TrackRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackService {
    private final TrackRepository trackRepository;

    public List<Track> findByPlaylistId(int id){
        return trackRepository.findByPlaylistId(id);
    }

    public int countTracksByIsActiveAndPlaylistId(int id){
        return trackRepository.countTracksByIsActiveAndPlaylistId(true, id);
    }

    public Track findByUri(String uri){
        return trackRepository.findFirstByUri(uri);
    }

    public void save(Track track){
        trackRepository.save(track);
    }
}
