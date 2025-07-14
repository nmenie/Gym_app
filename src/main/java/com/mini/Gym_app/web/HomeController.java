package com.mini.Gym_app.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal User user, ModelMap model) {
        if (user != null) {
            model.put("username", user.getUsername());
        }
        return "home";  // This looks for home.html
    }
}

