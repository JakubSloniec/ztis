package pl.edu.agh.ztis.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.ztis.entity.Note;
import pl.edu.agh.ztis.service.NoteService;

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
	List<Note> getAll() {
		return noteService.getAll();
	}
}
