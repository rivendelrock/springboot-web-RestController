package com.rocio.curso.springbootweb.controllers;




import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.rocio.curso.springbootweb.models.*;



//**En este caso al ser controlador interactua con los datos que le mandemos y se los envía a la vista */

@Controller
public class UserController {

    @GetMapping("/details") //El get vale para traer info xdd
    public String details (Model model){  //con model podemos pasar parámetros a la vista
      User user= new User ("Andres", "Guzman");
      user.setEmail("antonio@meaburro.com"); 
      model.addAttribute("tittle", "Paty es guapo"); //cambiamos el título del html details
       model.addAttribute("user",  user);

  
      
       
       return "details";

    }

   /*  public String details (Map <String, Object> model){  //Tambien podemos pasar un map
       
        model.put("tittle", "Paty es guapo"); //cambiamos el título del html details
        model.put("name",  "Rocio");
        model.put("lastName",  "es más guapa todavía");
       
        
        return "details";
 
     }
 */
@GetMapping("/list")
public String list (ModelMap model) {

  /* List <User> users = new ArrayList<>();
  model.addAttribute ("users", users);
  model.addAttribute ("tittle", "Listado de usuarios");
    return "list";     */

    List <User> users = Arrays.asList(new User ("Pepa" , "Gonzalez"),
    new User("Andres", "Gomez"),
    new User ("Maria", "Romero", "maria@correo.com"),
    new User ("Laura", "Martinez", "rivendel@hotmail.com"));

    model.addAttribute ("users", users);
    model.addAttribute ("tittle", "Listado de usuarios!");
    return "list";
  }


}
