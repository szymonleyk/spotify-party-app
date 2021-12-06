package pl.szymonleyk.spotifypartyapp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany
    private Set<Playlist> playlists;

}
