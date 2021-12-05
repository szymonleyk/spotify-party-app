package pl.szymonleyk.spotifypartyapp.restclient.authorize;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Scope {

    // Images
    UGC_IMAGE_UPLOAD("ugc-image-upload"),

    // Spotify Connect
    USER_READ_PLAYBACK_STATE("user-read-playback-state"),
    USER_MODIFY_PLAYBACK_STATE("user-modify-playback-state"),
    USER_READ_CURRENTLY_PLAYING("user-read-currently-playing"),

    // Users
    USER_READ_PRIVATE("user-read-private"),
    USER_READ_EMAIL("user-read-email"),

    // Follow
    USER_FOLLOW_MODIFY("user-follow-modify"),
    USER_FOLLOW_READ("user-follow-read"),

    // Library
    USER_LIBRARY_MODIFY("user-library-modify"),
    USER_LIBRARY_READ("user-library-read"),

    // Playback
    STREAMING("streaming"),
    APP_REMOTE_CONTROL("app-remote-control"),

    // Listening History
    USER_READ_PLAYBACK_POSITION("user-read-playback-position"),
    USER_TOP_READ("user-top-read"),
    USER_READ_RECENTLY_PLAYED("user-read-recently-played"),

    // Playlists
    PLAYLIST_MODIFY_PRIVATE("playlist-modify-private"),
    PLAYLIST_READ_COLLABORATIVE("playlist-read-collaborative"),
    PLAYLIST_READ_PRIVATE("playlist-read-private"),
    PLAYLIST_MODIFY_PUBLIC("playlist-modify-public");

    private String name;
}
