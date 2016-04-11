package pl.edu.agh.ztis.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.ztis.entity.TaggedNote;
import pl.edu.agh.ztis.server.repository.TaggedNoteRepository;
import pl.edu.agh.ztis.server.service.TaggedNoteService;

import java.util.List;

/**
 * Created by Jakub Sloniec on 11.04.2016.
 */

@Service
public class TaggedNoteServiceImpl implements TaggedNoteService {

    @Autowired
    private TaggedNoteRepository taggedNoteRepository;

    @Override
    public List<TaggedNote> getAll() {
        return (List<TaggedNote>) taggedNoteRepository.findAll();
    }

    @Override
    public TaggedNote getOne(Long id) {
        return taggedNoteRepository.findOne(id);
    }

    @Override
    public TaggedNote save(TaggedNote note) {
        return taggedNoteRepository.save(note);
    }

    @Override
    public List<TaggedNote> save(List<TaggedNote> notes) {
        return (List<TaggedNote>) taggedNoteRepository.save(notes);
    }
}
