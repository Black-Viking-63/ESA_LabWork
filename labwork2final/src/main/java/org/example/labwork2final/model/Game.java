package org.example.labwork2final.model;

import javax.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator",  sequenceName = "game_id_seq", allocationSize = 1)
    private Long id;

    private String nameGame;

    private String genre;

    private Integer price;

    @ManyToOne
    @JoinColumn(name = "editor_id")
    private Editor editor;

    public Game() {
    }

    public Game(String nameGame, String genre, Integer price) {
        this.nameGame = nameGame;
        this.genre = genre;
        this.price = price;
    }

    public Game(String nameGame, String genre, Integer price, Editor editor) {
        this.nameGame = nameGame;
        this.genre = genre;
        this.price = price;
        this.editor = editor;
    }

    public Long getId() {
        return id;
    }

    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
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
}
