package bht.salvinto.stickynotes.controllers;

import bht.salvinto.stickynotes.domain.TodoNote;
import bht.salvinto.stickynotes.services.TodoNoteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/todonotes")
public class TodoNoteController {

    private final TodoNoteService todoNoteService;

    public TodoNoteController(TodoNoteService todoNoteService) {
        this.todoNoteService = todoNoteService;
    }

    @ResponseBody
    @GetMapping(path="/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TodoNote> one(@PathVariable String id) {
        Long todoNoteId = Long.valueOf(id);
        Optional<TodoNote> todoNoteOptional = todoNoteService.findById(todoNoteId);
        if (todoNoteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(todoNoteOptional.get());
        }
    }
}
