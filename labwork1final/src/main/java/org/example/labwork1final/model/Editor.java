package org.example.labwork1final.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "_editor")
public class Editor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameEditor;

    @OneToMany(mappedBy = "editor", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Game> games = new HashSet<>();

    public Editor() {
    }

    public Editor(String nameEditor) {
        this.nameEditor = nameEditor;
    }

    public Editor(String nameEditor, Set<Game> games) {
        this.nameEditor = nameEditor;
        this.games = games;
    }

    public Long getId() {
        return id;
    }

    public String getNameEditor() {
        return nameEditor;
    }

    public void setNameEditor(String nameEditor) {
        this.nameEditor = nameEditor;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
