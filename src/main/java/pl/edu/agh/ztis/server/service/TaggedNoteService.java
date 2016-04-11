package pl.edu.agh.ztis.server.service;

import pl.edu.agh.ztis.entity.TaggedNote;

import java.util.List;

/**
 * Created by Jakub Sloniec on 11.04.2016.
 */
public interface TaggedNoteService {

    List<TaggedNote> getAll();

    TaggedNote getOne(Long id);

    TaggedNote save(TaggedNote note);

    List<TaggedNote> save(List<TaggedNote> notes);

}
