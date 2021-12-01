package org.example.labwork3final.controller;

import org.example.labwork3final.model.*;
import org.example.labwork3final.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private EditorService editorService;

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("game", new Game());
        List<Long> editorIds = editorService.getAll().stream().map(Editor::getId).collect(Collectors.toList());
        model.addAttribute("editorIds", editorIds);
        return "create_game";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Game game, @RequestParam Long editorId) {
        gameService.create(game, editorId);
        return "redirect:/games";
    }

    @GetMapping
    public String getAll(Model model) {
        List<Game> games = gameService.getAll();
        model.addAttribute("games", games);
        return "show_games";
    }

    @GetMapping("/{id}/update")
    public String getUpdatePage(@PathVariable("id") Long gameId, Model model) {
        Game game = gameService.get(gameId);
        model.addAttribute("game", game);
        List<Long> editorIds = editorService.getAll().stream().map(Editor::getId).collect(Collectors.toList());
        model.addAttribute("editorIds", editorIds);
        return "update_game";
    }

    @PatchMapping("/{id}/update")
    public String update(@PathVariable("id") Long gameId, @ModelAttribute Game game, @RequestParam Long editorId) {
        gameService.update(gameId, game, editorId);
        return "redirect:/games";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        gameService.delete(id);
        return "redirect:/games";
    }
}
