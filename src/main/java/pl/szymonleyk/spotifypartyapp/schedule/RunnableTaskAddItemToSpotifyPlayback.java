package pl.szymonleyk.spotifypartyapp.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import pl.szymonleyk.spotifypartyapp.model.Track;
import pl.szymonleyk.spotifypartyapp.spotify.api.client.SpotifyApiClient;

import java.util.concurrent.BlockingQueue;

@Log4j2
@RequiredArgsConstructor
public class RunnableTaskAddItemToSpotifyPlayback implements Runnable {
    private final BlockingQueue<Track> spotifyQueue;
    private final SpotifyApiClient spotifyApiClient;


    @Override
    public void run() {
        log.info("Jestem w wątku.");
        Track track = spotifyQueue.poll();
        if(track != null) {
            spotifyApiClient.addItemToPlaybackQueue(track.getUri(), "f90dbf33b126763c4d7a33ccf6b9cc7a4bceb308");
            log.info("Wysłałem.");
        }
    }
}

