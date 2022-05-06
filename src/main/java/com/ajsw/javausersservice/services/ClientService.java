package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.dto.request.ClientRequest;
import com.ajsw.javausersservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Account;
import com.ajsw.javausersservice.models.entities.Address;
import com.ajsw.javausersservice.models.entities.Client;
import com.ajsw.javausersservice.repositories.interfaces.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final IClientRepository clientRepository;
    private final PersonService personService;
    private final AccountService accountService;

    @Autowired
    public ClientService(IClientRepository clientRepository, PersonService personService, AccountService accountService){
        this.clientRepository = clientRepository;
        this.personService = personService;
        this.accountService = accountService;
    }

    public Response saveClient(ClientRequest clientRequest){
        Account accountRequest = accountService.getAccountById(clientRequest.getIdAccount());

        Client client = new Client(
                clientRequest.getFirstName(),
                clientRequest.getLastName(),
                clientRequest.getPhone(),
                accountRequest,
                clientRequest.getAddress()
        );
        Client clientCreated = clientRepository.save(client);
        return new EntityCreatedResponse(clientCreated.getIdPerson(), 200, "Client created successfully");
    }

    public Client getClientById(Long id){
        return clientRepository.findById(id).get();
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }
}
