package pl.edu.agh.ztis.server.service;

import pl.edu.agh.ztis.entity.RawNote;

import java.util.List;

/**
 * Created by Jakub Sloniec on 11.04.2016.
 */

public interface RawNoteService {

    List<RawNote> getAll();

    RawNote getOne(Long id);

    RawNote save(RawNote note);

    List<RawNote> save(List<RawNote> notes);

}
