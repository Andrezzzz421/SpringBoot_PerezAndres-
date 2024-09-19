package com.example.JPA.controller;

import com.example.JPA.model.Person;
import com.example.JPA.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    
    @Autowired
    private PersonService personService;
    
    
    //Obtener todas las personas
    // localhost:8080/api/person con verbo GET
    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }
    
    //Obtener a una persona por ID
    // localhost:8080/api/person con verbo GET
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id){
        return personService.getPersonById(id).orElseThrow();
    }
    
    //Crear una persona
    // localhost:8080/api/person con verbo POST
    //{
    // "name":"Andres",
    // "age":25
    //}
    @PostMapping
    public Person createPerson(@RequestBody Person person){
        return personService.savePerson(person);
    }
    
    //Actualizar una persona
      // localhost:8080/api/1 con verbo PUT
    //{
    // "name":"Patrana",
    // "age":28
    //}
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id,@RequestBody Person person){
        return personService.updatePerson(id, person);
        
    }
    
    //Borra por ID
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }
}
