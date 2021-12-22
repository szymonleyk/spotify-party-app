package pl.szymonleyk.spotifypartyapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szymonleyk.spotifypartyapp.model.Party;
import pl.szymonleyk.spotifypartyapp.repository.PartyRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartyService {
    private final PartyRepository partyRepository;

    public void save(Party party){
        partyRepository.save(party);
    }

    public List<Party> findAll() {
        return partyRepository.findAll();
    }

    public Optional<Party> findById(int id) {
        return partyRepository.findById(id);
    }
}
