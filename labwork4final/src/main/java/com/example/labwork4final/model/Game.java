package com.example.labwork4final.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "game", schema = "public")
public class Game extends BaseEntity {

    private String name_game;

    private String genre;

    private Integer price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "editor_id")
    private Editor editor;

    public Game() {
    }

    public Game(String nameGame, String genre, Integer price) {
        this.name_game = nameGame;
        this.genre = genre;
        this.price = price;
    }

    public Game(String nameGame, String genre, Integer price, Editor editor) {
        this.name_game = nameGame;
        this.genre = genre;
        this.price = price;
        this.editor = editor;
    }

    public String getNameGame() {
        return name_game;
    }

    public void setNameGame(String nameGame) {
        this.name_game = nameGame;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
        return toMap().toString();
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name_game", name_game);
        map.put("genre", genre);
        map.put("price", price.toString());
        map.put("editorId", editor.getId().toString());
        return map;
    }
}
