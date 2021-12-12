package pl.szymonleyk.spotifypartyapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.szymonleyk.spotifypartyapp.model.Party;
import pl.szymonleyk.spotifypartyapp.model.Playlist;
import pl.szymonleyk.spotifypartyapp.model.Track;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;
import pl.szymonleyk.spotifypartyapp.service.PartyService;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.response.TracksResponse;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class PartyController {

    private final SpotifyApiClient spotifyApiClient;
    private final PartyService partyService;

    @GetMapping("/party-add")
    public String addForm(Model model) {
        model.addAttribute("party", new Party());
        model.addAttribute("allPlaylists", spotifyApiClient.getPlaylists().getItems().stream().map(i -> new Playlist(i.getId(), i.getUri(), i.getName())).collect(Collectors.toList()));
        return "party-add.html";
    }

    @PostMapping("/party-add")
    public String add(@ModelAttribute("party") Party party){
        party.getPlaylists().forEach(playlist -> {
            playlist.setParty(party);
            TracksResponse tracksResponse = spotifyApiClient.getTracks(playlist.getSpotifyId());
            playlist.setTracks(tracksResponse.getItems().stream().map(trackItem -> new Track(trackItem.getTrack(), playlist)).collect(Collectors.toList()));
        });
        partyService.save(party);
        return "redirect:/party-list";
    }

    @GetMapping("/party-list")
    public String partyList(Model model){
        model.addAttribute("parties", partyService.findAll());
        return "party-list.html";
    }
}
