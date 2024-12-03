package com.rocio.curso.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //Controlador que no es api rest

    @GetMapping ({"","/","home"})
    public String home (){
        return "redirect:/list"; //reinicia en navegador y lleva a la ruta indicada. Pierdes los datos de la request. 
       // return "fordward:/list"; Redirige sin reiniciar, no cambia ruta url  y mantiene datos de la request http
    }

}
