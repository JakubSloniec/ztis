package pl.edu.agh.ztis.service.impl;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.ztis.configuration.Configuration;
import pl.edu.agh.ztis.entity.*;
import pl.edu.agh.ztis.service.CsvParserService;
import pl.edu.agh.ztis.service.NoteService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

/**
 * Created by kkicinger on 01/04/16.
 */
@Service
public class CsvParserServiceImpl implements CsvParserService {

    private static final Logger LOGGER = LogManager.getLogger(CsvParserServiceImpl.class);

    @Autowired
    private NoteService noteService;

    @Override
    public void importData() throws Exception {
        Files.walkFileTree(Configuration.GEOMEDIA_FULL_DATA_PATH, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                try {
                    if (dir.getFileName().toString().matches(Configuration.DATA_DIRECTORY_REGEX)) {
                        NotesTuple notesTuple = parseFullDataNotes(dir);
                        LOGGER.info(dir.getFileName() + " raw notes: " + notesTuple.getRawNotes().size());
                        LOGGER.info(dir.getFileName() + " unique notes: " + notesTuple.getUniqueNotes().size());
                        LOGGER.info(dir.getFileName() + " tagged notes: " + notesTuple.getTaggedNotes().size());
                        // Save RawNotes
                        // Save UniqueNotes
                        // Save TaggedNotes
                    }
                    return FileVisitResult.CONTINUE;
                } catch (Exception e) {
                    throw new RuntimeException("Error encounter during data import process: ", e);
                }
            }
        });
    }

    @Override
    public NotesTuple parseFullDataNotes(Path directory) throws Exception {
        return parseNotes(directory, Configuration.FULL_DATA_TAGGED_CSV_FILE_NAME);
    }

    @Override
    public List<RawNote> parseRawNotesFile(Path path) throws Exception {
        return parseNotes(path, record -> parseNote(new RawNote(), record));
    }

    @Override
    public List<UniqueNote> parseUniqueNotesFile(Path path) throws Exception {
        return parseNotes(path, record -> parseNote(new UniqueNote(), record));
    }

    @Override
    public List<TaggedNote> parseTaggedNotesFile(Path path) throws Exception {
        return parseNotes(path, record -> {
            TaggedNote taggedNote = parseNote(new TaggedNote(), record);
            taggedNote.setCountryTag(record.get(Configuration.HEADER_TAG_COUNTRY));
            taggedNote.setEbolaConnected(!record.get(Configuration.HEADER_TAG_EBOLA).isEmpty());
            return taggedNote;
        });
    }

    private <T extends Note> T parseNote(T note, CSVRecord record) {
        try {
            String[] feed = record.get(Configuration.HEADER_FEED).split("_");
            note.setId(Long.valueOf(record.get(Configuration.HEADER_ID)));
            note.setLanguage(Language.get(feed[0]));
            note.setCountry(feed[1]);
            note.setMagazine(Magazine.get(feed[2]));
            note.setTime(Configuration.DATE_FORMAT.parse(record.get(Configuration.HEADER_TIME)));
            note.setTitle(record.get(Configuration.HEADER_TEXT_1));
            note.setContent(record.get(Configuration.HEADER_TEXT_2));
            tryToFindMentionedCity(note);
            return note;
        } catch (Exception e) {
            throw new RuntimeException("Unexpected exception", e);
        }
    }

    private String tryToFindMentionedCity(Note note) {
        Matcher matcher = Configuration.MENTIONED_CITY_PATTERN.matcher(note.getContent());
        return matcher.find() ? matcher.group() : "";
    }

    private <T> List<T> parseNotes(Path path, Function<CSVRecord, T> creatorFunction) throws Exception {
        final CSVParser parser = CSVParser.parse(path.toFile(), StandardCharsets.UTF_8, CSVFormat.TDF.withHeader());
        return parser.getRecords().stream().map(creatorFunction).collect(Collectors.toList());
    }

    private NotesTuple parseNotes(Path directory, String taggedNotesFileName) throws Exception {
        NotesTuple notesTuple = new NotesTuple();
        notesTuple.setRawNotes(parseRawNotesFile(Paths.get(directory.toString(), Configuration.RAW_CSV_FILE_NAME)));
        notesTuple.setUniqueNotes(parseUniqueNotesFile(Paths.get(directory.toString(), Configuration.UNIQUE_CSV_FILE_NAME)));
        notesTuple.setTaggedNotes(parseTaggedNotesFile(Paths.get(directory.toString(), taggedNotesFileName)));
        return notesTuple;
    }

}
