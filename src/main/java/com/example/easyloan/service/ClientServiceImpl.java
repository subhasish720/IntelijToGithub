package com.example.easyloan.service;

import com.example.easyloan.dto.ClientDto;
import com.example.easyloan.entity.ClientEntity;
import com.example.easyloan.repository.ConnectedWithJpa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl {
    @Autowired
    ConnectedWithJpa connectedWithJpa;
    @Autowired
    ModelMapper modelMapper;
    public List<ClientDto> getClientData(){
        List<ClientEntity> clientDetails = connectedWithJpa.findAll();
        List<ClientDto> clientDto1 = new LinkedList<>();
        ClientDto clientDto2;
        if(clientDetails.size() != 0){
            for(ClientEntity clientEntity : clientDetails) {
                clientDto2 = modelMapper.map(clientEntity, ClientDto.class);
                clientDto1.add(clientDto2);
            }
            return clientDto1;
        }
        return clientDto1;
    }
    public ClientEntity addClientData(ClientDto clientDto){
        Optional<ClientEntity> clientEntity = connectedWithJpa.findById(clientDto.client_id);
        ClientEntity clientEntity1;
        if(clientEntity.isEmpty()){
            clientEntity1 = modelMapper.map(clientDto, ClientEntity.class);
            return connectedWithJpa.save(clientEntity1);
        }
        return null;
    }

}
