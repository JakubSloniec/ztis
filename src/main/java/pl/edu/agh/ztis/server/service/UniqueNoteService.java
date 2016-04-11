package pl.edu.agh.ztis.server.service;

import pl.edu.agh.ztis.entity.UniqueNote;

import java.util.List;

/**
 * Created by Jakub Sloniec on 11.04.2016.
 */
public interface UniqueNoteService {

    List<UniqueNote> getAll();

    UniqueNote getOne(Long id);

    UniqueNote save(UniqueNote note);

    List<UniqueNote> save(List<UniqueNote> notes);

}
