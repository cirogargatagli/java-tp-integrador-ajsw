package com.ajsw.javausersservice.utils;

import com.ajsw.javausersservice.models.dto.request.PersonRequest;
import com.ajsw.javausersservice.models.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonUtil {
    protected final ModelMapper modelMapper;

    public PersonUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Person createPerson(PersonRequest request){
        Address address = modelMapper.map(request.addressRequest, Address.class);
        address.setLocality(new Locality(request.addressRequest.getIdLocality()));
        address.setIdAddress(0);

        Account account = modelMapper.map(request.accountRequest, Account.class);
        account.setIdAccount(0);
        account.setRole(new Role(request.accountRequest.getId_role()));

        return new Person(
                request.getFirstName(),
                request.getLastName(),
                request.getPhone(),
                address,
                account
        );
    }
}
