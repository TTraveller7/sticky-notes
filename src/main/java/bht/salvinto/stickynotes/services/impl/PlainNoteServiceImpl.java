package bht.salvinto.stickynotes.services.impl;

import bht.salvinto.stickynotes.domain.PlainNote;
import bht.salvinto.stickynotes.repositories.PlainNoteRepository;
import bht.salvinto.stickynotes.services.PlainNoteService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlainNoteServiceImpl implements PlainNoteService {

    private final PlainNoteRepository plainNoteRepository;

    public PlainNoteServiceImpl(PlainNoteRepository plainNoteRepository) {
        this.plainNoteRepository = plainNoteRepository;
    }

    @Override
    public Optional<PlainNote> findById(Long id) {
        return plainNoteRepository.findById(id);
    }
}
