package bht.salvinto.stickynotes.services;

import bht.salvinto.stickynotes.domain.TodoNote;

public interface TodoNoteService {
    Iterable<TodoNote> findAll();
}
