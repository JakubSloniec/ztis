package pl.edu.agh.ztis.service;

import pl.edu.agh.ztis.entity.Note;

import java.util.List;

/**
 * Created by Jakub Sloniec on 21.03.2016.
 */
public interface NoteService {

	List<Note> getAll();

	Note getOne(Long id);
}
