package org.example.labwork3final.controller.rest_api.json;

import org.example.labwork3final.model.*;
import org.example.labwork3final.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/json/editors", produces = MediaType.APPLICATION_JSON_VALUE)
public class EditorJsonRestController {
    @Autowired
    private EditorService editorService;

    @PostMapping("/create")
    public void create(@RequestBody Editor editor) {
        editorService.create(editor);
    }

    @GetMapping
    public List<Editor> getAll() {
        return editorService.getAll();
    }

    @GetMapping("/{id}")
    public Editor get(@PathVariable Long id) {
        return editorService.get(id);
    }

    @PatchMapping("/{id}/update")
    public void update(@PathVariable("id") Long editorId, @RequestBody Editor editor) {
        editorService.update(editorId, editor);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Long id) {
        editorService.delete(id);
    }

    @GetMapping("/{id}/games")
    public ResponseEntity<List<Game>> getGames(@PathVariable Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("editorId", String.valueOf(id));
        return new ResponseEntity<>(editorService.getGames(id), httpHeaders, HttpStatus.OK);
    }
}
