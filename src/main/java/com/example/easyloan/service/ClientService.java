package com.example.easyloan.service;

import com.example.easyloan.dto.ClientDto;
import com.example.easyloan.entity.ClientEntity;

import java.util.List;

public interface ClientService {
    public List<ClientDto> getClientData();
    public ClientEntity addClientData(ClientDto clientDto);
}
