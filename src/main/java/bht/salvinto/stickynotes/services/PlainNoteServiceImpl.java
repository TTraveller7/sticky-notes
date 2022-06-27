package bht.salvinto.stickynotes.services;

import bht.salvinto.stickynotes.domain.PlainNote;
import bht.salvinto.stickynotes.repositories.PlainNoteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
