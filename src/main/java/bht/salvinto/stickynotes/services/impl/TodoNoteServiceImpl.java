package bht.salvinto.stickynotes.services.impl;

import bht.salvinto.stickynotes.commands.TodoNoteCommand;
import bht.salvinto.stickynotes.converters.TodoNoteCommandToTodoNote;
import bht.salvinto.stickynotes.converters.TodoNoteToTodoNoteCommand;
import bht.salvinto.stickynotes.domain.TodoNote;
import bht.salvinto.stickynotes.repositories.TodoNoteRepository;
import bht.salvinto.stickynotes.services.TodoNoteService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoNoteServiceImpl implements TodoNoteService {

    private final TodoNoteRepository todoNoteRepository;

    private final TodoNoteCommandToTodoNote todoNoteCommandToTodoNote;
    private final TodoNoteToTodoNoteCommand todoNoteToTodoNoteCommand;

    public TodoNoteServiceImpl(TodoNoteRepository todoNoteRepository,
            TodoNoteCommandToTodoNote todoNoteCommandToTodoNote,
            TodoNoteToTodoNoteCommand todoNoteToTodoNoteCommand) {
        this.todoNoteRepository = todoNoteRepository;
        this.todoNoteCommandToTodoNote = todoNoteCommandToTodoNote;
        this.todoNoteToTodoNoteCommand = todoNoteToTodoNoteCommand;
    }

    @Override
    public Iterable<TodoNote> findAll() {
        return todoNoteRepository.findAll();
    }

    @Override
    public TodoNoteCommand saveCommand(TodoNoteCommand todoNoteCommand) {
        TodoNote todoNote = todoNoteCommandToTodoNote.convert(todoNoteCommand);
        TodoNote savedTodoNote = todoNoteRepository.save(todoNote);

        return todoNoteToTodoNoteCommand.convert(savedTodoNote);
    }

    @Override
    public void deleteById(Long id) {
        todoNoteRepository.deleteById(id);
    }

    @Override
    public TodoNoteCommand findCommandById(Long id) {
        return todoNoteToTodoNoteCommand.convert(findById(id));
    }

    @Override
    public TodoNote findById(Long id) {
        Optional<TodoNote> todoNoteOptional = todoNoteRepository.findById(id);
        if (!todoNoteOptional.isPresent()) {
            throw new RuntimeException("TodoNote with id " + id + "not exist");
        }

        return todoNoteOptional.get();
    }
}
