package pl.szymonleyk.spotifypartyapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uri;
    private String name;

    @OneToMany
    private Set<Track> tracks;

    @ManyToOne
    @JoinColumn(name="party_id")
    private Party party;

    public Playlist(String uri, String name) {
        this.uri = uri;
        this.name = name;
    }
}
