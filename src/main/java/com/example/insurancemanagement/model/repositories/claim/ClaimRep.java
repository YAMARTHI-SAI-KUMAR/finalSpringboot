package com.example.insurancemanagement.model.repositories.claim;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.insurancemanagement.model.classes.Claim;


public interface ClaimRep extends CrudRepository<Claim,Integer>,ClaimCustomRep{

    Optional<Claim> findByClaimNumber(Long claimNumber);

    Optional<Claim> findById(Long claimId);

    
    
}
