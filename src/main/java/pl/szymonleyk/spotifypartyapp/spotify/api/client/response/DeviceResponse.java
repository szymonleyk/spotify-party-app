package pl.szymonleyk.spotifypartyapp.spotify.api.client.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class DeviceResponse implements Serializable {
    private String id;
    private boolean isActive;
    private boolean isPrivateSession;
    private boolean isRestricted;
    private String name;
    private String type;
    private int volumePercentage;
}
