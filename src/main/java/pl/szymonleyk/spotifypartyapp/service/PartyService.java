package pl.szymonleyk.spotifypartyapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szymonleyk.spotifypartyapp.model.Party;
import pl.szymonleyk.spotifypartyapp.repository.PartyRepository;

@Service
@RequiredArgsConstructor
public class PartyService {
    private final PartyRepository partyRepository;

    public void save(Party party){
        partyRepository.save(party);
    }

}
