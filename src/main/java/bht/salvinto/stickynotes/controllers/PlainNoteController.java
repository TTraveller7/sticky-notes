package bht.salvinto.stickynotes.controllers;

import bht.salvinto.stickynotes.domain.PlainNote;
import bht.salvinto.stickynotes.services.PlainNoteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/plainnotes")
public class PlainNoteController {

    private final PlainNoteService plainNoteService;

    public PlainNoteController(PlainNoteService plainNoteService) {
        this.plainNoteService = plainNoteService;
    }

    @ResponseBody
    @GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PlainNote> one(@PathVariable String id) {
        Long plainNoteId = Long.valueOf(id);
        Optional<PlainNote> plainNoteOptional = plainNoteService.findById(plainNoteId);
        if (plainNoteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(plainNoteOptional.get());
        }
    }
}
