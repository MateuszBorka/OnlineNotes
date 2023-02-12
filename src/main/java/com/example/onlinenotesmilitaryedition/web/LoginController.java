package com.example.onlinenotesmilitaryedition.web;

import com.example.onlinenotesmilitaryedition.dao.UserService;
import com.example.onlinenotesmilitaryedition.models.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("user", new User());
        return "loginPage";
    }


    @PostMapping("/loginPage")
    public String login(@ModelAttribute @NotNull User user, Model model) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            // Login successful, save the user in the session
            model.addAttribute("user", existingUser);
            return "redirect:/notes";
        } else {
            // Login failed, show error message
            model.addAttribute("error", "Invalid username or password");
            return "loginPage";
        }
    }
    
    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registrationPage";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute @NotNull User user, Model model) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser == null) {
            // Save the new user in the database
            userService.save(user);
            // Redirect to the login page
            return "redirect:/";
        } else {
            // Show error message
            model.addAttribute("message", "Username already exists");
            return "registrationPage";
        }
    }


}
