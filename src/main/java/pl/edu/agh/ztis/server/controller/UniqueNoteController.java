package pl.edu.agh.ztis.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.ztis.entity.UniqueNote;
import pl.edu.agh.ztis.server.service.UniqueNoteService;
import pl.edu.agh.ztis.server.swagger.SwaggerContainer;

import java.util.List;

/**
 * Created by Jakub Sloniec on 11.04.2016.
 */

@RestController
@RequestMapping("/api/unique")
@Api(value = "unique note", description = "Unique Notes API")
public class UniqueNoteController {

    @Autowired
    private UniqueNoteService noteService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "get all notes", notes = "returns a list of all notes", response = UniqueNote.class, responseContainer = SwaggerContainer.LIST)
    List<UniqueNote> getAll() {
        return noteService.getAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "get note by id", notes = "returns note by id", response = UniqueNote.class)
    UniqueNote getOne(@RequestParam("id") Long id) {
        return noteService.getOne(id);
    }

    @RequestMapping(value = "/raw/all", method = RequestMethod.GET)
    @ApiOperation(value = "save note", notes = "saves note", response = UniqueNote.class)
    UniqueNote saveOne(@RequestBody UniqueNote note) {
        return noteService.save(note);
    }

}

