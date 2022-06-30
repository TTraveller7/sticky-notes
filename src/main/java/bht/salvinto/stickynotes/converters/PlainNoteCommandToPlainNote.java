package bht.salvinto.stickynotes.converters;

import bht.salvinto.stickynotes.commands.PlainNoteCommand;
import bht.salvinto.stickynotes.domain.PlainNote;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlainNoteCommandToPlainNote implements Converter<PlainNoteCommand, PlainNote> {
    @Override
    public PlainNote convert(PlainNoteCommand source) {
        PlainNote plainNote = new PlainNote();

        plainNote.setId(source.getId());
        plainNote.setTitle(source.getTitle());
        plainNote.setDescription(source.getDescription());
        plainNote.setCreationTimestamp(source.getCreationTimestamp());

        return plainNote;
    }
}
