drop table if exists track;
drop table if exists playlist;
drop table if exists party;
drop table if exists user;

CREATE TABLE IF NOT EXISTS party
(
    id   int primary key auto_increment,
    name varchar(255) not null
);

CREATE TABLE IF NOT EXISTS playlist
(
    id       int primary key auto_increment,
    uri      varchar(255) not null,
    name     varchar(255) not null,
    party_id int          not null,
    FOREIGN KEY (party_id) REFERENCES party (id)
);

CREATE TABLE IF NOT EXISTS track
(
    id          int primary key auto_increment,
    uri         varchar(255) not null,
    name        varchar(255) not null,
    playlist_id int          not null,
    FOREIGN KEY (playlist_id) REFERENCES playlist (id)
);

CREATE TABLE IF NOT EXISTS user
(
    id       int primary key auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    role     enum ('ADMIN', 'USER')
);
