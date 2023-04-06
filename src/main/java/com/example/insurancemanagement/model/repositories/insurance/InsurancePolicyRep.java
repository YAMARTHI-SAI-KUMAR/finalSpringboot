package com.example.insurancemanagement.model.repositories.insurance;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.insurancemanagement.model.classes.InsurancePolicy;

public interface InsurancePolicyRep extends CrudRepository<InsurancePolicy,Long>{

    Optional<InsurancePolicy> findByPolicyNumber(Long policyNumber);
}
