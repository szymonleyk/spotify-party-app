package pl.szymonleyk.spotifypartyapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.dto.Device;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.response.DevicesResponse;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final SpotifyApiClient spotifyApiClient;

    @GetMapping("/")
    public String main(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        return "home.html";
    }

    @GetMapping("/get-devices")
    public String getDevices() {
        List<DevicesResponse> devices = List.of(spotifyApiClient.getDevices());
        return "devices";
    }
}