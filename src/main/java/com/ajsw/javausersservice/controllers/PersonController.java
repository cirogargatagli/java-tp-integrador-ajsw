package com.ajsw.javausersservice.controllers;

import com.ajsw.javausersservice.models.dto.request.PersonRequest;
import com.ajsw.javausersservice.models.dto.response.PersonResponseDto;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Person;
import com.ajsw.javausersservice.services.PersonService;
import com.ajsw.javausersservice.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping()
    public Response createPerson(@Validated @RequestBody PersonRequest personRequest){
        try{
            return personService.savePerson(personRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error registering the client .\n");
        }
    }

    @RequestMapping(value = "/",  method = RequestMethod.GET)
    public List<PersonResponseDto> getPersons(){
        return personService.getPersons();
    }

    @RequestMapping(method = RequestMethod.GET)
    public PersonResponseDto getPerson(@RequestParam(required = false, defaultValue = "0") int id, @RequestParam(required = false) String email) {
        return personService.getPerson(id, email);
    }

    @PutMapping()
    public Response updatePerson(@Validated @RequestBody PersonRequest personRequest){
        try{
            return personService.updatePerson(personRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error registering the client .\n");
        }
    }
}