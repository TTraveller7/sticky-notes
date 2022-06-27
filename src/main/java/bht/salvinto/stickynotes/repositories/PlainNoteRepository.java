package bht.salvinto.stickynotes.repositories;

import bht.salvinto.stickynotes.domain.PlainNote;
import org.springframework.data.repository.CrudRepository;

public interface PlainNoteRepository extends CrudRepository<PlainNote, Long> {
}
