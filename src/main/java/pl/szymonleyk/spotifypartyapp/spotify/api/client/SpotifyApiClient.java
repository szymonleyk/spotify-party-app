package pl.szymonleyk.spotifypartyapp.spotify.api.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.response.DevicesResponse;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.response.PlaybackStateResponse;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.response.PlaylistsResponse;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.response.TracksResponse;

@Log4j2
@Component
@RequiredArgsConstructor
public class SpotifyApiClient {

    private final WebClient webClient;

    public PlaylistsResponse getPlaylists() {
        PlaylistsResponse body = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/me/playlists").queryParam("limit", 50).build())
                .retrieve()
                .bodyToMono(PlaylistsResponse.class)
                .block();
        return body;
    }

    public DevicesResponse getDevices() {
        DevicesResponse body = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/me/player/devices").build())
                .retrieve()
                .bodyToMono(DevicesResponse.class)
                .block();
        return body;
    }

    public TracksResponse getTracks(String id) {
        TracksResponse body = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/playlists/" + id + "/tracks").queryParam("limit", 50).build())
                .retrieve()
                .bodyToMono(TracksResponse.class)
                .block();
        return body;
    }

    public PlaybackStateResponse getPlaybackState() {
        PlaybackStateResponse body = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/me/player").queryParam("market", "PL").build())
                .retrieve()
                .bodyToMono(PlaybackStateResponse.class)
                .block();
        return body;
    }

    public void addItemToPlaybackQueue(String uri, String deviceId) {
        webClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("/me/player/queue").queryParam("uri", uri).queryParam("device_id", deviceId).build())
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(System.out::println);
    }
}