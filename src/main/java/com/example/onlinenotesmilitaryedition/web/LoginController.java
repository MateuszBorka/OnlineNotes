package com.example.onlinenotesmilitaryedition.web;

import com.example.onlinenotesmilitaryedition.dao.UserService;
import com.example.onlinenotesmilitaryedition.models.User;
import com.example.onlinenotesmilitaryedition.validators.UserValidator;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;


@Controller
public class LoginController {


    private final UserService userService;
    private final UserValidator userValidator;

    @Autowired
    public LoginController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
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


}
