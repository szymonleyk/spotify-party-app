-- drop table if exists suggestion;
-- drop table if exists track;
-- drop table if exists playlist;
-- drop table if exists party;

CREATE TABLE IF NOT EXISTS party
(
    id          int primary key auto_increment,
    name        varchar(255) not null,
    start_date  timestamp    not null,
    end_date    timestamp,
    description varchar(500),
    image       varchar(500),
    owner_spotify_user_id varchar(255) not null
);

CREATE TABLE IF NOT EXISTS playlist
(
    id         int primary key auto_increment,
    spotify_id varchar(255) not null,
    uri        varchar(255) not null,
    name       varchar(255) not null,
    party_id   int          not null,
    FOREIGN KEY (party_id) REFERENCES party (id)
);

CREATE TABLE IF NOT EXISTS track
(
    id          int primary key auto_increment,
    spotify_id  varchar(255) not null,
    uri         varchar(255) not null,
    name        varchar(255) not null,
    duration_ms int          not null,
    playlist_id int          null,
    popularity  int          not null,
    type        varchar(255) not null,
    href        varchar(255) not null,
    is_active   boolean,
    FOREIGN KEY (playlist_id) REFERENCES playlist (id)
);

CREATE TABLE IF NOT EXISTS suggestion
(
    id       int primary key auto_increment,
    party_id int          not null,
    track_id varchar(255) not null,
    status   varchar(25)  not null,
    FOREIGN KEY (party_id) REFERENCES party (id),
    FOREIGN KEY (track_id) REFERENCES track (id)
);
