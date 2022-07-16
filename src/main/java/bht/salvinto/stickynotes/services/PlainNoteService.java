package bht.salvinto.stickynotes.services;

import bht.salvinto.stickynotes.domain.PlainNote;

import java.util.Optional;

public interface PlainNoteService {
    Optional<PlainNote> findById(Long id);
}
