package com.example.insurancemanagement.model.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.insurancemanagement.model.classes.InsurancePolicy;
import com.example.insurancemanagement.model.repositories.insurance.InsurancePolicyRep;

public class InsurancePolicyController {
    @Autowired

    private InsurancePolicyRep insurancePolicyRep;
    
    @PostMapping("/insurancePolicy")
    public InsurancePolicy createPolicy(@RequestBody InsurancePolicy insurancePolicy)
    {
        return  insurancePolicyRep.save(insurancePolicy);
    }

    @GetMapping("/insurancePolicy")
    public List<InsurancePolicy> findAllPolicies()
    {
        return (List<InsurancePolicy>) insurancePolicyRep.findAll();
    }

    @GetMapping("/insurancePolicy/{id}")
    public Optional<InsurancePolicy> findPolicyById(@PathVariable(value = "id") Long insuranceId)
    {
        return insurancePolicyRep.findById(insuranceId);
               
    }

    @PutMapping("/api/clients/{id}")
    public InsurancePolicy updatePolicy(@PathVariable(value = "id") Long insuranceId, @RequestBody InsurancePolicy insuranceDetails) {
        InsurancePolicy insurance = insurancePolicyRep.findById(insuranceId)
                .orElseThrow();
    
        insurance.setPolicyNumber(insuranceDetails.getPolicyNumber());
        insurance.setType(insuranceDetails.getType());
        insurance.setCoverageAmount(insuranceDetails.getCoverageAmount());
        insurance.setPremium(insuranceDetails.getPremium());
        insurance.setStartDate(insuranceDetails.getStartDate());
        insurance.setEndDate(insurance.getEndDate());
       // insurance.setInsuranceId(insurance.getInsuranceId());
        return insurancePolicyRep.save(insurance);
    }
    
    @DeleteMapping("insurancepolicy/{id}")
    public ResponseEntity<?> deletePolicy(@PathVariable(value = "id") Long insuranceId) {
     InsurancePolicy insurance = insurancePolicyRep.findById(insuranceId)
                .orElseThrow();
    
        insurancePolicyRep.delete(insurance);
    
        return ResponseEntity.ok().build();
    }

}


