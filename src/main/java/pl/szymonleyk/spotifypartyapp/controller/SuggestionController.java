package pl.szymonleyk.spotifypartyapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.szymonleyk.spotifypartyapp.model.Party;
import pl.szymonleyk.spotifypartyapp.model.Suggestion;
import pl.szymonleyk.spotifypartyapp.model.SuggestionStatus;
import pl.szymonleyk.spotifypartyapp.model.Track;
import pl.szymonleyk.spotifypartyapp.service.PartyService;
import pl.szymonleyk.spotifypartyapp.service.PlayerService;
import pl.szymonleyk.spotifypartyapp.service.SuggestionService;
import pl.szymonleyk.spotifypartyapp.service.TrackService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class SuggestionController {

    private final SuggestionService suggestionService;
    private final PartyService partyService;
    private final PlayerService playerService;
    private final TrackService trackService;

    @GetMapping("/suggestions/{partyId}")
    public String suggestions(@AuthenticationPrincipal OAuth2User principal, Model model, @PathVariable Integer partyId) {

        Party party = partyService.findById(partyId).get();
        model.addAttribute("suggestions", suggestionService.findAll(partyId).stream().filter(s -> s.getSuggestionStatus().equals(SuggestionStatus.ON_HOLD)).collect(Collectors.toList()));
        model.addAttribute("party", party);
        model.addAttribute("isOwner", party.getOwnerSpotifyUserId().equals(principal.getAttribute("id")));
        return "suggestions.html";
    }

    @GetMapping("/suggestions/{suggestionId}/play/{trackId}")
    public String suggestions(Model model, @PathVariable Integer suggestionId, @PathVariable Integer trackId, HttpServletRequest request) {
        Optional<String> maybeDeviceId = playerService.getActiveDeviceId();
        if (maybeDeviceId.isPresent()) {
            Track track = trackService.findById(trackId).get();
            playerService.sendTrackToSpotify(track, maybeDeviceId.get());

            Suggestion suggestion = suggestionService.findById(suggestionId).get();
            suggestion.setSuggestionStatus(SuggestionStatus.ACCEPTED);
            suggestionService.save(suggestion);
        }

        return "redirect:" + request.getHeader("Referer");
    }
}
