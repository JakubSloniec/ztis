package pl.edu.agh.ztis.service;

import pl.edu.agh.ztis.entity.TaggedNote;
import pl.edu.agh.ztis.entity.RawNote;
import pl.edu.agh.ztis.entity.UniqueNote;

import java.nio.file.Path;
import java.util.List;

/**
 * Created by kkicinger on 01/04/16.
 */
public interface CsvParserService {

    class NotesTuple {

        private List<RawNote> rawNotes;
        private List<UniqueNote> uniqueNotes;
        private List<TaggedNote> taggedNotes;

        public NotesTuple() {
        }

        public List<RawNote> getRawNotes() {
            return rawNotes;
        }

        public void setRawNotes(List<RawNote> rawNotes) {
            this.rawNotes = rawNotes;
        }

        public List<UniqueNote> getUniqueNotes() {
            return uniqueNotes;
        }

        public void setUniqueNotes(List<UniqueNote> uniqueNotes) {
            this.uniqueNotes = uniqueNotes;
        }

        public List<TaggedNote> getTaggedNotes() {
            return taggedNotes;
        }

        public void setTaggedNotes(List<TaggedNote> taggedNotes) {
            this.taggedNotes = taggedNotes;
        }

    }


    // NotesTuple parseSampleDataNotes(Path directory) throws Exception;

    NotesTuple parseFullDataNotes(Path directory) throws Exception;

    List<RawNote> parseRawNotesFile(Path path) throws Exception;

    List<UniqueNote> parseUniqueNotesFile(Path path) throws Exception;

    List<TaggedNote> parseTaggedNotesFile(Path path) throws Exception;

}
