package com.example.onlinenotesmilitaryedition.web;


import com.example.onlinenotesmilitaryedition.dao.NoteService;
import com.example.onlinenotesmilitaryedition.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.onlinenotesmilitaryedition.models.Note;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {


    private final NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @PostMapping
    public Note saveNote(@RequestBody Note note){
        return noteService.save(note);
    }

    @GetMapping
    public List<Note> findAllNotes() {
        return noteService.findAll();
    }

    @GetMapping("/{id}")
    public Note findNoteById(@PathVariable("id") long id){
        return noteService.findByUserId(id);
    }


    @PutMapping("/{id}")
    public Note updateNote(@PathVariable("id") long id, @RequestBody Note note) {
        note.setId(id);
        return noteService.save(note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable("id") long id){
        noteService.deleteById(id);
    }
}
