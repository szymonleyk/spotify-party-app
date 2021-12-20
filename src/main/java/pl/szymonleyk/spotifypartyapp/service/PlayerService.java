package pl.szymonleyk.spotifypartyapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.dto.Device;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.response.DevicesResponse;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final SpotifyApiClient spotifyApiClient;

    public Optional<String> getActiveDeviceId(){
        List<Device> devices = spotifyApiClient.getDevices().getDevices();
        return devices.stream().filter(d -> d.getIsActive()).map(d -> d.getId()).findFirst();
    }
}
