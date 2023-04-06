package com.example.insurancemanagement.model.repositories.claim;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.example.insurancemanagement.model.classes.Claim;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Configuration
public class ClaimRepImp implements ClaimCustomRep {
    /*
     * 
     * 
     * findAllClaims()
findClaimById(Long id)
createClaim(Claim claim)
updateClaim(Long id, Claim claim)
deleteClaim(Long id)
     */
@Autowired
EntityManager entityManager;

@Bean 
public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean(); 

    return sessionFactory;
}






private Object claimNumber;
private Object description;
private Object claimDate;
private Object claimstatus;
    

    @Override
    public List<Claim> findAllClaims() {
    
        String sql = "select cl from claim cl";
        final TypedQuery<Claim> query = ((EntityManager) entityManager).createQuery(sql, Claim.class);
    
        return query.getResultList();


    }

    @Override
    public List<Claim> findClaimById(Long claimId) {
        
        String sql = "select cl from claim cl where cl.id : id";
        final TypedQuery<Claim> query = ((EntityManager) entityManager).createQuery(sql, Claim.class);
        query.setParameter("id", claimId);
        return query.getResultList();
    }

   


    @Override
    public Claim createClaim(Claim claim) {
    
        throw new UnsupportedOperationException("Unimplemented method 'createClaim'");
    }

    @Override
    public Claim updateClaim(Long claimId, Claim claimDetails) {
        
        String sql = "UPDATE Claim cl SET cl.Name = :Name, cl.dateOfBirth = :dateOfBirth, cl.address = :address, cl.contactInformation = :contactInformation WHERE cl.id = :claimId";
        final TypedQuery<Claim> query = ((EntityManager) entityManager).createQuery(sql, Claim.class);
        query.setParameter("claimNumber", claimNumber);
        query.setParameter("description", description);
        query.setParameter("claimDate", claimDate);
        query.setParameter("claimStatus", claimstatus);
        query.setParameter("claimId", claimId);
        query.executeUpdate();
        return (Claim) query.getResultList();

        /*
         * 
         * 
         * claimNumber;
        String description;
        LocalDate claimDate;
        String claimStatus;
    
         */


    }

    @Override
    public ResponseEntity<?> deleteClaim(Long claimId) {
    

        String sql = "DELETE FROM Claim cl WHERE cl.id = :claimId";
        final TypedQuery<Claim> query = ((EntityManager) entityManager).createQuery(sql, Claim.class);
        query.setParameter("claimId", claimId);
        query.executeUpdate();
        return (ResponseEntity<?>) query.getResultList();
    }
    
}
