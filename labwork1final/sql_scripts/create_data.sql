DROP TABLE IF EXISTS game;
DROP TABLE IF EXISTS _editor;

CREATE TABLE _editor
(
    id SERIAL PRIMARY KEY,
    nameEditor VARCHAR(255)
);

CREATE TABLE game
(
    id SERIAL PRIMARY KEY,
    nameGame VARCHAR(255),
    genre VARCHAR(255),
    price integer,
    editor_id BIGINT REFERENCES _editor
);