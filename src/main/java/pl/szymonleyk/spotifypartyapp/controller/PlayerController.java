package pl.szymonleyk.spotifypartyapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.szymonleyk.spotifypartyapp.service.PlayerService;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.dto.Device;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.response.DevicesResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("/play/{uri}")
    public String partyDetailsTracks(@PathVariable String uri, HttpServletRequest request){
        Optional<String> maybeDeviceId = playerService.getActiveDeviceId();
        if(maybeDeviceId.isPresent()) {
            playerService.sendTrackToSpotify(uri, maybeDeviceId.get());
        }

        return "redirect:"+request.getHeader("Referer");
    }

    @GetMapping("/unlock/{uri}")
    public String unlockTrack(@PathVariable String uri, HttpServletRequest request){
        playerService.unlockTrack(uri);

        return "redirect:"+request.getHeader("Referer");
    }
}
