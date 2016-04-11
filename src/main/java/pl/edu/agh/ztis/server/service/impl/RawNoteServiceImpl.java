package pl.edu.agh.ztis.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.ztis.entity.RawNote;
import pl.edu.agh.ztis.server.repository.RawNoteRepository;
import pl.edu.agh.ztis.server.service.RawNoteService;

import java.util.List;

/**
 * Created by Jakub Sloniec on 11.04.2016.
 */

@Service
public class RawNoteServiceImpl implements RawNoteService {

    @Autowired
    private RawNoteRepository rawNoteRepository;

    @Override
    public List<RawNote> getAll() {
        return (List<RawNote>) rawNoteRepository.findAll();
    }

    @Override
    public RawNote getOne(Long id) {
        return rawNoteRepository.findOne(id);
    }

    @Override
    public RawNote save(RawNote note) {
        return rawNoteRepository.save(note);
    }

    @Override
    public List<RawNote> save(List<RawNote> notes) {
        return (List<RawNote>) rawNoteRepository.save(notes);
    }
}
