package pl.edu.agh.ztis.server.service;

import pl.edu.agh.ztis.entity.Note;
import pl.edu.agh.ztis.serializer.ibmalchemy.keywords.Keyword;
import pl.edu.agh.ztis.serializer.ibmalchemy.taxonomy.Taxonomy;

import java.util.List;

/**
 * Created by kkicinger on 19/04/16.
 */
public interface IBMAlchemyService {

    List<Keyword> getKeywordsForNote(Note note);

    List<Taxonomy> getTaxonomyForNote(Note note);

}
