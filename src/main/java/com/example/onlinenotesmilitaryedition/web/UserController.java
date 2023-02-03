package com.example.onlinenotesmilitaryedition.web;

import com.example.onlinenotesmilitaryedition.dao.UserService;
import com.example.onlinenotesmilitaryedition.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "views/registerForm";
    }

    @PostMapping("/user/register")
    public String registerUser(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "views/registerForm";
        }
        userService.save(user);
        return "views/login";
    }

    @GetMapping("/user/login")
    public String login() {
        return "views/login";
    }

}


