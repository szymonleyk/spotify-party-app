package pl.szymonleyk.spotifypartyapp.restclient.authorize;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;
import pl.szymonleyk.spotifypartyapp.config.Client;
import pl.szymonleyk.spotifypartyapp.restclient.authorize.dto.Token;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorizeService {
    private final Client client;
    private final SpotifyRestClient spotifyRestClient;

    public Map authorizeParams() {
        return Map.of(
                "client_id", client.getId(),
                "response_type", "code",
                "redirect_uri", UriUtils.decode("http://localhost:8080/callback", "UTF-8"),
                "scope", scopes());
    }

    private String scopes() {
        return List.of(Scope.values()).stream().map(scope -> scope.getName()).collect(Collectors.joining(" "));
    }

    public Token getToken(String code) {
        return spotifyRestClient.getToken(code);
    }
}
