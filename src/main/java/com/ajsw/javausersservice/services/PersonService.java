package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javausersservice.models.entities.Person;
import com.ajsw.javausersservice.repositories.interfaces.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final IPersonRepository personRepository;

    @Autowired
    public PersonService(IPersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public EntityCreatedResponse savePerson(Person person){
        Person personCreated = personRepository.save(person);
        EntityCreatedResponse response = new EntityCreatedResponse(personCreated.getIdPerson(), 200, "Person created successfully");
        return response;
    }

    public Person getPersonById(Long id){
        return personRepository.findById(id).get();
    }
}
