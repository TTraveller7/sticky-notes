package bht.salvinto.stickynotes.repositories;

import bht.salvinto.stickynotes.domain.TodoNote;
import org.springframework.data.repository.CrudRepository;

public interface TodoNoteRepository extends CrudRepository<TodoNote, Long> {
}
