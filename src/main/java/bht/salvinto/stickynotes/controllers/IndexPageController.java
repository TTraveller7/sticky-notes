package bht.salvinto.stickynotes.controllers;

import bht.salvinto.stickynotes.domain.PlainNote;
import bht.salvinto.stickynotes.domain.TodoNote;
import bht.salvinto.stickynotes.services.PlainNoteService;
import bht.salvinto.stickynotes.services.TodoNoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPageController {

    private final PlainNoteService plainNoteService;
    private final TodoNoteService todoNoteService;

    public IndexPageController(PlainNoteService plainNoteService, TodoNoteService todoNoteService) {
        this.plainNoteService = plainNoteService;
        this.todoNoteService = todoNoteService;
    }

    @GetMapping
    @RequestMapping(value = {"", "/index", "/index.html"})
    public String getIndexPage(Model model) {
        Iterable<TodoNote> todoNotes = todoNoteService.findAll();
        model.addAttribute("todoNotes", todoNotes);

        Iterable<PlainNote> plainNotes = plainNoteService.findAll();
        model.addAttribute("plainNotes", plainNotes);

        return "index";
    }
}
