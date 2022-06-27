package bht.salvinto.stickynotes.services;

import bht.salvinto.stickynotes.domain.PlainNote;

import java.util.List;

public interface PlainNoteService {
    Iterable<PlainNote> findAll();
}
