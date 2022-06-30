package bht.salvinto.stickynotes.controllers;

import bht.salvinto.stickynotes.commands.PlainNoteCommand;
import bht.salvinto.stickynotes.domain.PlainNote;
import bht.salvinto.stickynotes.domain.TodoNote;
import bht.salvinto.stickynotes.services.PlainNoteService;
import bht.salvinto.stickynotes.services.TodoNoteService;
import bht.salvinto.stickynotes.ui.states.PlainNoteState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dashboard/plainnotes")
public class PlainNoteController {

    private final PlainNoteService plainNoteService;
    private final TodoNoteService todoNoteService;

    public PlainNoteController(PlainNoteService plainNoteService, TodoNoteService todoNoteService) {
        this.plainNoteService = plainNoteService;
        this.todoNoteService = todoNoteService;
    }

    /** Create a PlainNote. */
    @GetMapping("/create")
    public String createPlainNote(Model model) {
        getNotes(model);

        model.addAttribute("plainNoteCommand", new PlainNoteCommand());

        model.addAttribute("plainNoteState", PlainNoteState.CREATE);

        return "dashboard";
    }

    @PostMapping("/submit")
    public String savePlainNote(@ModelAttribute PlainNoteCommand plainNoteCommand) {
        PlainNoteCommand savedCommand = plainNoteService.saveCommand(plainNoteCommand);

        return "redirect:/dashboard";
    }

    /** Delete a PlainNote. */
    @GetMapping("/delete")
    public String showDeleteLink(Model model) {
        getNotes(model);

        model.addAttribute("plainNoteState", PlainNoteState.DELETE);

        return "dashboard";
    }

    @GetMapping("/{id}/delete")
    public String deletePlainNote(@PathVariable String id) {
        plainNoteService.deleteById(Long.valueOf(id));

        return "redirect:/dashboard";
    }

    /** Edit a PlainNote. */
    @GetMapping("/edit")
    public String showEditLink(Model model) {
        getNotes(model);

        model.addAttribute("plainNoteState", PlainNoteState.EDIT_SELECT);

        return "dashboard";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        getNotes(model);

        model.addAttribute("plainNoteState", PlainNoteState.EDIT_FILL);

        model.addAttribute("plainNoteCommand", plainNoteService.findCommandById(Long.valueOf(id)));

        return "dashboard";
    }

    private void getNotes(Model model) {
        Iterable<TodoNote> todoNotes = todoNoteService.findAll();
        model.addAttribute("todoNotes", todoNotes);

        Iterable<PlainNote> plainNotes = plainNoteService.findAll();
        model.addAttribute("plainNotes", plainNotes);
    }
}
