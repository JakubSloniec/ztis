package pl.edu.agh.ztis.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    ResponseEntity<List<RawNote>> getAll() {
        return new ResponseEntity<>(noteService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "get note by id", notes = "returns note by id", response = RawNote.class)
    ResponseEntity<RawNote> getOne(@RequestParam("id") Long id) {
        return new ResponseEntity<>(noteService.getOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(value = "save note", notes = "saves note", response = RawNote.class)
    ResponseEntity<RawNote> saveOne(@RequestBody RawNote note) {
        return new ResponseEntity<>(noteService.save(note), HttpStatus.OK);
    }

}
