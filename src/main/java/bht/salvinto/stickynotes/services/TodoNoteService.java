package bht.salvinto.stickynotes.services;

import bht.salvinto.stickynotes.commands.TodoNoteCommand;
import bht.salvinto.stickynotes.domain.TodoNote;

public interface TodoNoteService {
    Iterable<TodoNote> findAll();

    TodoNoteCommand saveCommand(TodoNoteCommand todoNoteCommand);

    void deleteById(Long id);

    TodoNoteCommand findCommandById(Long id);

    TodoNote findById(Long id);
}
