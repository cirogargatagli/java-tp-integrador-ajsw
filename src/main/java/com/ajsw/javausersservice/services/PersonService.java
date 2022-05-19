package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.dto.request.PersonRequest;
import com.ajsw.javausersservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javausersservice.models.dto.response.PersonResponseDto;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Person;
import com.ajsw.javausersservice.models.mappers.ListMapper;
import com.ajsw.javausersservice.repositories.interfaces.IPersonRepository;
import com.ajsw.javausersservice.utils.PersonUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final IPersonRepository personRepository;
    private final ListMapper listMapper;
    private final ModelMapper modelMapper;
    private final PersonUtil personUtil;
    private final String nameEntity = "Person";

    @Autowired
    public PersonService(IPersonRepository personRepository, ListMapper listMapper, ModelMapper modelMapper, PersonUtil personUtil){
        this.personRepository = personRepository;
        this.listMapper = listMapper;
        this.modelMapper = modelMapper;
        this.personUtil = personUtil;
    }

    public Response savePerson(PersonRequest personRequest){
        Person person = personUtil.createPerson(personRequest);
        Person personCreated = personRepository.save(person);
        return new EntityCreatedResponse(personCreated.getIdPerson(), nameEntity);
    }

    public PersonResponseDto getPersonById(int id){
        return modelMapper.map(personRepository.findById(id), PersonResponseDto.class);
    }

    public List<PersonResponseDto> getPersons(){
        List<Person> persons = personRepository.findAll();
        return listMapper.mapList(persons, PersonResponseDto.class);
    }

    public PersonResponseDto getClientByEmail(String email){
        return modelMapper.map(personRepository.getPersonByAccount_Email(email), PersonResponseDto.class);
    }

    public PersonResponseDto getPerson(int id, String email){
        if(id != 0){
            return getPersonById(id);
        }
        if(email != null){
            return getClientByEmail(email);
        }
        return null;
    }
}
