package pl.edu.agh.ztis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.agh.ztis.entity.RawNote;

/**
 * Created by Jakub Sloniec on 2016-04-03.
 */

@Repository
public interface RawNoteRepository extends CrudRepository<RawNote, Long> {
}

