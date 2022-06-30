package bht.salvinto.stickynotes.services;

import bht.salvinto.stickynotes.commands.PlainNoteCommand;
import bht.salvinto.stickynotes.domain.PlainNote;

public interface PlainNoteService {
    Iterable<PlainNote> findAll();

    PlainNoteCommand saveCommand(PlainNoteCommand plainNoteCommand);

    void deleteById(Long id);

    PlainNoteCommand findCommandById(Long id);
}
