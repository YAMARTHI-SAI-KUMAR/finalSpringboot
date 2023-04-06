package com.example.insurancemanagement.model.repositories.claim;

import java.util.List;
//import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.insurancemanagement.model.classes.Claim;
import com.example.insurancemanagement.model.controllers.RequestBody;

public interface ClaimCustomRep {
    public Claim createClaim(@RequestBody Claim claim);
    public List<Claim>findAllClaims();
    public List<Claim> findClaimById(@PathVariable(value = "claimId") Long claimId);
    public Claim updateClaim(@PathVariable(value = "claimId") Long claimId, @RequestBody Claim claimDetails) ;
    public ResponseEntity<?> deleteClaim(@PathVariable(value = "claimId") Long claimId) ;

/*
 * findAllClaims()
findClaimById(Long id)
createClaim(Claim claim)
updateClaim(Long id, Claim claim)
deleteClaim(Long id)
 * 
 * 
 */


}
