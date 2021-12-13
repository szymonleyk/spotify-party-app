package pl.szymonleyk.spotifypartyapp.spotify.api.client.response;

import lombok.*;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.dto.Device;

import java.io.Serializable;

@Getter
@Setter
public class PlaybackStateResponse implements Serializable {
    private Device device;
    private boolean isPlaying;
    private int progressMs;

}
