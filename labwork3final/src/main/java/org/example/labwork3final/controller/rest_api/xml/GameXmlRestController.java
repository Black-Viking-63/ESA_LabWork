package org.example.labwork3final.controller.rest_api.xml;

import org.example.labwork3final.model.Game;
import org.example.labwork3final.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/xml/games", produces = MediaType.APPLICATION_XML_VALUE)
public class GameXmlRestController {

    @Autowired
    private GameService gameService;

    @PostMapping("/create")
    public void create(@RequestBody Game game, @RequestAttribute Long editorId) {
        gameService.create(game, editorId);
    }

    @GetMapping
    public List<Game> getAll() {
        return gameService.getAll();
    }

    @GetMapping("/{id}")
    public Game get(@PathVariable Long id) {
        return gameService.get(id);
    }

    @PatchMapping("/{gameId}/update")
    public void update(@PathVariable Long gameId, @RequestBody Game game, @RequestAttribute Long editorId) {
        gameService.update(gameId, game, editorId);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Long id) {
        gameService.delete(id);
    }
}
