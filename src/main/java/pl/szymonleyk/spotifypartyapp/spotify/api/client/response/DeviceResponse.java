package pl.szymonleyk.spotifypartyapp.spotify.api.client.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class DeviceResponse implements Serializable {
    private String id;
    private boolean is_active;
    private boolean is_private_session;
    private boolean is_restricted;
    private String name;
    private String type;
    private int volume_percentage;
}
