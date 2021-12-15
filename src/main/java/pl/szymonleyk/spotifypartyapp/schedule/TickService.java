package pl.szymonleyk.spotifypartyapp.schedule;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.szymonleyk.spotifypartyapp.model.Track;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@Getter
@Log4j2
public class TickService {
    @Autowired
    @Qualifier("spotifyQueue")
    private ConcurrentLinkedQueue<Track> spotifyQueue;
    @Autowired
    private SpotifyApiClient spotifyApiClient;

    private static final int MINUTE = 60_000;
    private static final int SECUNDE = 1_000;

//    @PostConstruct
//    public void init(){
//        try {
////            spotifyQueue.put(new Track("spotify:track:6RQtvdmW0fnWv1VOKpgYcq", 241066));
//        } catch (InterruptedException e) {
//            log.info("Czekam... pełno");
//        }
//    }

    private Integer delay = 0;

    public void tick() {
        while (spotifyQueue.peek() != null) {
            Track track = spotifyQueue.poll();
            delay = track.getDurationMs();
            spotifyApiClient.addItemToPlaybackQueue(track.getUri());
            log.info(LocalDateTime.now() + " | Task: " + track.getName() + " | " + track.getDurationMs());
        }
    }

}
