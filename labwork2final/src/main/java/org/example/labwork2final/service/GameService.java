package org.example.labwork2final.service;

import org.example.labwork2final.model.Editor;
import org.example.labwork2final.model.Game;
import org.example.labwork2final.repository.EditorRepository;
import org.example.labwork2final.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private EditorRepository editorRepository;

    public void create(Game game, Long editorId) {
        Editor editor = editorRepository.findById(editorId).get();
        game.setEditor(editor);
        gameRepository.save(game);
    }

    public Game get(Long id) {
        return gameRepository.findById(id).get();
    }

    public List<Game> getAll() {
        return gameRepository.findAll().stream().sorted(Comparator.comparing(Game::getId).thenComparing(Game::getNameGame)).collect(Collectors.toList());
    }

    public void update(Long gametId, Game newGameData, Long editorId) {
        Game game = gameRepository.findById(gametId).get();
        game.setNameGame(newGameData.getNameGame());
        game.setGenre(newGameData.getGenre());
        game.setPrice(newGameData.getPrice());
        Editor editor = editorRepository.findById(editorId).get();
        game.setEditor(editor);
        gameRepository.save(game);
    }

    public void delete(Long id) {
        Game game = gameRepository.getById(id);
        game.getEditor().getGames().remove(game);
        gameRepository.deleteById(id);
    }
}