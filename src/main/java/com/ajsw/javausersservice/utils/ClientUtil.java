package com.ajsw.javausersservice.utils;

import com.ajsw.javausersservice.models.dto.request.ClientRequest;
import com.ajsw.javausersservice.models.entities.Account;
import com.ajsw.javausersservice.models.entities.Address;
import com.ajsw.javausersservice.models.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientUtil extends PersonUtil{
    public Client createClient(ClientRequest clientRequest){
        return new Client(
                clientRequest.getFirstName(),
                clientRequest.getLastName(),
                clientRequest.getPhone(),
                new Account(clientRequest.idAccount),
                new Address(clientRequest.idAddress)
        );
    }
}
