package pl.szymonleyk.spotifypartyapp.spotify.api.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Item implements Serializable {
    private String uri;
    private String name;
}
