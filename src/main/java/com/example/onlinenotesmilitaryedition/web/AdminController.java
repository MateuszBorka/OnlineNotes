package com.example.onlinenotesmilitaryedition.web;

import com.example.onlinenotesmilitaryedition.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.onlinenotesmilitaryedition.models.User;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/adminPanel")
    public String adminPanel(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "adminPanel";
    }
}
