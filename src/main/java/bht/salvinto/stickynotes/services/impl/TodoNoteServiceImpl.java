package bht.salvinto.stickynotes.services.impl;

import bht.salvinto.stickynotes.domain.TodoNote;
import bht.salvinto.stickynotes.repositories.TodoNoteRepository;
import bht.salvinto.stickynotes.services.TodoNoteService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoNoteServiceImpl implements TodoNoteService {

    private final TodoNoteRepository todoNoteRepository;

    public TodoNoteServiceImpl(TodoNoteRepository todoNoteRepository) {
        this.todoNoteRepository = todoNoteRepository;
    }

    @Override
    public Optional<TodoNote> findById(Long id) {
        return todoNoteRepository.findById(id);
    }
}
