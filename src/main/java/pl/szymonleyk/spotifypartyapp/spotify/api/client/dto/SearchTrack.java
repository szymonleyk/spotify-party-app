package pl.szymonleyk.spotifypartyapp.spotify.api.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class SearchTrack implements Serializable {
    private String href;
    private List<Track> items;
    private int limit;
    private int total;
}
