package bht.salvinto.stickynotes.converters;

import bht.salvinto.stickynotes.commands.TodoNoteCommand;
import bht.salvinto.stickynotes.domain.TodoNote;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TodoNoteToTodoNoteCommand implements Converter<TodoNote, TodoNoteCommand> {

    @Override
    public TodoNoteCommand convert(TodoNote source) {
        TodoNoteCommand todoNoteCommand = new TodoNoteCommand();

        todoNoteCommand.setId(source.getId());
        todoNoteCommand.setTitle(source.getTitle());
        todoNoteCommand.setDescription(source.getDescription());
        todoNoteCommand.setCreationTimestamp(source.getCreationTimestamp());
        todoNoteCommand.setCategory(source.getCategory());
        todoNoteCommand.setDeadline(source.getDeadline());
        todoNoteCommand.setStatus(source.getStatus());

        return todoNoteCommand;
    }
}
