drop table if exists track;
drop table if exists party_playlist;
drop table if exists playlist;
drop table if exists party;

CREATE TABLE IF NOT EXISTS party
(
    id   int primary key auto_increment,
    name varchar(255) not null
);

CREATE TABLE IF NOT EXISTS playlist
(
    id   int primary key auto_increment,
    name varchar(255) not null
);


CREATE TABLE IF NOT EXISTS party_playlist
(
    party_id   int not null,
    playlist_id int not null,
    PRIMARY KEY(party_id, playlist_id),
    FOREIGN KEY (party_id) REFERENCES party(id),
    FOREIGN KEY (playlist_id) REFERENCES playlist(id)
);

CREATE TABLE IF NOT EXISTS track
(
    id   int primary key auto_increment,
    name varchar(255) not null,
    playlist_id int not null,
    FOREIGN KEY (playlist_id) REFERENCES playlist(id)
);

