package pl.szymonleyk.spotifypartyapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.szymonleyk.spotifypartyapp.model.Party;
import pl.szymonleyk.spotifypartyapp.model.Suggestion;
import pl.szymonleyk.spotifypartyapp.model.Track;
import pl.szymonleyk.spotifypartyapp.service.PartyService;
import pl.szymonleyk.spotifypartyapp.service.PlayerService;
import pl.szymonleyk.spotifypartyapp.service.SuggestionService;
import pl.szymonleyk.spotifypartyapp.service.TrackService;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;
    private final SuggestionService suggestionService;
    private final TrackService trackService;
    private final PartyService partyService;
    private final SpotifyApiClient spotifyApiClient;

    @GetMapping("/party-details/{partyId}/playlists/{playlistId}/play/{uri}")
    public String partyDetailsTracks(@AuthenticationPrincipal OAuth2User principal, @PathVariable Integer partyId, @PathVariable Integer playlistId, @PathVariable String uri, HttpServletRequest request) {

        Party party = partyService.findById(partyId).get();
        Track track = trackService.findByUri(uri).stream().findFirst().get();
        if (party.getOwnerSpotifyUserId().equals(principal.getAttribute("id"))) {
            Optional<String> maybeDeviceId = playerService.getActiveDeviceId();
            if (maybeDeviceId.isPresent()) {
                playerService.sendTrackToSpotify(track, maybeDeviceId.get());
            }
            return "redirect:" + request.getHeader("Referer");
        } else {
            return "redirect:/party-details/" + party.getId() + "/suggestion/" + track.getSpotifyId();
        }
    }

    @GetMapping("/party-details/{playlistId}/play")
    public String partyDetailsTracksLimit(@PathVariable Integer playlistId, @RequestParam Integer limit, HttpServletRequest request) {
        Optional<String> maybeDeviceId = playerService.getActiveDeviceId();
        if (maybeDeviceId.isPresent()) {
            playerService.sendRandomTracksToSpotify(playlistId, maybeDeviceId.get(), limit);
        }

        return "redirect:" + request.getHeader("Referer");
    }

    @GetMapping("/party-details/{partyId}/suggestion/{trackSpotifyId}")
    public String partyDetailsTracksProposal(@PathVariable Integer partyId, @PathVariable String trackSpotifyId, HttpServletRequest request) {
        Party party = partyService.findById(partyId).get();
        List<Track> tracks = trackService.findBySpotifyId(trackSpotifyId);
        Optional<Track> maybeTrack = tracks.stream().filter(t -> t.getPlaylist().getParty().getId().equals(partyId)).findFirst();
        Track track;
        if (maybeTrack.isPresent()) {
            track = maybeTrack.get();
        } else {
            track = new Track(spotifyApiClient.getTrack(trackSpotifyId));
            trackService.save(track);
        }
        suggestionService.save(new Suggestion(party, track));
        return "redirect:" + request.getHeader("Referer");
    }

    @GetMapping("/party-details/{id}/unlock/{uri}")
    public String unlockTrack(@PathVariable String id, @PathVariable String uri, HttpServletRequest request) {
        playerService.unlockTrack(Integer.valueOf(id), uri);

        return "redirect:" + request.getHeader("Referer");
    }
}
