package pl.szymonleyk.spotifypartyapp.restclient.authorize.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Token implements Serializable {
    private String accessToken;
    private String tokenType;
    private String scope;
    private int expiresIn;
    private String refreshToken;
}
