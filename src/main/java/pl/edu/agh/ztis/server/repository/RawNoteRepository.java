package pl.edu.agh.ztis.server.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.agh.ztis.entity.RawNote;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by Jakub Sloniec on 2016-04-03.
 */

@Repository
@PersistenceContext(type = PersistenceContextType.EXTENDED)
public interface RawNoteRepository extends CrudRepository<RawNote, Long>, JpaSpecificationExecutor<RawNote> {
}

