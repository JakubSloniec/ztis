package pl.edu.agh.ztis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.ztis.entity.Note;
import pl.edu.agh.ztis.service.NoteService;

import java.util.List;

/**
 * Created by Jakub Sloniec on 21.03.2016.
 */

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("/all")
    List<Note> getAll() {
        return noteService.getAll();
    }
}
