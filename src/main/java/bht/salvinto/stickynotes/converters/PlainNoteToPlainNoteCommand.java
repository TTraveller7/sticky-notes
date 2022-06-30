package bht.salvinto.stickynotes.converters;

import bht.salvinto.stickynotes.commands.PlainNoteCommand;
import bht.salvinto.stickynotes.domain.PlainNote;
import org.springframework.core.convert.converter.Converter;

public class PlainNoteToPlainNoteCommand implements Converter<PlainNote, PlainNoteCommand> {
    @Override
    public PlainNoteCommand convert(PlainNote source) {
        PlainNoteCommand plainNoteCommand = new PlainNoteCommand();

        plainNoteCommand.setId(source.getId());
        plainNoteCommand.setTitle(source.getTitle());
        plainNoteCommand.setDescription(source.getDescription());
        plainNoteCommand.setCreationTimestamp(source.getCreationTimestamp());

        return plainNoteCommand;
    }
}
