package pl.szymonleyk.spotifypartyapp.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import pl.szymonleyk.spotifypartyapp.model.Track;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.BlockingQueue;

@Log4j2
@Component
@RequiredArgsConstructor
public class Player {
    private final ThreadPoolTaskScheduler taskScheduler;
    private final BlockingQueue<Track> spotifyQueue;
    private final SpotifyApiClient spotifyApiClient;
    private final CronTrigger cronTrigger;

    @PostConstruct
    public void scheduleRunnableWithCronTrigger() {
            taskScheduler.schedule(new RunnableTaskAddItemToSpotifyPlayback(spotifyQueue, spotifyApiClient), cronTrigger);
    }

}
