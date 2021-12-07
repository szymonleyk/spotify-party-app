package pl.szymonleyk.spotifypartyapp.converter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.szymonleyk.spotifypartyapp.model.Playlist;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlaylistConverter implements Converter<String, Playlist> {

    private final SpotifyApiClient spotifyApiClient;

    @Override
    public Playlist convert(String uri) {
        log.info("Trying to convert uri=" + uri + " into a playlist");

        List<Playlist> allPlaylists = spotifyApiClient.getPlaylists().getItems().stream().map(i -> new Playlist(i.getUri(), i.getName())).collect(Collectors.toList());

        return allPlaylists.stream().filter(p -> p.getUri().equals(uri)).findFirst().get();
    }
}
