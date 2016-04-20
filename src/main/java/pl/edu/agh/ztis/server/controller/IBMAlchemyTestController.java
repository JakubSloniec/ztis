package pl.edu.agh.ztis.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.ztis.entity.Note;
import pl.edu.agh.ztis.entity.TaggedNote;
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
        Note note = new TaggedNote();
        note.setTitle("Schumacher exits critical period");
        note.setContent("MICHAEL Schumacher's chances of survival appeared to improve yesterday as he emerged from the initial, critical period of his hospitalisation.");
        return new ResponseEntity<>(ibmAlchemyService.getKeywordsForNote(note), HttpStatus.OK);
    }


    @RequestMapping(value = "/taxonomy", method = RequestMethod.GET)
    @ApiOperation(value = "test taxonomy evaluation", notes = "test taxonomy evaluation", response = Taxonomy.class, responseContainer = SwaggerContainer.LIST)
    ResponseEntity<List<Taxonomy>> getTaxonomy() {
        Note note = new TaggedNote();
        note.setTitle("Schumacher exits critical period");
        note.setContent("MICHAEL Schumacher's chances of survival appeared to improve yesterday as he emerged from the initial, critical period of his hospitalisation.");
        return new ResponseEntity<>(ibmAlchemyService.getTaxonomyForNote(note), HttpStatus.OK);
    }

}
