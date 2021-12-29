package pl.szymonleyk.spotifypartyapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Suggestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @ManyToOne
    @JoinColumn(name = "track_id")
    private Track track;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SuggestionStatus suggestionStatus;

    public Suggestion(Party party, Track track) {
        this.party = party;
        this.track = track;
        this.suggestionStatus = SuggestionStatus.ON_HOLD;
    }
}
