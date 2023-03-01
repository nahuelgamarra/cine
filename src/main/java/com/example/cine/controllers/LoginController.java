package com.example.cine.controllers;

import com.example.cine.dto.UserDto;
import com.example.cine.exceptions.UserNotFoundException;
import com.example.cine.models.User;
import com.example.cine.services.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private UserService service;

    @GetMapping(path = "/login")
    public ModelAndView logearSistema(){
        ModelMap model = new ModelMap();
        model.addAttribute("login",new UserDto());
        return new ModelAndView("login",model);
    }

    @PostMapping("/validarLogin")
    public ModelAndView validarLogin(@ModelAttribute("UserDto") UserDto userDto, HttpServletRequest request){
        ModelMap model = new ModelMap();
        User usuario = new User();
        try{
            Optional<User> usuarioBuscado = this.service.findUserByEmail(userDto.getEmail());
            if(usuarioBuscado.isPresent())
                request.setAttribute("user",usuarioBuscado.get());
        }catch (UserNotFoundException ex){
            model.put("error", ex.getMessage());
            return new ModelAndView("login", model);
        }
        return new ModelAndView("redirect:/home");
    }
}
