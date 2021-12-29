package pl.szymonleyk.spotifypartyapp.spotify.api.client.response;

import lombok.Getter;
import lombok.Setter;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.dto.SearchTrack;

import java.io.Serializable;

@Getter
@Setter
public class SearchResponse implements Serializable {
    private SearchTrack tracks;
}
