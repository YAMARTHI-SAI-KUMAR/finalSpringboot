package com.example.insurancemanagement.model.repositories.insurance;

import java.util.List;
//import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.insurancemanagement.model.classes.InsurancePolicy;
import com.example.insurancemanagement.model.repositories.RequestBody;

public interface InsurancePolicyCustomRep {
    public List<InsurancePolicy> createPolicy(@RequestBody InsurancePolicy insurancePolicy);
    public List<InsurancePolicy> findAllPolicies();
    public List<InsurancePolicy> findPolicyById(@PathVariable(value = "insuranceId") Long insuranceId);
    public InsurancePolicy updatePolicy(@PathVariable(value = "insuranceId") Long insuranceId, @RequestBody InsurancePolicy insuranceDetails);
    public ResponseEntity<?> deletePolicy(@PathVariable(value = "insuranceId") Long insuranceId);
}
/*
 * 
 * 
 * findAllPolicies()
findPolicyById(Long id)
createPolicy(InsurancePolicy policy)
updatePolicy(Long id, InsurancePolicy policy)
deletePolicy(Long id)
 */