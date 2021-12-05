package pl.szymonleyk.spotifypartyapp.restclient.authorize;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;
import pl.szymonleyk.spotifypartyapp.config.Client;
import pl.szymonleyk.spotifypartyapp.restclient.authorize.dto.Token;

@Component
@RequiredArgsConstructor
public class SpotifyRestClient {

    private RestTemplate restTemplate = new RestTemplate();
    private final Client client;

    public Token getToken(String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(client.getId(), client.getSecret());


        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("code", code);
        map.add("redirect_uri", UriUtils.decode("http://localhost:8080/callback", "UTF-8"));
        map.add("grant_type","authorization_code");


        HttpEntity<MultiValueMap<String, String>> request =
                new HttpEntity<>(map, headers);

        ResponseEntity<Token> response = restTemplate.
                postForEntity(SpotifyUrl.ACCOUNTS +"/api/token", request, Token.class);

        return response.getBody();
    }

    ///

//    public String getDevice(){
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.setBearerAuth(getToken().getAccessToken());
//
//        HttpEntity<Void> request = new HttpEntity<>(headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(
//                SpotifyUrl.API_V1 +"/me/player/devices",
//                HttpMethod.GET,
//                request,
//                String.class
//        );
//
//        return response.getBody();
//    }
}
