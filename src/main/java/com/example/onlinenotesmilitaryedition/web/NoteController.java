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

@Controller
public class NoteController {


    private final NoteServiceImpl noteService;

    @Autowired
    public NoteController(NoteServiceImpl noteService){
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public String displayNotes(@ModelAttribute User user, Model model){
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



}
