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
        // Add the logged-in username to the ModelMap
        if (user != null) {
            model.addAttribute("username", user.getUsername());
        }
        return "home";  // Return the home.html page
    }
}
