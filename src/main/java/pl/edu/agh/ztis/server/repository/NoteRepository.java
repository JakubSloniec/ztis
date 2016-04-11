package pl.edu.agh.ztis.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.agh.ztis.entity.Note;

/**
 * Created by Jakub Sloniec on 21.03.2016.
 */

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
}
