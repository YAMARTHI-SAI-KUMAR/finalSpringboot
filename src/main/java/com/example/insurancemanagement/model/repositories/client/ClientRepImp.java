package com.example.insurancemanagement.model.repositories.client;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.example.insurancemanagement.model.classes.Client;
import com.example.insurancemanagement.model.controllers.RequestBody;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Configuration
public class ClientRepImp implements ClientCustomRep {
   @Autowired
   EntityManager entityManager;


   @Bean 
public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean(); 

    return sessionFactory;
}

private Object contactinformation;
private Object address;
private Object dateOfBirth;
private Object Name;


 
    @Override
    public List<Client> createClient(Client client) {
    
       String sql="INSERT INTO client (name, date_of_birth, address, contact_information)";
       final TypedQuery<Client> query= ((EntityManager) entityManager).createQuery(sql,Client.class);
       return query.getResultList();
        
    }



    @Override
    public List<Client> getAllClients() {
    
        String sql = "select c from client c";
        final TypedQuery<Client> query = ((EntityManager) entityManager).createQuery(sql, Client.class);
    
        return query.getResultList();
    }

    @Override
    public List<Client> getClientbyid(Integer clientId) {

        String sql = "select c from client c where c.id : id";
        final TypedQuery<Client> query = ((EntityManager) entityManager).createQuery(sql, Client.class);
        query.setParameter("id", clientId);
        return query.getResultList();
    }

   

    @Override
    public List<Client> deleteClient(Integer clientId) {
        String sql = "DELETE FROM Client c WHERE c.id = :clientId";
        final TypedQuery<Client> query = ((EntityManager) entityManager).createQuery(sql, Client.class);
        query.setParameter("clientId", clientId);
        query.executeUpdate();
        return query.getResultList();
       
    }

    @Override
    public List<Client> updateClient(@PathVariable(value = "id") Integer clientId, @RequestBody Client clientDetails) 
    {

        String sql = "UPDATE Client c SET c.Name = :Name, c.dateOfBirth = :dateOfBirth, c.address = :address, c.contactInformation = :contactInformation WHERE c.id = :clientId";
        final TypedQuery<Client> query = ((EntityManager) entityManager).createQuery(sql, Client.class);
        query.setParameter("Name", Name);
        query.setParameter("dateOfBirth", dateOfBirth);
        query.setParameter("address", address);
        query.setParameter("contactInformation", contactinformation);
        query.setParameter("clientId", clientId);
        query.executeUpdate();
        return query.getResultList();
    }
    
}
