package com.example.insurancemanagement.model.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.insurancemanagement.model.classes.Client;
import com.example.insurancemanagement.model.repositories.client.ClientRep;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class ClientController {
    @Autowired
    private ClientRep clientRep;

    @postMapping("/clients")
    public Client createClient(@RequestBody Client client)
    {
        return clientRep.save(client);
    }

    @GetMapping("/clients")
    public List<Client>getAllClients()
    {
        return (List<Client>) clientRep.findAll();
    }
    
    @GetMappping("/clients/{id}")
    public Optional<Client> getClientbyid(@PathVariable(value = "id") Integer clientId)
    {
        return clientRep.findById(clientId);
               
    }

    @PutMapping("/api/clients/{id}")
    public Client updateClient(@PathVariable(value = "id") Integer clientId, @RequestBody Client clientDetails) {
        Client client = clientRep.findById(clientId)
                .orElseThrow();
    
        client.setName(clientDetails.getName());
        client.setDateOfBirth(clientDetails.getDateOfBirth());
        client.setAddress(clientDetails.getAddress());
        client.setContactInformation(clientDetails.getContactInformation());
    
        return clientRep.save(client);
    }
    
    @DeleteMapping("clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(value = "id") Integer clientId) {
        Client client = clientRep.findById(clientId)
                .orElseThrow();
    
        clientRep.delete(client);
    
        return ResponseEntity.ok().build();
    }
    
    

}
