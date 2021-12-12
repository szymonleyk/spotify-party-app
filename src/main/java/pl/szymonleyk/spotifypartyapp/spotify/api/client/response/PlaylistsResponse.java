package pl.szymonleyk.spotifypartyapp.spotify.api.client.response;

import lombok.Getter;
import lombok.Setter;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.dto.PlaylistItem;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PlaylistsResponse implements Serializable {
    private String href;
    private List<PlaylistItem> items;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;
}
