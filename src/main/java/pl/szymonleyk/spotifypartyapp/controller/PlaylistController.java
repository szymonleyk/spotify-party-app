package pl.szymonleyk.spotifypartyapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.szymonleyk.spotifypartyapp.restclient.authorize.dto.PlaylistsResponse;
import pl.szymonleyk.spotifypartyapp.restclient.authorize.SpotifyRestClient;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class PlaylistController {

    private final SpotifyRestClient spotifyRestClient;

    @GetMapping("/playlists")
    public String getPlaylists (Model model){
        PlaylistsResponse playlists = spotifyRestClient.getAllPlaylists();
        model.addAttribute("playlists", playlists.getItems().stream().map(i -> i.getName()).collect(Collectors.toList()));
        return "playlists.html";
    }
}