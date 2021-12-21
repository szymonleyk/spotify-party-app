package pl.szymonleyk.spotifypartyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.szymonleyk.spotifypartyapp.model.Playlist;
import pl.szymonleyk.spotifypartyapp.model.Track;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
    List<Track> findByPlaylistId(int id);
    Track findFirstByPlaylistAndUri(Playlist playlist, String uri);
    int countTracksByIsActiveAndPlaylistId(boolean isActive, int id);

    @Query("select t from Track t where t.playlist.id = :playlistId and t.isActive = true order by rand()")
    List<Track> findRandomTracks(int playlistId);
}
