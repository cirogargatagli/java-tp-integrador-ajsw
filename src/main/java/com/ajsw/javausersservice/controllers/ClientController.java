package com.ajsw.javausersservice.controllers;
import com.ajsw.javausersservice.mapper.InstructorMapper;
import com.ajsw.javausersservice.models.dto.request.ClientRequest;
import com.ajsw.javausersservice.models.dto.request.InstructorRequest;
import com.ajsw.javausersservice.models.dto.response.InstructorResponse;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entity.Client;
import com.ajsw.javausersservice.services.ClientService;
import com.ajsw.javausersservice.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
            Client client = new Client(clientRequest.getFirstName(), clientRequest.getLastName(), clientRequest.getPhone(), clientRequest.getIdAddress());
            return clientService.saveClient(client);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error registering the client .\n");
        }
    }
}