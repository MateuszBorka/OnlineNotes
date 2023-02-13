package com.example.onlinenotesmilitaryedition.web;

import com.example.onlinenotesmilitaryedition.dao.UserService;
import com.example.onlinenotesmilitaryedition.models.Note;
import com.example.onlinenotesmilitaryedition.models.User;
import com.example.onlinenotesmilitaryedition.validators.UserValidator;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, UserValidator userValidator){
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registrationPage";
    }



    @PostMapping("/register")
    public String registerUser(@ModelAttribute @Valid User user, BindingResult result, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            model.addAttribute("message", "Username already exists");
            return "registrationPage";
        } else {
            // Save the new user in the database
            userService.save(user);
            // Redirect to the login page
            return "redirect:/";
        }
    }


    @PostMapping("/loginPage")
    public String login(@ModelAttribute User user, Model model, HttpSession session) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            // Login successful, save the user in the session
            session.setAttribute("user", existingUser);
            return "redirect:/notes";
        } else {
            // Login failed, show error message
            model.addAttribute("error", "Invalid username or password");
            return "loginPage";
        }
    }
}


