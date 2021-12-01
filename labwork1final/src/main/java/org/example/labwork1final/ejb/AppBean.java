package org.example.labwork1final.ejb;

import org.example.labwork1final.dao.*;
import org.example.labwork1final.model.*;

import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class AppBean {

    private final EditorDao editorDao = new EditorDao();
    private final GameDao gameDao = new GameDao();

    public void createEditor(Editor editor) {
        editorDao.create(editor);
    }

    public void createGame(Game game, Long groupId) {
        Editor editor = editorDao.get(groupId);
        if (editor == null)
            return;
        game.setEditor(editor);
        gameDao.create(game);
    }

    public List<Editor> getAllEditors() {
        return editorDao.getAll();
    }

    public Editor getEditorById(Long id) {
        return editorDao.get(id);
    }

    public List<Game> getAllGames() {
        return gameDao.getAll();
    }

    public Game getGameById(Long id) {
        return gameDao.get(id);
    }

    public void updateEditor(Long editorId, Editor newEditorData) {
        editorDao.update(editorId, newEditorData);
    }

    public void updateGame(Long gameId, Game newGameData, Long editorId) {
        Editor editor = editorDao.get(editorId);
        if (editor == null)
            return;
        newGameData.setEditor(editor);
        gameDao.update(gameId, newGameData);
    }

    public void deleteEditor(Long editorId) {
        Editor editor = getEditorById(editorId);
        if (editor == null)
            return;
        editor.getGames().forEach(game -> this.deleteGame(game.getId()));
        DaoUtil.refresh();
        editorDao.delete(editorId);
    }

    public void deleteGame(Long gameId) {
        gameDao.delete(gameId);
    }


}
