package pl.szymonleyk.spotifypartyapp.spotify.api.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.response.DevicesResponse;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.response.PlaylistsResponse;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.response.TracksResponse;

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

    public void addItemToPlaybackQueue(String uri) {
        webClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("/me/player/queue").queryParam("uri", uri).queryParam("device_id", getDevices().getDevices().get(0).getId()).build())
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}