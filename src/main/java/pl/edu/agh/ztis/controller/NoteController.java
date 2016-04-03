package pl.edu.agh.ztis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.ztis.entity.Note;
import pl.edu.agh.ztis.entity.RawNote;
import pl.edu.agh.ztis.service.NoteService;
import pl.edu.agh.ztis.swagger.SwaggerContainer;

import java.util.List;

/**
 * Created by Jakub Sloniec on 21.03.2016.
 */

@RestController
@RequestMapping("/api/note")
@Api(value = "note", description = "Notes API")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ApiOperation(value = "get all notes", notes = "returns a list of all notes", response = Note.class, responseContainer = SwaggerContainer.LIST)
	List<Note> getAll() {
		return noteService.getAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "get note by id", notes = "returns note by id", response = Note.class)
	Note getOne(@RequestParam("id") Long id) {
		return noteService.getOne(id);
	}

	@RequestMapping(value = "/raw/all", method = RequestMethod.GET)
	List<RawNote> getAllRaw() {
		return noteService.getAllRaw();
	}

}
