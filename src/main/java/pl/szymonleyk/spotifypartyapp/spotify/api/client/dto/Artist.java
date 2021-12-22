package pl.szymonleyk.spotifypartyapp.spotify.api.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Artist implements Serializable {
    private String id;
    private String name;
}
