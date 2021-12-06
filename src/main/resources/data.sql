INSERT INTO playlist (name) VALUES ('Disco');
INSERT INTO track (name, playlist_id) VALUES ('Ruda tańczy jak szalona', 1);
INSERT INTO track (name, playlist_id) VALUES ('Ta szalona Karolina', 1);

INSERT INTO playlist (name) VALUES ('Rap');
INSERT INTO track (name, playlist_id) VALUES ('Numer o niczym', 2);
INSERT INTO track (name, playlist_id) VALUES ('Czerwona sukienka', 2);

INSERT INTO party (name) VALUES ('SYLWESTER');
INSERT INTO party (name) VALUES ('URODZINY');

INSERT INTO party_playlist (party_id, playlist_id) VALUES ( 1, 1 );
INSERT INTO party_playlist (party_id, playlist_id) VALUES ( 1, 2 );

INSERT INTO party_playlist (party_id, playlist_id) VALUES ( 2, 2 );