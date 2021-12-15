package pl.szymonleyk.spotifypartyapp.spotify.api.client.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Device implements Serializable {
    private String id;
    private Boolean isActive;
    private Boolean isPrivateSession;
    private Boolean isRestricted;
    private String name;
    private String type;
    private int volumePercent;
}
