package pl.szymonleyk.spotifypartyapp.spotify.api.client.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Track implements Serializable {
    private int durationMs;
    private String id;
    private String name;
    private int popularity;
    private String type;
    private String uri;
    private String href;
}
