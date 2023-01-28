package com.example.cine.controllers;

import com.example.cine.dto.UserDto;
import com.example.cine.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private UserService service;

    @Autowired
    public LoginController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/login")
    public String logearSistema(Model model){
        model.addAttribute("login",new UserDto());
        model.addAttribute("palabra","Hello World");
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(@PathVariable("UserDto") UserDto user){
        return "";
    }
}
