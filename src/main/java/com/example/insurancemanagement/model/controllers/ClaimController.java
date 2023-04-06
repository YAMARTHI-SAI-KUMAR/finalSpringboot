package com.example.insurancemanagement.model.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.insurancemanagement.model.classes.Claim;
import com.example.insurancemanagement.model.repositories.claim.ClaimRep;

public class ClaimController {
    @Autowired
    private ClaimRep claimRep;
    public Claim createClient(@RequestBody Claim claim)
    {
        return claimRep.save(claim);
    }

    @GetMapping("/claims")
    public List<Claim>getAllClaims()
    {
        return (List<Claim>) claimRep.findAll();
    }
    
    @GetMappping("/claims/{id}")
    public Optional<Claim> getClaimId(@PathVariable(value = "claimNumber") Long claimId)
    {
        return claimRep.findById(claimId);
               
    }

    @PutMapping("/api/clients/{claimId}")
    public Claim updateClient(@PathVariable(value = "claimNumber") Long claimId, @RequestBody Claim claimDetails) {
        Claim claim = claimRep.findById(claimId)
                .orElseThrow();
    
        claim.setClaimNumber(claimDetails.getClaimNumber());
        claim.setDescription(claimDetails.getDescription());
        claim.setClaimDate(claimDetails.getClaimDate());
        claim.setClaimStatus(claimDetails.getClaimStatus());
    
        return claimRep.save(claim);
    }
    
    @DeleteMapping("clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(value = "claimNumber") Long claimId) {
        Claim claim = claimRep.findById(claimId)
                .orElseThrow();
    
        claimRep.delete(claim);
    
        return ResponseEntity.ok().build();
    }

    
}
