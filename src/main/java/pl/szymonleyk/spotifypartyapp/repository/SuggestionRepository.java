package pl.szymonleyk.spotifypartyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szymonleyk.spotifypartyapp.model.Suggestion;

import java.util.List;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Integer> {
    List<Suggestion> findAllByPartyId(Integer partyId);
}
