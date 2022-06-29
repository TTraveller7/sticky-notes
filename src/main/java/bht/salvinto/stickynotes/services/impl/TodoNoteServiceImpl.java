package bht.salvinto.stickynotes.services.impl;

import bht.salvinto.stickynotes.commands.TodoNoteCommand;
import bht.salvinto.stickynotes.converters.TodoNoteCommandToTodoNote;
import bht.salvinto.stickynotes.converters.TodoNoteToTodoNoteCommand;
import bht.salvinto.stickynotes.domain.TodoNote;
import bht.salvinto.stickynotes.repositories.TodoNoteRepository;
import bht.salvinto.stickynotes.services.TodoNoteService;
import org.springframework.stereotype.Service;

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
}
