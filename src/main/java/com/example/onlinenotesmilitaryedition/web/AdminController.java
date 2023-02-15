package com.example.onlinenotesmilitaryedition.web;

import com.example.onlinenotesmilitaryedition.dao.NoteService;
import com.example.onlinenotesmilitaryedition.dao.NoteServiceImpl;
import com.example.onlinenotesmilitaryedition.dao.UserService;
import com.example.onlinenotesmilitaryedition.models.Note;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.onlinenotesmilitaryedition.models.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;
    private final NoteServiceImpl noteService;


    @Autowired
    public AdminController(UserService userService, NoteServiceImpl noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }


    @GetMapping("/adminPanel")
    public String adminPanel(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "adminPanel";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "deleteUser";
    }


    @GetMapping("/deleteUser/{id}")
    public String deleteUserById(@PathVariable Long id){
        userService.deleteById(id);
        return "redirect:/adminPanel";
    }


    @GetMapping("/usersNotes/{userid}")
    public String displayUsersNotes(@PathVariable Long userid, Model model){
        List<Note> notes = noteService.findAllByUserId(userid);
        model.addAttribute("notes", notes);
        return "/userNotes";
    }


    @GetMapping("/viewNote/{id}")
    public String getNote(@PathVariable Long id, Model model, HttpSession session) {
        Note note = noteService.findById(id);
        session.setAttribute("note", note);
        model.addAttribute("note", note);
        return "viewNote";
    }



}
