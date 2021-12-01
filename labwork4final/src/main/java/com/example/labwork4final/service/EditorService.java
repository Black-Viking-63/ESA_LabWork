package com.example.labwork4final.service;

import com.example.labwork4final.jms.Sender;
import com.example.labwork4final.model.*;
import com.example.labwork4final.repository.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EditorService {
    @Autowired
    private EditorRepository editorRepository;

    @Autowired
    private Sender sender;

    public void create(Editor editor) {
        editor.setId(getNextId());
        editorRepository.save(editor);
        sender.sendInsert(editor);
    }

    public Editor get(Long id) {
        return editorRepository.findById(id).get();
    }

    public List<Editor> getAll() {
        return editorRepository.findAll().stream().sorted(Comparator.comparing(Editor::getId)).collect(Collectors.toList());
    }

    public void update(Long editorId, Editor newEditorData) {
        Editor editor = editorRepository.findById(editorId).get();

        newEditorData.setId(editorId);
        sender.sendUpdate(editor, newEditorData);

        editor.setNameEditor(newEditorData.getNameEditor());
        editorRepository.save(editor);
    }

    public void delete(Long id) {
        Editor editor = editorRepository.findById(id).get();
        editorRepository.deleteById(id);

        sender.sendDelete(editor);
        editor.getGames().forEach(game -> sender.sendDelete(game));
    }

    public List<Game> getGames(Long id) {
        Editor editor = get(id);
        return editor.getGames().stream().sorted(Comparator.comparingLong(Game::getId)).collect(Collectors.toList());
    }

    public Long getNextId() {
        long count = editorRepository.count();
        long id = ++count;
        while (editorRepository.existsById(id)) {
            ++id;
        }
        return id;
    }
}
