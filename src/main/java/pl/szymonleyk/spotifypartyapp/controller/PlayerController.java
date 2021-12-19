package pl.szymonleyk.spotifypartyapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.szymonleyk.spotifypartyapp.model.Track;
import pl.szymonleyk.spotifypartyapp.repository.TrackRepository;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;

@Log4j2
@Controller
@RequiredArgsConstructor
public class PlayerController {
    private final BlockingQueue<Track> spotifyQueue;
    private final TrackRepository trackRepository;

    @GetMapping("/play/{id}")
    public String partyDetailsTracks(@PathVariable int id, HttpServletRequest request){
        Optional<Track> maybeTrack = trackRepository.findById(id);
        if(maybeTrack.isPresent()){
            try {
                Track track = maybeTrack.get();
                spotifyQueue.put(track);
                log.info("Track added to queue: "+track.getName());
            } catch (InterruptedException e) {
                log.info("Queue full. Wait...");
            }
        }
        return "redirect:"+request.getHeader("Referer");
    }
}
