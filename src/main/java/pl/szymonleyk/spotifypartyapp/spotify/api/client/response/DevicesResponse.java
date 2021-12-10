package pl.szymonleyk.spotifypartyapp.spotify.api.client.response;

import lombok.*;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.dto.Device;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class DevicesResponse implements Serializable {
    private List<Device> devices;
}
