package pl.szymonleyk.spotifypartyapp.restclient.authorize.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Item implements Serializable {
    private String name;
    private String uri;
}
