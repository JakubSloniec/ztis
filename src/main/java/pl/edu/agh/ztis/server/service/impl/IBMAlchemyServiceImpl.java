package pl.edu.agh.ztis.server.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.edu.agh.ztis.entity.Note;
import pl.edu.agh.ztis.serializer.ibmalchemy.Sentiment;
import pl.edu.agh.ztis.serializer.ibmalchemy.concepts.Concept;
import pl.edu.agh.ztis.serializer.ibmalchemy.concepts.IBMAlchemyConceptsResponse;
import pl.edu.agh.ztis.serializer.ibmalchemy.emotions.Emotions;
import pl.edu.agh.ztis.serializer.ibmalchemy.emotions.IBMAlchemyEmotionsResponse;
import pl.edu.agh.ztis.serializer.ibmalchemy.keywords.IBMAlchemyKeywordsResponse;
import pl.edu.agh.ztis.serializer.ibmalchemy.keywords.Keyword;
import pl.edu.agh.ztis.serializer.ibmalchemy.sentiment.IBMAlchemyDocumentSentimentResponse;
import pl.edu.agh.ztis.serializer.ibmalchemy.taxonomy.IBMAlchemyTaxonomyResponse;
import pl.edu.agh.ztis.serializer.ibmalchemy.taxonomy.Taxonomy;
import pl.edu.agh.ztis.server.configuration.Configuration;
import pl.edu.agh.ztis.server.service.IBMAlchemyService;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kkicinger on 20/04/16.
 */
@Service
public class IBMAlchemyServiceImpl implements IBMAlchemyService {

    @Override
    public List<Keyword> getKeywordsForNote(Note note) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<IBMAlchemyKeywordsResponse> response = restTemplate.getForEntity(getUri(Configuration.IBM_ALCHEMY_KEYWORDS_URL, getKeywordsQueryParametersMap(note)), IBMAlchemyKeywordsResponse.class);
        return response.getBody().getKeywords();
    }

    @Override
    public List<Taxonomy> getTaxonomyForNote(Note note) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<IBMAlchemyTaxonomyResponse> response = restTemplate.getForEntity(getUri(Configuration.IBM_ALCHEMY_TAXONOMY_URL, getGenericQueryParametersMap(note)), IBMAlchemyTaxonomyResponse.class);
        return response.getBody().getTaxonomy();
    }

    @Override
    public List<Concept> getConceptsForNote(Note note) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<IBMAlchemyConceptsResponse> response = restTemplate.getForEntity(getUri(Configuration.IBM_ALCHEMY_CONCEPT_URL, getGenericQueryParametersMap(note)), IBMAlchemyConceptsResponse.class);
        return response.getBody().getConcepts();
    }

    @Override
    public Emotions getEmotionsForNote(Note note) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<IBMAlchemyEmotionsResponse> response = restTemplate.getForEntity(getUri(Configuration.IBM_ALCHEMY_EMOTIONS_URL, getGenericQueryParametersMap(note)), IBMAlchemyEmotionsResponse.class);
        return response.getBody().getDocEmotions();
    }

    @Override
    public Sentiment getNoteSentiment(Note note) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<IBMAlchemyDocumentSentimentResponse> response = restTemplate.getForEntity(getUri(Configuration.IBM_ALCHEMY_SENTIMENT_URL, getGenericQueryParametersMap(note)), IBMAlchemyDocumentSentimentResponse.class);
        return response.getBody().getDocSentiment();
    }

    private Map<String, Object> getKeywordsQueryParametersMap(Note note) {
        Map<String, Object> parameters = new LinkedHashMap<>(getGenericQueryParametersMap(note));
        parameters.put(Configuration.Params.IBM_ALCHEMY_SENTIMENT, Configuration.IBM_ALCHEMY_DEFAULT_SENTIMENT);            // +1 transaction
//        parameters.put(Configuration.Params.IBM_ALCHEMY_KNOWLEDGE_GRAPH_MODE, "aed104a71c35e94bbce01ab18cbf48d63f6c9424");    // +1 transaction
        return parameters;
    }

    private Map<String, Object> getGenericQueryParametersMap(Note note) {
        Map<String, Object> parameters = new LinkedHashMap<>();
        parameters.put(Configuration.Params.IBM_ALCHEMY_API_KEY, Configuration.IBM_ALCHEMY_DEFAULT_API_KEY);
        parameters.put(Configuration.Params.IBM_ALCHEMY_TEXT, getNoteText(note));
        parameters.put(Configuration.Params.IBM_ALCHEMY_OUTPUT_MODE, Configuration.IBM_ALCHEMY_DEFAULT_OUTPUT_MODE);
        return parameters;
    }

    private URI getUri(String baseUrl, Map<String, Object> parameters) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl);
        parameters.forEach((key, value) -> builder.queryParam(key, value));
        return builder.build().encode().toUri();
    }

    private String getNoteText(Note note) {
        return new StringBuilder().append(note.getTitle()).append(". ").append(note.getContent()).toString();
    }

}
