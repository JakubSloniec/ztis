package pl.edu.agh.ztis.importer;

import pl.edu.agh.ztis.configuration.Configuration;
import pl.edu.agh.ztis.service.CsvParserService;
import pl.edu.agh.ztis.service.impl.CsvParserServiceImpl;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.function.Function;

/**
 * Created by kkicinger on 31/03/16.
 */
public class NotesImporter {

    private static CsvParserService parserService = new CsvParserServiceImpl();

    static class GeomediaFullDataClassImporter extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return loadDataFromDirectory(dir, d -> {
                try {
                    return parserService.parseFullDataNotes(d);
                } catch (Exception e) {
                    throw new RuntimeException("Problem");
                }
            });
        }

    }

    public static void main(String[] args) throws Exception {
        // Files.walkFileTree(Configuration.GEOMEDIA_SAMPLE_DATA_PATH, new GeomediaSampleDataClassImporter());
        Files.walkFileTree(Configuration.GEOMEDIA_FULL_DATA_PATH, new GeomediaFullDataClassImporter());
    }

    public static FileVisitResult loadDataFromDirectory(Path dir, Function<Path, CsvParserService.NotesTuple> notesTupleFunction) {
        if (dir.getFileName().toString().matches(Configuration.DATA_DIRECTORY_REGEX)) {
            try {
                System.out.println(dir.getFileName());
                CsvParserService.NotesTuple notesTuple = notesTupleFunction.apply(dir);
                System.out.println("\tRaw Notes: " + notesTuple.getRawNotes().size());
                System.out.println("\tUnique Notes: " + notesTuple.getUniqueNotes().size());
                System.out.println("\tTagged Notes: " + notesTuple.getTaggedNotes().size());
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return FileVisitResult.CONTINUE;
    }

}
