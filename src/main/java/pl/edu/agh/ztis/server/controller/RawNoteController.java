package pl.edu.agh.ztis.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.agh.ztis.entity.Note;
import pl.edu.agh.ztis.entity.RawNote;
import pl.edu.agh.ztis.server.service.RawNoteService;
import pl.edu.agh.ztis.server.swagger.SwaggerContainer;

import java.util.List;

/**
 * Created by Jakub Sloniec on 21.03.2016.
 */

@RestController
@RequestMapping("/api/raw")
@Api(value = "raw note", description = "Raw Notes API")
public class RawNoteController {

    @Autowired
    private RawNoteService noteService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "get all notes", notes = "returns a list of all notes", response = RawNote.class, responseContainer = SwaggerContainer.LIST)
    List<RawNote> getAll() {
        return noteService.getAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "get note by id", notes = "returns note by id", response = RawNote.class)
    Note getOne(@RequestParam("id") Long id) {
        return noteService.getOne(id);
    }

    @RequestMapping(value = "/raw/all", method = RequestMethod.GET)
    @ApiOperation(value = "save note", notes = "saves note", response = RawNote.class)
    RawNote saveOne(@RequestBody RawNote note) {
        return noteService.save(note);
    }


}
