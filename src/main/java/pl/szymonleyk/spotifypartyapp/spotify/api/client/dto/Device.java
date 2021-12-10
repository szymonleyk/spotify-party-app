package pl.szymonleyk.spotifypartyapp.spotify.api.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Device implements Serializable {
    private String id;
    private boolean isActive;
    private boolean isPrivateSession;
    private boolean isRestricted;
    private String name;
    private String type;
    private int volumePercentage;
}
