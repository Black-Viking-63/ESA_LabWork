package com.example.labwork4final.service;

import com.example.labwork4final.jms.Sender;
import com.example.labwork4final.model.*;
import com.example.labwork4final.repository.*;
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

    @Autowired
    private Sender sender;

    public void create(Game game, Long editorId) {
        Editor editor = editorRepository.findById(editorId).get();
        game.setEditor(editor);
        game.setId(getNextId());
        gameRepository.save(game);

        sender.sendInsert(game);
    }

    public Game get(Long id) {
        return gameRepository.findById(id).get();
    }

    public List<Game> getAll() {
        return gameRepository.findAll().stream().sorted(Comparator.comparingLong(Game::getId)).collect(Collectors.toList());
    }

    public void update(Long gameId, Game newGameData, Long editorId) {
        Game game = gameRepository.findById(gameId).get();
        Editor editor = editorRepository.findById(editorId).get();

        newGameData.setId(gameId);
        newGameData.setEditor(editor);
        sender.sendUpdate(game, newGameData);

        game.setNameGame(newGameData.getNameGame());
        game.setGenre(newGameData.getGenre());
        game.setPrice(newGameData.getPrice());
        game.setEditor(editor);
        gameRepository.save(game);
    }

    public void delete(Long id) {
        Game game = gameRepository.findById(id).get();
        game.getEditor().getGames().remove(game);
        gameRepository.deleteById(id);

        sender.sendDelete(game);
    }

    public Long getNextId() {
        long count = gameRepository.count();
        long id = ++count;
        while (gameRepository.existsById(id)) {
            ++id;
        }
        return id;
    }

}
