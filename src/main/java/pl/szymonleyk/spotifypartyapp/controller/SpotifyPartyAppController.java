package pl.szymonleyk.spotifypartyapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpotifyPartyAppController {

    private final SpotifyPartyAppClient spotifyPartyAppClient;

    public SpotifyPartyAppController(SpotifyPartyAppClient spotifyPartyAppClient) {
        this.spotifyPartyAppClient = spotifyPartyAppClient;
    }

    @GetMapping("/playlists")
    public String getPlaylists (Model model){
        List<Playlist> playlists = spotifyPartyAppClient.getAllPlaylists();
        model.addAttribute("playlists", playlists);
        return "playlists.xhtml";
    }
}