package com.ajsw.javausersservice.utils;

import com.ajsw.javausersservice.models.dto.request.PersonRequest;
import com.ajsw.javausersservice.models.entities.Account;
import com.ajsw.javausersservice.models.entities.Address;
import com.ajsw.javausersservice.models.entities.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonUtil {
    public Person createPerson(PersonRequest request){
        return new Person(
                request.getFirstName(),
                request.getLastName(),
                request.getPhone(),
                new Address(request.idAddress),
                new Account(request.idAccount)
        );
    }
}
