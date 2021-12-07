package pl.szymonleyk.spotifypartyapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String main(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        return "home.html";
    }
}
