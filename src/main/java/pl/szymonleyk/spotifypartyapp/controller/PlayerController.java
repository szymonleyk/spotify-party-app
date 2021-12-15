package pl.szymonleyk.spotifypartyapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class PlayerController {
    private final SpotifyApiClient spotifyApiClient;

    @GetMapping("/play/{uri}")
    public String partyDetailsTracks(@PathVariable String uri, HttpServletRequest request){
        spotifyApiClient.addItemToPlaybackQueue(uri);
        return "redirect:"+request.getHeader("Referer");
    }
}
