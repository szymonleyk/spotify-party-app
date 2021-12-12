package pl.szymonleyk.spotifypartyapp.spotify.api.client.response;

import lombok.Getter;
import lombok.Setter;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.dto.TrackItem;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class TracksResponse implements Serializable {
    private String href;
    private List<TrackItem> items;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;
}
