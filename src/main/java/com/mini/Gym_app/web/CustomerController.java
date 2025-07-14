package com.mini.Gym_app.web;

import com.mini.Gym_app.domain.Customer;
import com.mini.Gym_app.service.CustomUserDetailService;
import com.mini.Gym_app.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/register")
    public String showRegisterForm(ModelMap model) {
        model.put("customer", new Customer());
        return "register";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute Customer customer) {
        customerService.registerCustomer(customer);
        return "redirect:/login";
    }

}
