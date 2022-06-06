package com.ajsw.javausersservice.utils;

import com.ajsw.javausersservice.models.dto.request.ClientRequest;
import com.ajsw.javausersservice.models.entities.Account;
import com.ajsw.javausersservice.models.entities.Address;
import com.ajsw.javausersservice.models.entities.Client;
import com.ajsw.javausersservice.models.entities.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClientUtil extends PersonUtil{

    public ClientUtil(ModelMapper modelMapper) {
        super(modelMapper);
    }

    public Client createClient(ClientRequest clientRequest){
        return modelMapper.map(createPerson(clientRequest), Client.class);
    }
}
