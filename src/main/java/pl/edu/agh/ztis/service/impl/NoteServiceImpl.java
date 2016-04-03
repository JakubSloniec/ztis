package pl.edu.agh.ztis.service.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.ztis.entity.Note;
import pl.edu.agh.ztis.entity.RawNote;
import pl.edu.agh.ztis.entity.TaggedNote;
import pl.edu.agh.ztis.entity.UniqueNote;
import pl.edu.agh.ztis.repository.NoteRepository;
import pl.edu.agh.ztis.repository.RawNoteRepository;
import pl.edu.agh.ztis.repository.TaggedNoteRepository;
import pl.edu.agh.ztis.repository.UniqueNoteRepository;
import pl.edu.agh.ztis.service.CsvParserService;
import pl.edu.agh.ztis.service.NoteService;

import java.util.List;

/**
 * Created by Jakub Sloniec on 21.03.2016.
 */

@Service
public class NoteServiceImpl implements NoteService {

	private static final Logger LOGGER = LogManager.getLogger(NoteServiceImpl.class);

	@Autowired
	private NoteRepository noteRepository;

	@Autowired
	private RawNoteRepository rawNoteRepository;

	@Autowired
	private TaggedNoteRepository taggedNoteRepository;

	@Autowired
	private UniqueNoteRepository uniqueNoteRepository;

	@Override
	public List<Note> getAll() {
		return (List<Note>) noteRepository.findAll();
	}

	@Override
	public List<RawNote> getAllRaw() {
		return (List<RawNote>) rawNoteRepository.findAll();
	}

	@Override
	public List<TaggedNote> getAllTagged() {
		return (List<TaggedNote>) taggedNoteRepository.findAll();
	}

	@Override
	public List<UniqueNote> getAllUnique() {
		return (List<UniqueNote>) uniqueNoteRepository.findAll();
	}

	@Override
	public Note getOne(Long id) {
		return noteRepository.findOne(id);
	}

	@Override
	public RawNote getOneRaw(Long id) {
		return rawNoteRepository.findOne(id);
	}

	@Override
	public TaggedNote getOneTagged(Long id) {
		return taggedNoteRepository.findOne(id);
	}

	@Override
	public UniqueNote getOneUnique(Long id) {
		return uniqueNoteRepository.findOne(id);
	}

	@Override
	public void saveAll(CsvParserService.NotesTuple notesTuple) {
		taggedNoteRepository.save(notesTuple.getTaggedNotes());
		uniqueNoteRepository.save(notesTuple.getUniqueNotes());
		rawNoteRepository.save(notesTuple.getRawNotes());
	}

	@Override
	public void saveRawNotes(List<RawNote> notes) {
		rawNoteRepository.save(notes);
	}

	@Override
	public void saveTaggedNotes(List<TaggedNote> notes) {
		taggedNoteRepository.save(notes);
	}

	@Override
	public void saveUniqueNotes(List<UniqueNote> notes) {
		uniqueNoteRepository.save(notes);
	}


}
