package pl.szymonleyk.spotifypartyapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RequiredArgsConstructor
public class ArtistsController {

    private final WebClient webClient;

    @GetMapping("/artists")
    public String getArtists()
    {
        String resourceUri = "https://api.spotify.com/v1/me/top/artists";

        String body = webClient
                .get()
                .uri(resourceUri)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(body);

        return "redirect:/home";
    }
}