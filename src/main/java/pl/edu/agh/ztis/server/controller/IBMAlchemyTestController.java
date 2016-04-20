package pl.edu.agh.ztis.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.ztis.entity.Note;
import pl.edu.agh.ztis.entity.TaggedNote;
import pl.edu.agh.ztis.serializer.ibmalchemy.Sentiment;
import pl.edu.agh.ztis.serializer.ibmalchemy.concepts.Concept;
import pl.edu.agh.ztis.serializer.ibmalchemy.emotions.Emotions;
import pl.edu.agh.ztis.serializer.ibmalchemy.keywords.Keyword;
import pl.edu.agh.ztis.serializer.ibmalchemy.taxonomy.Taxonomy;
import pl.edu.agh.ztis.server.service.IBMAlchemyService;
import pl.edu.agh.ztis.server.swagger.SwaggerContainer;

import java.util.List;

/**
 * Created by kkicinger on 20/04/16.
 */
@RestController
@RequestMapping("/api/ibm")
@Api(value = "ibm", description = "IBM Alchemy API")
public class IBMAlchemyTestController {

    @Autowired
    private IBMAlchemyService ibmAlchemyService;

    @RequestMapping(value = "/keywords", method = RequestMethod.GET)
    @ApiOperation(value = "test keywords extraction", notes = "test keywords extraction", response = Keyword.class, responseContainer = SwaggerContainer.LIST)
    ResponseEntity<List<Keyword>> getKeywords() {
        return new ResponseEntity<>(ibmAlchemyService.getKeywordsForNote(getNote()), HttpStatus.OK);
    }


    @RequestMapping(value = "/taxonomy", method = RequestMethod.GET)
    @ApiOperation(value = "test taxonomy evaluation", notes = "test taxonomy evaluation", response = Taxonomy.class, responseContainer = SwaggerContainer.LIST)
    ResponseEntity<List<Taxonomy>> getTaxonomy() {
        return new ResponseEntity<>(ibmAlchemyService.getTaxonomyForNote(getNote()), HttpStatus.OK);
    }

    @RequestMapping(value = "/concepts", method = RequestMethod.GET)
    @ApiOperation(value = "test keywords extraction", notes = "test keywords extraction", response = Concept.class, responseContainer = SwaggerContainer.LIST)
    ResponseEntity<List<Concept>> getConcepts() {
        return new ResponseEntity<>(ibmAlchemyService.getConceptsForNote(getNote()), HttpStatus.OK);
    }


    @RequestMapping(value = "/emotions", method = RequestMethod.GET)
    @ApiOperation(value = "emotions detection", notes = "emotions detection", response = Emotions.class)
    ResponseEntity<Emotions> getEmotions() {
        return new ResponseEntity<>(ibmAlchemyService.getEmotionsForNote(getNote()), HttpStatus.OK);
    }


    @RequestMapping(value = "/sentiment", method = RequestMethod.GET)
    @ApiOperation(value = "sentiment", notes = "sentiment", response = Sentiment.class)
    ResponseEntity<Sentiment> getSentiment() {
        return new ResponseEntity<>(ibmAlchemyService.getNoteSentiment(getNote()), HttpStatus.OK);
    }

    @RequestMapping(value = "/keywords", method = RequestMethod.POST)
    @ApiOperation(value = "test keywords extraction", notes = "test keywords extraction", response = Keyword.class, responseContainer = SwaggerContainer.LIST)
    ResponseEntity<List<Keyword>> getKeywordsForNote(@RequestBody Note note) {
        return new ResponseEntity<>(ibmAlchemyService.getKeywordsForNote(getNote()), HttpStatus.OK);
    }


    @RequestMapping(value = "/taxonomy", method = RequestMethod.POST)
    @ApiOperation(value = "test taxonomy evaluation", notes = "test taxonomy evaluation", response = Taxonomy.class, responseContainer = SwaggerContainer.LIST)
    ResponseEntity<List<Taxonomy>> getTaxonomyForNote(@RequestBody Note note) {
        return new ResponseEntity<>(ibmAlchemyService.getTaxonomyForNote(getNote()), HttpStatus.OK);
    }

    @RequestMapping(value = "/concepts", method = RequestMethod.POST)
    @ApiOperation(value = "test contepts extraction", notes = "test contepts extraction", response = Concept.class, responseContainer = SwaggerContainer.LIST)
    ResponseEntity<List<Concept>> getConceptsForNote(@RequestBody Note note) {
        return new ResponseEntity<>(ibmAlchemyService.getConceptsForNote(note), HttpStatus.OK);
    }


    @RequestMapping(value = "/emotions", method = RequestMethod.POST)
    @ApiOperation(value = "emotions detection", notes = "emotions detection", response = Emotions.class)
    ResponseEntity<Emotions> getEmotionsForNote(@RequestBody Note note) {
        return new ResponseEntity<>(ibmAlchemyService.getEmotionsForNote(getNote()), HttpStatus.OK);
    }


    @RequestMapping(value = "/sentiment", method = RequestMethod.POST)
    @ApiOperation(value = "sentiment", notes = "sentiment", response = Sentiment.class)
    ResponseEntity<Sentiment> getSentimentForNote(@RequestBody Note note) {
        return new ResponseEntity<>(ibmAlchemyService.getNoteSentiment(getNote()), HttpStatus.OK);
    }

    private Note getNote() {
        Note note = new TaggedNote();
        note.setTitle("Schumacher exits critical period");
        note.setContent("MICHAEL Schumacher's chances of survival appeared to improve yesterday as he emerged from the initial, critical period of his hospitalisation.");
        return note;
    }

}
