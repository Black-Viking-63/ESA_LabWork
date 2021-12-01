package com.example.labwork4final.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "editor", schema = "public")
public class Editor extends BaseEntity {

    @Column(name = "name_editor")
    private String name_editor;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "editor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> games = new LinkedList<>();

    public Editor() {
    }

    public Editor(String nameEditor) {
        this.name_editor = nameEditor;
    }

    public String getNameEditor() {
        return name_editor;
    }

    public void setNameEditor(String nameEditor) {
        this.name_editor = nameEditor;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return toMap().toString();
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name_editor", name_editor.toString());
        return map;
    }
}
