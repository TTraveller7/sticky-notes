package bht.salvinto.stickynotes.repositories;

import bht.salvinto.stickynotes.domain.Note;
import org.springframework.data.repository.CrudRepository;

public interface PlainNoteRepository extends CrudRepository<Note, Long> {
}
