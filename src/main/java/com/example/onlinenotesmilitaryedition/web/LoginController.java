package com.example.onlinenotesmilitaryedition.web;

import com.example.onlinenotesmilitaryedition.dao.UserService;
import com.example.onlinenotesmilitaryedition.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            // Login successful, save the user in the session
            model.addAttribute("user", existingUser);
            return "redirect:/notes";
        } else {
            // Login failed, show error message
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
