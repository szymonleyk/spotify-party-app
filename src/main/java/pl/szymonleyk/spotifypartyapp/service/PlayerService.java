package pl.szymonleyk.spotifypartyapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szymonleyk.spotifypartyapp.model.Playlist;
import pl.szymonleyk.spotifypartyapp.model.Track;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.dto.Device;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.response.DevicesResponse;

import java.util.List;
import java.util.Optional;
import java.util.Queue;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final SpotifyApiClient spotifyApiClient;
    private final TrackService trackService;
    private final PlaylistService playlistService;

    public Optional<String> getActiveDeviceId() {
        List<Device> devices = spotifyApiClient.getDevices().getDevices();
        return devices.stream().filter(d -> d.getIsActive()).map(d -> d.getId()).findFirst();
    }

    public void sendTrackToSpotify(int playlistId, String uri, String deviceId) {
        spotifyApiClient.addItemToPlaybackQueue(uri, deviceId);
        setTrackInactive(playlistId, uri);
    }

    public void sendRandomTracksToSpotify(int playlistId, String deviceId, int limit) {
        Queue<String> tracks = trackService.findRandomTracks(playlistId, limit);
        tracks.forEach(uri -> {
            spotifyApiClient.addItemToPlaybackQueue(uri, deviceId);
            setTrackInactive(playlistId, uri);
        });
    }

    private void setTrackInactive(int id, String uri) {
        Optional<Playlist> maybePlaylist = playlistService.findById(id);
        if (maybePlaylist.isPresent()) {
            Track track = trackService.findByUri(maybePlaylist.get(), uri);
            track.setIsActive(false);
            trackService.save(track);
        }
    }

    public void unlockTrack(int id, String uri) {
        Optional<Playlist> maybePlaylist = playlistService.findById(id);
        if (maybePlaylist.isPresent()) {
            Track track = trackService.findByUri(maybePlaylist.get(), uri);
            track.setIsActive(true);
            trackService.save(track);
        }
    }
}
