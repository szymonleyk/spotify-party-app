package pl.szymonleyk.spotifypartyapp.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.szymonleyk.spotifypartyapp.model.Track;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Configuration
public class QueueConfig {

    private final int QUEUE_CAPACITY = 5;

    @Bean
    BlockingQueue<Track> spotifyQueue(){
        return new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    }
}
