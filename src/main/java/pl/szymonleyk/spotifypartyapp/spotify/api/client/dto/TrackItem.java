package pl.szymonleyk.spotifypartyapp.spotify.api.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TrackItem implements Serializable {
    private Track track;
}
