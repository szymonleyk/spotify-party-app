package pl.szymonleyk.spotifypartyapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.szymonleyk.spotifypartyapp.model.Suggestion;
import pl.szymonleyk.spotifypartyapp.repository.SuggestionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuggestionService {

    private final SuggestionRepository suggestionRepository;

    public void save(Suggestion suggestion){
        suggestionRepository.save(suggestion);
    }

    public List<Suggestion> findAll(int partyId){
        return suggestionRepository.findAllByPartyId(partyId);
    }

    public Optional<Suggestion> findById(Integer suggestionId) {
        return suggestionRepository.findById(suggestionId);
    }
}
