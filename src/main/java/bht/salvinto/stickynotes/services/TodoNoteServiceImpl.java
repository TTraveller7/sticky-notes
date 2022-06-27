package bht.salvinto.stickynotes.services;

import bht.salvinto.stickynotes.domain.TodoNote;
import bht.salvinto.stickynotes.repositories.TodoNoteRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoNoteServiceImpl implements TodoNoteService {

    private final TodoNoteRepository todoNoteRepository;

    public TodoNoteServiceImpl(TodoNoteRepository todoNoteRepository) {
        this.todoNoteRepository = todoNoteRepository;
    }

    @Override
    public Iterable<TodoNote> findAll() {
        return todoNoteRepository.findAll();
    }
}
