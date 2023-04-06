package com.example.insurancemanagement.model.repositories.client;


import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import com.example.insurancemanagement.model.classes.Client;

//@Repository
public interface ClientRep extends CrudRepository<Client,Integer> ,ClientCustomRep{

    
    
}
