package bht.salvinto.stickynotes.services.impl;

import bht.salvinto.stickynotes.commands.PlainNoteCommand;
import bht.salvinto.stickynotes.converters.PlainNoteCommandToPlainNote;
import bht.salvinto.stickynotes.converters.PlainNoteToPlainNoteCommand;
import bht.salvinto.stickynotes.domain.PlainNote;
import bht.salvinto.stickynotes.repositories.PlainNoteRepository;
import bht.salvinto.stickynotes.services.PlainNoteService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlainNoteServiceImpl implements PlainNoteService {
    private final PlainNoteRepository plainNoteRepository;
    private final PlainNoteCommandToPlainNote plainNoteCommandToPlainNote;
    private final PlainNoteToPlainNoteCommand plainNoteToPlainNoteCommand;

    public PlainNoteServiceImpl(PlainNoteRepository plainNoteRepository, PlainNoteCommandToPlainNote plainNoteCommandToPlainNote, PlainNoteToPlainNoteCommand plainNoteToPlainNoteCommand) {
        this.plainNoteRepository = plainNoteRepository;
        this.plainNoteCommandToPlainNote = plainNoteCommandToPlainNote;
        this.plainNoteToPlainNoteCommand = plainNoteToPlainNoteCommand;
    }

    @Override
    public Iterable<PlainNote> findAll() {
        return plainNoteRepository.findAll();
    }

    @Override
    public PlainNoteCommand saveCommand(PlainNoteCommand plainNoteCommand) {
        PlainNote plainNote = plainNoteCommandToPlainNote.convert(plainNoteCommand);
        PlainNote savedNote = plainNoteRepository.save(plainNote);
        PlainNoteCommand savedCommand = plainNoteToPlainNoteCommand.convert(savedNote);
        return savedCommand;
    }

    @Override
    public void deleteById(Long id) {
       plainNoteRepository.deleteById(id);
    }

    @Override
    public PlainNoteCommand findCommandById(Long id) {
        Optional<PlainNote> plainNoteOptional = plainNoteRepository.findById(id);
        if (!plainNoteOptional.isPresent()) {
            throw new RuntimeException("Plain note with id " + id + "not present");
        }

        PlainNoteCommand plainNoteCommand = plainNoteToPlainNoteCommand.convert(plainNoteOptional.get());

        return plainNoteCommand;
    }
}
