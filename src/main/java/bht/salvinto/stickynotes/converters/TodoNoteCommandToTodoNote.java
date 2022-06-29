package bht.salvinto.stickynotes.converters;

import bht.salvinto.stickynotes.commands.TodoNoteCommand;
import bht.salvinto.stickynotes.domain.TodoNote;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TodoNoteCommandToTodoNote implements Converter<TodoNoteCommand, TodoNote> {

    @Override
    public TodoNote convert(TodoNoteCommand source) {
        TodoNote todoNote = new TodoNote();

        todoNote.setId(source.getId());
        todoNote.setTitle(source.getTitle());
        todoNote.setDescription(source.getDescription());
        todoNote.setCreationTimestamp(source.getCreationTimestamp());
        todoNote.setCategory(source.getCategory());
        todoNote.setDeadline(source.getDeadline());
        todoNote.setStatus(source.getStatus());

        return todoNote;
    }
}
