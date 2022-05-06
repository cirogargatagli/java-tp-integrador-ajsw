package com.ajsw.javausersservice.controllers;

import com.ajsw.javausersservice.models.dto.request.ClientRequest;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Client;
import com.ajsw.javausersservice.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService _clientService){
        clientService = _clientService;
    }

    @PostMapping()
    public Response createClient(@Validated @RequestBody ClientRequest clientRequest){
        try{
            return clientService.saveClient(clientRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error registering the client .\n");
        }
    }

    @GetMapping()
    public List<Client> getClients(){
        return clientService.getClients();
    }
}