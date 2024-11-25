package com.rocio.curso.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.rocio.curso.springbootweb.models.DTO.ParamDto;
import com.rocio.curso.springbootweb.models.DTO.ParamMixDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/params/")
public class requestOaramController {

    @GetMapping("/foo") // Este método nos va a devolver un json de la clase paramDto
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola qué tal") String message) {
        ParamDto param = new ParamDto();
        // Para que tenga un valor por defecto podemos usar el defaultValue o una
        // funcion como abajo
        // param.setMessage(message!=null?message:"Hola");
        param.setMessage(message);
        return param;
    }

    // http://localhost:8080/api/params/bar?text=Hola%20que%20tal&code=75
    @GetMapping("/bar") // Los parametros tienen que ser de un tipo simple Integer, Float...etc.
    public ParamMixDTO bar(@RequestParam String text, @RequestParam Integer code) {
        ParamMixDTO params = new ParamMixDTO();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @GetMapping("/request")
    public ParamMixDTO requested(HttpServletRequest request) {
        ParamMixDTO params = new ParamMixDTO();
        try{
        params.setCode(Integer.parseInt(request.getParameter("code")));
        } catch (NumberFormatException e){
            params.setCode(0); //le meto un 0 si no viene nada
        }
        params.setMessage(request.getParameter("message"));
        return params;
    }

}
