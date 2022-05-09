package com.ajsw.javausersservice.services;

import com.ajsw.javausersservice.models.dto.request.ClientRequest;
import com.ajsw.javausersservice.models.dto.response.ClientResponseDto;
import com.ajsw.javausersservice.models.dto.response.EntityCreatedResponse;
import com.ajsw.javausersservice.models.dto.response.Response;
import com.ajsw.javausersservice.models.entities.Client;
import com.ajsw.javausersservice.models.mappers.ListMapper;
import com.ajsw.javausersservice.repositories.interfaces.IClientRepository;
import com.ajsw.javausersservice.utils.ClientUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final IClientRepository clientRepository;
    private final ClientUtil clientUtil;
    private final ListMapper listMapper;
    private final ModelMapper modelMapper;
    private final String nameEntity = "Client";

    @Autowired
    public ClientService(IClientRepository clientRepository, ClientUtil clientUtil, ListMapper listMapper, ModelMapper modelMapper){
        this.clientRepository = clientRepository;
        this.clientUtil = clientUtil;
        this.listMapper = listMapper;
        this.modelMapper = modelMapper;
    }

    public Response saveClient(ClientRequest clientRequest){
        Client client = clientUtil.createClient(clientRequest);
        Client clientCreated = clientRepository.save(client);
        return new EntityCreatedResponse(clientCreated.getIdPerson(), nameEntity);
    }

    public List<ClientResponseDto> getClients(){
        List<Client> clients = clientRepository.findAll();
        return listMapper.mapList(clients, ClientResponseDto.class);
    }

    public ClientResponseDto getClient(int id, String email){
        if(id != 0){
            return getClientById(id);
        }
        if(email != null){
            return getClientByEmail(email);
        }
        return null;
    }

    public ClientResponseDto getClientById(int id){
        return modelMapper.map(clientRepository.findById(id).get(), ClientResponseDto.class);
    }

    public ClientResponseDto getClientByEmail(String email){
        return modelMapper.map(clientRepository.findByAccount_Email(email), ClientResponseDto.class);
    }
}
