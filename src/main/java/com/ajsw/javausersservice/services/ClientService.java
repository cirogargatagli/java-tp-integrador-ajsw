package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entity.Client;
import com.ajsw.javausersservice.repositories.interfaces.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final IClientRepository clientRepository;

    @Autowired
    public ClientService(IClientRepository iClientRepository){
        clientRepository = iClientRepository;
    }

    public Response saveClient(Client client){
        Client clientCreated = clientRepository.save(client);
        EntityCreatedResponse response = new EntityCreatedResponse(clientCreated.getIdPerson(), 200, "Client created successfully");
        return response;
    }

    public Client getClientById(Long id){
        return clientRepository.findById(id).get();
    }
}
