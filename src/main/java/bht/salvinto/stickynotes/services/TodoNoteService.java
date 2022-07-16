package bht.salvinto.stickynotes.services;

import bht.salvinto.stickynotes.domain.TodoNote;

import java.util.Optional;

public interface TodoNoteService {
    Optional<TodoNote> findById(Long id);
}
