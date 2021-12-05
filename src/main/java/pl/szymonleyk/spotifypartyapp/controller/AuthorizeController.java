package pl.szymonleyk.spotifypartyapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import pl.szymonleyk.spotifypartyapp.restclient.authorize.AuthorizeService;
import pl.szymonleyk.spotifypartyapp.restclient.authorize.SpotifyUrl;
import pl.szymonleyk.spotifypartyapp.restclient.authorize.dto.Token;

@Controller
@AllArgsConstructor
public class AuthorizeController {

    private final AuthorizeService authorizeService;

    @GetMapping("/")
    public String login(){
        return "login.html";
    }

    @GetMapping("/authorize")
    public RedirectView login(RedirectAttributes attributes){
        attributes.addAllAttributes(authorizeService.authorizeParams());
        return new RedirectView(SpotifyUrl.ACCOUNTS +"/authorize");
    }

    @GetMapping("/callback")
    public String home(@RequestParam String code){
        Token token = authorizeService.getToken(code);
        return "redirect:/home";
    }

}
