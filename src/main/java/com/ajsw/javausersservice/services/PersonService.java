package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Person;
import com.ajsw.javausersservice.repositories.interfaces.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final IPersonRepository personRepository;
    private final String nameEntity = "Person";

    @Autowired
    public PersonService(IPersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Response savePerson(Person person){
        Person personCreated = personRepository.save(person);
        EntityCreatedResponse response = new EntityCreatedResponse(personCreated.getIdPerson(), nameEntity);
        return response;
    }

    public Person getPersonById(Long id){
        return personRepository.findById(id).get();
    }
}
