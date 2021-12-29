package pl.szymonleyk.spotifypartyapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.szymonleyk.spotifypartyapp.service.PartyService;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.dto.Track;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.dto.TrackItem;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {

    private final PartyService partyService;
    private final SpotifyApiClient spotifyApiClient;

    @GetMapping("/{partyId}")
    public String searchForm(Model model, @PathVariable String partyId){
        model.addAttribute("party", partyService.findById(Integer.valueOf(partyId)).get());
        return "search.html";
    }

    @GetMapping
    public String search(Model model, @RequestParam String query, @RequestParam String partyId){
        List<Track> tracks = spotifyApiClient.search(query).getTracks().getItems();
        model.addAttribute("tracks", tracks);
        model.addAttribute("party", partyService.findById(Integer.valueOf(partyId)).get());
        return "search.html";
    }
}
