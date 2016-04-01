package pl.edu.agh.ztis.service.impl;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import pl.edu.agh.ztis.configuration.Configuration;
import pl.edu.agh.ztis.entity.*;
import pl.edu.agh.ztis.service.CsvParserService;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

/**
 * Created by kkicinger on 01/04/16.
 */
@Service
public class CsvParserServiceImpl implements CsvParserService {

//    @Override
//    public NotesTuple parseSampleDataNotes(Path directory) throws Exception {
//        return parseNotes(directory, Configuration.SAMPLE_DATA_TAGGED_CSV_FILE_NAME);
//    }

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
