package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.dto.request.PersonRequest;
import com.ajsw.javausersservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javausersservice.models.dto.response.PersonResponseDto;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Locality;
import com.ajsw.javausersservice.models.entities.Person;
import com.ajsw.javausersservice.models.entities.Role;
import com.ajsw.javausersservice.models.mappers.ListMapper;
import com.ajsw.javausersservice.repositories.interfaces.IPersonRepository;
import com.ajsw.javausersservice.utils.PersonUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PersonService {
    private final IPersonRepository personRepository;
    private final ListMapper listMapper;
    private final ModelMapper modelMapper;
    private final PersonUtil personUtil;
    private final String nameEntity = "Person";
    private final ClientService clientService;
    private final InstructorService instructorService;

    @Autowired
    public PersonService(IPersonRepository personRepository, ListMapper listMapper, ModelMapper modelMapper, PersonUtil personUtil, ClientService clientService, InstructorService instructorService){
        this.personRepository = personRepository;
        this.listMapper = listMapper;
        this.modelMapper = modelMapper;
        this.personUtil = personUtil;
        this.clientService = clientService;
        this.instructorService = instructorService;
    }

    public Response savePerson(PersonRequest personRequest){
        Person person = personUtil.createPerson(personRequest);
        Person personCreated = personRepository.save(person);
        return new EntityCreatedResponse(personCreated.getIdPerson(), nameEntity);
    }

    public Response delete(int id){
        personRepository.deleteById(id);
        return new Response(200, "Delete successfully");
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

    public Response updatePerson(PersonRequest personRequest){
        Person person = personRepository.getPersonByAccount_Email(personRequest.accountRequest.getEmail());
        if(!Objects.equals(person.getFirstName(), personRequest.getFirstName())) person.setFirstName(personRequest.getFirstName());
        if(!Objects.equals(person.getLastName(), personRequest.getLastName())) person.setLastName(personRequest.getLastName());
        if(!Objects.equals(person.getPhone(), personRequest.getPhone())) person.setPhone(personRequest.getPhone());
        if(!Objects.equals(person.getAddress().getNumberHouse(), personRequest.getAddressRequest().getNumberHouse()))
            person.getAddress().setNumberHouse(personRequest.addressRequest.getNumberHouse());
        if(!Objects.equals(person.getAddress().getStreet(), personRequest.addressRequest.getStreet()))
            person.getAddress().setStreet(personRequest.addressRequest.getStreet());
        if(!Objects.equals(person.getAddress().getLocality().getIdLocality(), personRequest.addressRequest.getIdLocality()))
            person.getAddress().setLocality(new Locality(personRequest.addressRequest.getIdLocality()));
        if(!Objects.equals(person.getAccount().getEmail(), personRequest.accountRequest.getEmail()))
            person.getAccount().setEmail(personRequest.accountRequest.getEmail());
        if(!Objects.equals(person.getAccount().getRole().getIdRole(), personRequest.accountRequest.getId_role()))
            person.getAccount().setRole(new Role(personRequest.accountRequest.getId_role()));
        return new EntityCreatedResponse(personRepository.save(person).getIdPerson(), nameEntity);
    }
}