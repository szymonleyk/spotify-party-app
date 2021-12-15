package pl.szymonleyk.spotifypartyapp.schedule;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.szymonleyk.spotifypartyapp.model.Track;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Configuration
public class QueueConfig {
    @Bean
    @Qualifier("spotifyQueue")
    public ConcurrentLinkedQueue<Track> spotifyQueue() {
        return new ConcurrentLinkedQueue<>();
    }
}
