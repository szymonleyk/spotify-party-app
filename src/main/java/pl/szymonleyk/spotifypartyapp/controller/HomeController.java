package pl.szymonleyk.spotifypartyapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final SpotifyApiClient spotifyApiClient;

    @GetMapping("/")
    public String main(){
        return "redirect:/party-list";
    }

    @GetMapping("/playlists")
    public String getPlaylists(){
        spotifyApiClient.getDevices();
        return "redirect:/";
    }
}