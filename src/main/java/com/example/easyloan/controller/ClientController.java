package com.example.easyloan.controller;

import com.example.easyloan.dto.ClientDto;
import com.example.easyloan.entity.ClientEntity;
import com.example.easyloan.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping("/get/details")
    public ResponseEntity<?> getClientDetails(){
        List<ClientDto> clientData = clientService.getClientData();
        if(clientData.size() == 0){
            return new ResponseEntity<>("There is no data present inside client database", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("The data present in client database is : "+clientData, HttpStatus.FOUND);
    }
    @PostMapping("/add/details")
    public ResponseEntity<?> addClientDetails(@RequestBody ClientDto clientDto){
        ClientEntity addedClientData = clientService.addClientData(clientDto);
        if(addedClientData == null){
            return new ResponseEntity<>("The provided id in the detail is already present inside the client database, so not added", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("The added data of client entity is : "+addedClientData, HttpStatus.ACCEPTED);
    }
}
