package pl.szymonleyk.spotifypartyapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name="start_date")
    private LocalDateTime startDate;

    @Column(name="end_date")
    private LocalDateTime endDate;

    private String description;

    private String image;

    @OneToMany(mappedBy = "party", cascade = CascadeType.ALL)
    private List<Playlist> playlists;

    @Column(name = "owner_spotify_user_id")
    private String ownerSpotifyUserId;
}
