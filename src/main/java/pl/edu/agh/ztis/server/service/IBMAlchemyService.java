package pl.edu.agh.ztis.server.service;

import pl.edu.agh.ztis.entity.Note;
import pl.edu.agh.ztis.serializer.ibmalchemy.Sentiment;
import pl.edu.agh.ztis.serializer.ibmalchemy.concepts.Concept;
import pl.edu.agh.ztis.serializer.ibmalchemy.emotions.Emotions;
import pl.edu.agh.ztis.serializer.ibmalchemy.keywords.Keyword;
import pl.edu.agh.ztis.serializer.ibmalchemy.taxonomy.Taxonomy;

import java.util.List;

/**
 * Created by kkicinger on 19/04/16.
 */
public interface IBMAlchemyService {

    List<Keyword> getKeywordsForNote(Note note);

    List<Taxonomy> getTaxonomyForNote(Note note);

    List<Concept> getConceptsForNote(Note note);

    Emotions getEmotionsForNote(Note note);

    Sentiment getNoteSentiment(Note note);

}
