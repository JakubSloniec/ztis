package pl.edu.agh.ztis.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.ztis.entity.TaggedNote;
import pl.edu.agh.ztis.server.service.TaggedNoteService;
import pl.edu.agh.ztis.server.swagger.SwaggerContainer;

import java.util.List;

/**
 * Created by Jakub Sloniec on 11.04.2016.
 */

@RestController
@RequestMapping("/api/tagged")
@Api(value = "tagged note", description = "Tagged Notes API")
public class TaggedNoteController {

    @Autowired
    private TaggedNoteService noteService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "get all notes", notes = "returns a list of all notes", response = TaggedNote.class, responseContainer = SwaggerContainer.LIST)
    List<TaggedNote> getAll() {
        return noteService.getAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "get note by id", notes = "returns note by id", response = TaggedNote.class)
    TaggedNote getOne(@RequestParam("id") Long id) {
        return noteService.getOne(id);
    }

    @RequestMapping(value = "/raw/all", method = RequestMethod.GET)
    @ApiOperation(value = "save note", notes = "saves note", response = TaggedNote.class)
    TaggedNote saveOne(@RequestBody TaggedNote note) {
        return noteService.save(note);
    }

}
