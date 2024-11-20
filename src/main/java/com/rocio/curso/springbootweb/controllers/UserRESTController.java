package com.rocio.curso.springbootweb.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rocio.curso.springbootweb.models.*;
import com.rocio.curso.springbootweb.models.DTO.UserDto;




/** En el controlador rest, es parecido a otros controladores pero lo que devuelve no es una vista o una plantilla html como tal
 * Sería un JSON
 */

@RestController
@RequestMapping("/api") // Le ponemos una ruta de primer nivel arriba con lo cual accederíamos poniendo
                        // /api/details
public class UserRESTController {

    @GetMapping("/details") 
    
       public UserDto details (){  //con model podemos pasar parámetros a la vista
        UserDto userDto= new UserDto();
        User user= new User ("Andres", "Guzman");
        userDto.setUser(user);
        userDto.setTittle("Hola Mundo SpringBoot DTO");
      
        return userDto;
      }
    // El get vale para traer info xdd Podemos poner tb un @RequestMapping porque
    // requestMapping es get por defecto,
    // funcionaria igual. Si queremos un método post o de otro tipo tendríamos que
    // poner
    // @RequestMapping(path= "/details", method = RequestMethod.POST)
@GetMapping("/list")
   public List <User> list () {

      User user= new User ("Rocío", "Marcos", "email@email.com");
      User user2= new User ("Andres", "Guzman");
      User user3= new User ("Paty", "Hijas");

      List <User> users = new ArrayList<>();

      users.add(user);
      users.add(user2);
      users.add(user3);
      //Lista con Arrays.asList
      //List <User> users2 = Arrays.asList(
       //  new User ("Rocío", "Marcos"),
       //  new User ("Pedro", "Gonzalez"),
       //  new User ("Juanita", "Perez"));

      return users;
    }
    @GetMapping("/details-map") 
    public Map<String,Object> detailsmap (){  //con model podemos pasar parámetros a la vista
       User user= new User ("Andres", "Guzman");

       Map <String, Object> body = new HashMap<>();
       body.put("tittle", "Paty es guapo"); 
       body.put("user", user);
             
      

       return body;

    }

}
