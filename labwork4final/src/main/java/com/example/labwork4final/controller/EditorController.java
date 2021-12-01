package com.example.labwork4final.controller;

import com.example.labwork4final.model.*;
import com.example.labwork4final.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/editors")
public class EditorController {

    @Autowired
    private EditorService editorService;

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute(new Editor());
        return "create_editor";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Editor editor) {
        editorService.create(editor);
        return "redirect:/editors";
    }

    @GetMapping
    public String getAll(Model model) {
        List<Editor> editors = editorService.getAll();
        model.addAttribute("editors", editors);
        return "show_editors";
    }

    @GetMapping("/{id}/update")
    public String getUpdatePage(@PathVariable("id") Long editorId, Model model) {
        model.addAttribute("editor", editorService.get(editorId));
        return "update_editor";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long editorId, @ModelAttribute Editor editor) {
        editorService.update(editorId, editor);
        return "redirect:/editors";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        editorService.delete(id);
        return "redirect:/editors";
    }

    @GetMapping("/{id}/games")
    public String getGames(@PathVariable Long id, Model model) {
        List<Game> games = editorService.getGames(id);
        model.addAttribute("games", games);
        model.addAttribute("id", id);
        return "show_group_games";
    }
}
