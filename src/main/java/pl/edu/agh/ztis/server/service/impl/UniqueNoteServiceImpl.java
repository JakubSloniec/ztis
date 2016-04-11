package pl.edu.agh.ztis.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.ztis.entity.UniqueNote;
import pl.edu.agh.ztis.server.repository.UniqueNoteRepository;
import pl.edu.agh.ztis.server.service.UniqueNoteService;

import java.util.List;

/**
 * Created by Jakub Sloniec on 11.04.2016.
 */

@Service
public class UniqueNoteServiceImpl implements UniqueNoteService {

    @Autowired
    private UniqueNoteRepository uniqueNoteRepository;

    @Override
    public List<UniqueNote> getAll() {
        return (List<UniqueNote>) uniqueNoteRepository.findAll();
    }

    @Override
    public UniqueNote getOne(Long id) {
        return uniqueNoteRepository.findOne(id);
    }

    @Override
    public UniqueNote save(UniqueNote note) {
        return uniqueNoteRepository.save(note);
    }

    @Override
    public List<UniqueNote> save(List<UniqueNote> notes) {
        return (List<UniqueNote>) uniqueNoteRepository.save(notes);
    }
}

