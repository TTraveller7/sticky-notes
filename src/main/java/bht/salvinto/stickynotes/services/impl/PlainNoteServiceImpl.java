package bht.salvinto.stickynotes.services.impl;

import bht.salvinto.stickynotes.domain.PlainNote;
import bht.salvinto.stickynotes.repositories.PlainNoteRepository;
import bht.salvinto.stickynotes.services.PlainNoteService;
import org.springframework.stereotype.Service;

@Service
public class PlainNoteServiceImpl implements PlainNoteService {
    private final PlainNoteRepository plainNoteRepository;

    public PlainNoteServiceImpl(PlainNoteRepository plainNoteRepository) {
        this.plainNoteRepository = plainNoteRepository;
    }

    @Override
    public Iterable<PlainNote> findAll() {
        return plainNoteRepository.findAll();
    }
}
