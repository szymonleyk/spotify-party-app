package pl.szymonleyk.spotifypartyapp.restclient.authorize.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PlaylistsResponse implements Serializable {
    private String href;
    private List<Item> items;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;
}
