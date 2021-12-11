package pl.szymonleyk.spotifypartyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.szymonleyk.spotifypartyapp.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUsernameAndPassword(String login, String password);
    User findDistinctByUsername(String login);
}
