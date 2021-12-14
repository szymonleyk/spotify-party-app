package pl.szymonleyk.spotifypartyapp.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String spotifyId;
    private String uri;
    private String name;

    @Column(name="duration_ms")
    private int durationMs;
    private int popularity;
    private String type;
    private String href;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    public Track(pl.szymonleyk.spotifypartyapp.spotify.api.client.dto.Track track, Playlist playlist){
        spotifyId = track.getId();
        uri = track.getUri();
        name = track.getName();
        durationMs = track.getDurationMs();
        popularity = track.getPopularity();
        type = track.getType();
        href = track.getHref();
        this.playlist = playlist;
    }
}
