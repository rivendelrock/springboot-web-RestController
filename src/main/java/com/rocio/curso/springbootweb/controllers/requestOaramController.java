package com.rocio.curso.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


import com.rocio.curso.springbootweb.models.DTO.ParamDto;

@RestController
@RequestMapping("api/params/") 
public class requestOaramController {
    
 @GetMapping("foo") //Este método nos va a devolver un json de la clase paramDto
 public ParamDto foo (@RequestParam(required = false, defaultValue = "Hola qué tal") String message) {
    ParamDto param = new ParamDto(); 
    //Para que tenga un valor por defecto podemos usar el defaultValue o una funcion como abajo
    //param.setMessage(message!=null?message:"Hola");
    param.setMessage(message);
     return param;
 }
 
}
