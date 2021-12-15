package pl.szymonleyk.spotifypartyapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import pl.szymonleyk.spotifypartyapp.model.Track;
import pl.szymonleyk.spotifypartyapp.repository.TrackRepository;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Controller
@RequiredArgsConstructor
public class PlayerController {
    @Qualifier("spotifyQueue")
    private final ConcurrentLinkedQueue<Track> spotifyQueue;
    private final TrackRepository trackRepository;

    @GetMapping("/play/{id}")
    public String partyDetailsTracks(@PathVariable int id, HttpServletRequest request){
//        spotifyApiClient.addItemToPlaybackQueue(uri);
        Optional<Track> maybeTrack = trackRepository.findById(id);
        if(maybeTrack.isPresent()){
            Track track = maybeTrack.get();

                spotifyQueue.offer(track);

        }

        return "redirect:"+request.getHeader("Referer");
    }
}
