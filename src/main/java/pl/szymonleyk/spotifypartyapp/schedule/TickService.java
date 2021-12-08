package pl.szymonleyk.spotifypartyapp.schedule;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pl.szymonleyk.spotifypartyapp.model.Track;

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Service
@Getter
public class TickService {
    private BlockingQueue<Track> arrayBlockingQueue = new ArrayBlockingQueue<>(5);

    private static final int MINUTE = 60_000;
    private static final int SECUNDE = 1_000;
    public TickService() {
        try {
            arrayBlockingQueue.put(new Track("One1", 20*SECUNDE));
            arrayBlockingQueue.put(new Track("One2", 5*SECUNDE));
            arrayBlockingQueue.put(new Track("One3", 18*SECUNDE));
            arrayBlockingQueue.put(new Track("One4", 10*SECUNDE));
            arrayBlockingQueue.put(new Track("One5", 17*SECUNDE));
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Czekam... pełno");
        }
    }

    private Integer delay = 0;

    public void tick() {
        try {
            Track track = arrayBlockingQueue.take();
            delay = track.getDuration();
            System.out.println(LocalDateTime.now()+" | Task: "+track.getName() +" | "+track.getDuration());
        } catch (InterruptedException e) {
            System.out.println("Czekam... pusto");
            e.printStackTrace();
        }
    }

}
