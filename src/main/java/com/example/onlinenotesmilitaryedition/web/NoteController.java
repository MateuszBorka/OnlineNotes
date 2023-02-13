package com.example.onlinenotesmilitaryedition.web;


import com.example.onlinenotesmilitaryedition.dao.NoteServiceImpl;
import com.example.onlinenotesmilitaryedition.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.onlinenotesmilitaryedition.models.Note;

import java.util.List;

@Controller
public class NoteController {


    private final NoteServiceImpl noteService;

    @Autowired
    public NoteController(NoteServiceImpl noteService){
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public String displayNotes(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Note> notes = noteService.findAllByUserId(user.getId());
        model.addAttribute("notes", notes);
        return "notes";
    }

    @GetMapping("/createNote")
    public String displayCreateNote(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
        return "createNote";
    }

    @PostMapping("/createNote")
    public String addNote(@ModelAttribute User user, Model model){
        return "redirect:/notes";
    }


    @PostMapping("/saveNote")
    public String saveNote(@RequestParam("noteTitle") String noteTitle,
                           @RequestParam("noteBody") String noteBody,
                           HttpSession session) {
        Note note = new Note();
        User user = (User) session.getAttribute("user");
        note.setTitle(noteTitle);
        note.setBody(noteBody);
        note.setUserId(user.getId());
        noteService.save(note);
        return "redirect:/notes";
    }

    @GetMapping("/note/{id}")
    public String getNote(@PathVariable Long id, Model model) {
        Note note = noteService.findById(id);
        model.addAttribute("note", note);
        return "note";
    }

    @GetMapping("/deleteNote")
    public String deleteNotes(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Note> notes = noteService.findAllByUserId(user.getId());
        model.addAttribute("notes", notes);
        return "deleteNote";
    }

    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable Long id, Model model){
        noteService.deleteById(id);
        return "redirect:/notes";
    }

}
