package com.rocio.curso.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocio.curso.springbootweb.models.DTO.ParamDto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @GetMapping("/pathV/{message}") //se enviará variable como dentro del path. Ej http://localhost:8080/api/var/pathV/mesa
    public ParamDto getMethodName(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
    
    @GetMapping("/mix/{product}/{id}")
    public Map <String, Object> mixPathVar (@PathVariable String product, @PathVariable Long id){
        
        Map <String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;

    }
}
