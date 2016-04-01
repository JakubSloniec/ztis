package pl.edu.agh.ztis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.ztis.entity.Note;
import pl.edu.agh.ztis.repository.NoteRepository;
import pl.edu.agh.ztis.service.CsvParserService;
import pl.edu.agh.ztis.service.NoteService;

import java.util.List;

/**
 * Created by Jakub Sloniec on 21.03.2016.
 */

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private CsvParserService csvParserService;

	@Autowired
	private NoteRepository noteRepository;

	@Override
	public List<Note> getAll() {
		return (List<Note>) noteRepository.findAll();
	}

	@Override
	public Note getOne(Long id) {
		return noteRepository.findOne(id);
	}
}
