package com.portfolio.ES_Jimenez.Controller;

import com.portfolio.ES_Jimenez.Entity.Person;
import com.portfolio.ES_Jimenez.Interface.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    IPersonService ipersonService;

    @GetMapping("persons/traer")
    public List<Person> getPerson() {
        return ipersonService.getPerson();
    }

    @PostMapping("/persons/crear")
    public String createPerson(@RequestBody Person person) {
        ipersonService.savePerson(person);
        return "Persona guardada";

    }

    @DeleteMapping("/persons/borrar/{id}")
    public String deletePerson(@PathVariable Long id) {
        ipersonService.deletePerson(id);
        return "La persona fue eliminada";
    }

    //Por ejemplo: PUERTO/persons/editar/"aca va la id"/nombre & apellido & img
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
}
