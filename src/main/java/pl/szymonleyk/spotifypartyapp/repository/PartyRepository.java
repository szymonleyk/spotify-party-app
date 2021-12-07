package pl.szymonleyk.spotifypartyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szymonleyk.spotifypartyapp.model.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
}
