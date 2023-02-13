package com.example.onlinenotesmilitaryedition.web;

import com.example.onlinenotesmilitaryedition.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {


    public LoginController() {
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("user", new User());
        return "loginPage";
    }


}
