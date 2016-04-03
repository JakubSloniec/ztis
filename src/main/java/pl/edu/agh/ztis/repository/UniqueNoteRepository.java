package pl.edu.agh.ztis.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.agh.ztis.entity.UniqueNote;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by Jakub Sloniec on 2016-04-03.
 */

@Repository
@PersistenceContext(type = PersistenceContextType.EXTENDED)
public interface UniqueNoteRepository extends CrudRepository<UniqueNote, Long>, JpaSpecificationExecutor<UniqueNote> {
}

