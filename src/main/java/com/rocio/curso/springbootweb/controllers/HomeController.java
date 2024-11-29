package com.rocio.curso.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //Controlador que no es api rest

    @GetMapping ("{"","/","home"}")
    public String home (){
        return "redirect:/list";
    }

}
