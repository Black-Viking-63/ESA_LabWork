package org.example.labwork2final.service;

import org.example.labwork2final.model.Editor;
import org.example.labwork2final.model.Game;
import org.example.labwork2final.repository.EditorRepository;
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

    public void create(Editor editor) {
        editorRepository.save(editor);
    }

    public Editor get(Long id) {
        return editorRepository.findById(id).get();
    }

    public List<Editor> getAll() {
        return editorRepository.findAll().stream().sorted(Comparator.comparing(Editor::getId)).collect(Collectors.toList());
    }

    public void update(Long editorId, Editor newEditorData) {
        Editor editor = editorRepository.findById(editorId).get();
        editor.setNameEditor(newEditorData.getNameEditor());
        editorRepository.save(editor);
    }

    public void delete(Long id) {
        editorRepository.deleteById(id);
    }

    public List<Game> getGames(Long id) {
        Editor editor = get(id);
        return editor.getGames().stream().sorted(Comparator.comparing(Game::getId).thenComparing(Game::getNameGame)).collect(Collectors.toList());
    }

}
