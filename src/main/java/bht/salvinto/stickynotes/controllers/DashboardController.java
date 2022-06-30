package bht.salvinto.stickynotes.controllers;

import bht.salvinto.stickynotes.commands.TodoNoteCommand;
import bht.salvinto.stickynotes.domain.PlainNote;
import bht.salvinto.stickynotes.domain.TodoNote;
import bht.salvinto.stickynotes.services.PlainNoteService;
import bht.salvinto.stickynotes.services.TodoNoteService;
import bht.salvinto.stickynotes.ui.states.TodoNoteState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({"dashboard", ""})
public class DashboardController {

    private final PlainNoteService plainNoteService;
    private final TodoNoteService todoNoteService;

    public DashboardController(PlainNoteService plainNoteService, TodoNoteService todoNoteService) {
        this.plainNoteService = plainNoteService;
        this.todoNoteService = todoNoteService;
    }

    @GetMapping("")
    public String getDashboard(Model model) {
        getNotes(model);

        return "dashboard";
    }

    /** Create a TodoNote. */
    @GetMapping("/create-todonote")
    public String createTodoNote(Model model) {
        getNotes(model);

        model.addAttribute("todoNoteCommand", new TodoNoteCommand());

        model.addAttribute("todoNoteState", TodoNoteState.CREATE);

        return "dashboard";
    }

    @PostMapping("/submit-todonote")
    public String saveTodoNote(@ModelAttribute TodoNoteCommand todoNoteCommand, Model model) {
        TodoNoteCommand savedCommand = todoNoteService.saveCommand(todoNoteCommand);
        model.addAttribute("isCreatingNote", false);

        return "redirect:/dashboard";
    }

    /** Delete a TodoNote. */
    @GetMapping("/delete-todonote")
    public String showDeleteLink(Model model) {
        getNotes(model);

        model.addAttribute("todoNoteState", TodoNoteState.DELETE);

        return "dashboard";
    }

    @GetMapping("/todonotes/{id}/delete")
    public String deleteTodoNote(@PathVariable String id) {
        todoNoteService.deleteById(Long.valueOf(id));

        return "redirect:/dashboard";
    }

    /** Edit a TodoNote. */
    @GetMapping("/edit-todonote")
    public String showEditLink(Model model) {
        getNotes(model);

        model.addAttribute("todoNoteState", TodoNoteState.EDIT_SELECT);

        return "dashboard";
    }

    @GetMapping("/todonotes/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        getNotes(model);

        model.addAttribute("todoNoteState", TodoNoteState.EDIT_FILL);

        model.addAttribute("todoNoteCommand", todoNoteService.findCommandById(Long.valueOf(id)));

        return "dashboard";
    }

    private void getNotes(Model model) {
        Iterable<TodoNote> todoNotes = todoNoteService.findAll();
        model.addAttribute("todoNotes", todoNotes);

        Iterable<PlainNote> plainNotes = plainNoteService.findAll();
        model.addAttribute("plainNotes", plainNotes);
    }
}
