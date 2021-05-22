package com.example.projektmaj2021.controller;

import com.example.projektmaj2021.entity.User;
import com.example.projektmaj2021.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user, Model model){
        userService.saveUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "user";
    }


}
