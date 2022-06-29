package bht.salvinto.stickynotes.services;

import bht.salvinto.stickynotes.domain.PlainNote;

public interface PlainNoteService {
    Iterable<PlainNote> findAll();
}
