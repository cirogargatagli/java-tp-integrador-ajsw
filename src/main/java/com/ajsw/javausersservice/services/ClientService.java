package com.ajsw.javausersservice.services;

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

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public Client getClientById(Long id){
        return clientRepository.findById(id).get();
    }
}
