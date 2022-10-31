package com.portfolio.ES_Jimenez.Controller;

import com.portfolio.ES_Jimenez.Entity.Person;
import com.portfolio.ES_Jimenez.Interface.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    @Autowired
    IPersonService ipersonService;

    @GetMapping("persons/traer")
    public List<Person> getPerson() {
        return ipersonService.getPerson();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persons/crear")
    public String createPerson(@RequestBody Person person) {
        ipersonService.savePerson(person);
        return "Persona guardada";

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persons/borrar/{id}")
    public String deletePerson(@PathVariable Long id) {
        ipersonService.deletePerson(id);
        return "La persona fue eliminada";
    }

    //Por ejemplo: PUERTO/persons/editar/"aca va la id"/nombre & apellido & img
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persons/editar/{id}")
    public Person editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg) {
        Person person = ipersonService.findPerson(id);

        person.setNombre(nuevoNombre);
        person.setApellido(nuevoApellido);
        person.setImg(nuevoImg);

        ipersonService.savePerson(person);
        return person;

    }
    
    @GetMapping("/persons/traer/perfil")
    public Person findPerson(){
    return ipersonService.findPerson((long)3);
    }
    
    
    
    
    
}
