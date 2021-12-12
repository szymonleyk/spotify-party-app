package pl.szymonleyk.spotifypartyapp.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
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

    @Column(name = "spotify_id")
    private String spotifyId;
    private String uri;
    private String name;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private List<Track> tracks;

    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    public Playlist(String spotifyId, String uri, String name) {
        this.spotifyId = spotifyId;
        this.uri = uri;
        this.name = name;
    }
}
