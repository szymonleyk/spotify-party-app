package pl.szymonleyk.spotifypartyapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szymonleyk.spotifypartyapp.model.Playlist;
import pl.szymonleyk.spotifypartyapp.model.Track;
import pl.szymonleyk.spotifypartyapp.repository.TrackRepository;

import java.util.*;
import java.util.stream.Collectors;

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

    public Track findByUri(Playlist playlist, String uri){
        return trackRepository.findFirstByPlaylistAndUri(playlist, uri);
    }

    public void save(Track track){
        trackRepository.save(track);
    }

    public Queue<Track> findRandomTracks(int playlistId, int limit) {
        List<Track> tracks = trackRepository.findRandomTracks(playlistId).stream().limit(limit).collect(Collectors.toList());
        Collections.shuffle(tracks);
        return new LinkedList<>(tracks);
    }

    public List<Track> findByUri(String uri){
        return trackRepository.findAllByUri(uri);
    }

    public Optional<Track> findById(Integer id){
        return trackRepository.findById(id);
    }

    public List<Track> findBySpotifyId(String id){
        return trackRepository.findAllBySpotifyId(id);
    }
}
