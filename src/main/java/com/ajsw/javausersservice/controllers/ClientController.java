package com.ajsw.javausersservice.controllers;

import com.ajsw.javausersservice.models.dto.request.ClientRequest;
import com.ajsw.javausersservice.models.dto.response.ClientResponseDto;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.enums.RoleEnum;
import com.ajsw.javausersservice.services.ClientService;
import com.ajsw.javausersservice.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;
    private final JwtService jwtService;

    @Autowired
    public ClientController(ClientService _clientService, JwtService _jwtService){
        clientService = _clientService;
        jwtService = _jwtService;
    }

    @PostMapping()
    public Response createClient(@Validated @RequestBody ClientRequest clientRequest){
        try{
            return clientService.saveClient(clientRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error registering the client .\n");
        }
    }

    @RequestMapping(value = "/",  method = RequestMethod.GET)
    public List<ClientResponseDto> getClients(@RequestHeader(value = "Authorization") String authToken){
        try {
            jwtService.validateToken(authToken, RoleEnum.Admin.name());
            return clientService.getClients();
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error getting client .\n");
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ClientResponseDto getClient(@RequestParam(required = false, defaultValue = "0") int id, @RequestParam(required = false) String email) {
        return clientService.getClient(id, email);
    }
}