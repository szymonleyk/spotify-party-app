package pl.szymonleyk.spotifypartyapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.szymonleyk.spotifypartyapp.model.Playlist;
import pl.szymonleyk.spotifypartyapp.service.PlaylistService;

import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class PartyController {

    private final PlaylistService playlistService;

    @GetMapping("/party-add")
    public String addForm(Model model) {
        model.addAttribute("playlists", playlistService.getPlaylists());
        return "party-add.html";
    }

//    @PostMapping("/party-add")
//    public String add(){
//
//    }
}
