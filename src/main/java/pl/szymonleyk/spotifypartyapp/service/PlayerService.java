package pl.szymonleyk.spotifypartyapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szymonleyk.spotifypartyapp.model.Track;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.dto.Device;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.response.DevicesResponse;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final SpotifyApiClient spotifyApiClient;
    private final TrackService trackService;

    public Optional<String> getActiveDeviceId(){
        List<Device> devices = spotifyApiClient.getDevices().getDevices();
        return devices.stream().filter(d -> d.getIsActive()).map(d -> d.getId()).findFirst();
    }

    public void sendTrackToSpotify(String uri, String deviceId) {
        spotifyApiClient.addItemToPlaybackQueue(uri, deviceId);
        setTrackInactive(uri);
    }

    private void setTrackInactive(String uri) {
        Track track = trackService.findByUri(uri);
        track.setIsActive(false);
        trackService.save(track);
    }

    public void unlockTrack(String uri) {
        Track track = trackService.findByUri(uri);
        track.setIsActive(true);
        trackService.save(track);
    }
}
