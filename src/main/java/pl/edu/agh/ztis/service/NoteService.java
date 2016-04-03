package pl.edu.agh.ztis.service;

import pl.edu.agh.ztis.entity.Note;
import pl.edu.agh.ztis.entity.RawNote;
import pl.edu.agh.ztis.entity.TaggedNote;
import pl.edu.agh.ztis.entity.UniqueNote;

import java.util.List;

/**
 * Created by Jakub Sloniec on 21.03.2016.
 */
public interface NoteService {

	List<Note> getAll();

	List<RawNote> getAllRaw();

	List<TaggedNote> getAllTagged();

	List<UniqueNote> getAllUnique();

	Note getOne(Long id);

	RawNote getOneRaw(Long id);

	TaggedNote getOneTagged(Long id);

	UniqueNote getOneUnique(Long id);

	void saveAll(CsvParserService.NotesTuple notesTuple);

	void saveRawNotes(List<RawNote> notes);

	void saveTaggedNotes(List<TaggedNote> notes);

	void saveUniqueNotes(List<UniqueNote> notes);

}
