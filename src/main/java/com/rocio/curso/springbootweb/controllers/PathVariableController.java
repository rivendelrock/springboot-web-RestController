package com.rocio.curso.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocio.curso.springbootweb.models.User;
import com.rocio.curso.springbootweb.models.DTO.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/var")
public class PathVariableController {
   
    @Value("${config.username}")
    private String username;
    
    @Value("${config.message}")
    private String message;
    //lo podemos poner como un array String[] o como una lista 
    @Value("${config.listOfValues}")
    private List<String> listOfValues;
    
    @Value("${config.code}")
    private int code;

    @Value ("#{ ${config.valuesMap}}")
    private Map <String, Object> valuesMap;

    @Value ("#{ ${config.valuesMap}.product }")
    private String product;

    @Value ("#{ ${config.valuesMap}.price }")
    private Long price;

//Nos separa los valores con codigo SpEL haciendo un corte en cada coma
    @Value("#{ '${config.listaValores}'.split(',')}")
    private List<String> listaValores;

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

    @PostMapping("/create")
    public User postMethodCreate (@RequestBody User user) {
         
        //Hacer algo con el usuario, por ejemplo un save en la base de datos, pasar a mayúsculas...
        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map <String, Object> valoresInjectados (@Value("${config.telefono}") int telefono){
    
        Map <String, Object> json = new HashMap<>();
        json.put( "username", username);
        json.put ("código", code);
        json.put ("mensaje", message);
        json.put ("lista de valores", listOfValues);
        json.put ("telefono", telefono);
        json.put ("listaValores", listaValores);
        json.put ("valuesMap", valuesMap);
        json.put ("Product", product);
        json.put ("Price", price);
        return json;
    
    }
}
