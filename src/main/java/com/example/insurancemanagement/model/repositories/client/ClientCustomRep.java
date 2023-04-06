package com.example.insurancemanagement.model.repositories.client;

import java.util.List;
//import java.util.Optional;

//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.insurancemanagement.model.classes.Client;
import com.example.insurancemanagement.model.repositories.RequestBody;

@Repository
public interface ClientCustomRep {
    public List<Client> createClient(@RequestBody Client client);
    public List<Client>getAllClients();
    public List<Client> getClientbyid(@PathVariable(value = "id") Integer clientId);
    public List<Client> updateClient(@PathVariable(value = "id") Integer clientId, @RequestBody Client clientDetails) ;
    public List<Client> deleteClient(@PathVariable(value = "id") Integer clientId) ;


    


}
