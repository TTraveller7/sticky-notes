package bht.salvinto.stickynotes.controllers;

import bht.salvinto.stickynotes.commands.TodoNoteCommand;
import bht.salvinto.stickynotes.domain.PlainNote;
import bht.salvinto.stickynotes.domain.TodoNote;
import bht.salvinto.stickynotes.services.PlainNoteService;
import bht.salvinto.stickynotes.services.TodoNoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard")
public class DashboardController {

    private final PlainNoteService plainNoteService;
    private final TodoNoteService todoNoteService;

    public DashboardController(PlainNoteService plainNoteService, TodoNoteService todoNoteService) {
        this.plainNoteService = plainNoteService;
        this.todoNoteService = todoNoteService;
    }

    @GetMapping("")
    public String getDashboard(Model model) {
        Iterable<TodoNote> todoNotes = todoNoteService.findAll();
        model.addAttribute("todoNotes", todoNotes);

        Iterable<PlainNote> plainNotes = plainNoteService.findAll();
        model.addAttribute("plainNotes", plainNotes);

        return "dashboard";
    }

    @GetMapping("/create-todonote")
    public String createTodoNote(Model model) {
        Iterable<TodoNote> todoNotes = todoNoteService.findAll();
        model.addAttribute("todoNotes", todoNotes);

        Iterable<PlainNote> plainNotes = plainNoteService.findAll();
        model.addAttribute("plainNotes", plainNotes);

        model.addAttribute("todoNoteCommand", new TodoNoteCommand());
        model.addAttribute("isCreatingNote", true);

        return "dashboard";
    }

    @PostMapping("/submit-todonote")
    public String saveTodoNote(@ModelAttribute TodoNoteCommand todoNoteCommand, Model model) {
        TodoNoteCommand savedCommand = todoNoteService.saveCommand(todoNoteCommand);
        model.addAttribute("isCreatingNote", false);

        return "redirect:/dashboard";
    }
}
