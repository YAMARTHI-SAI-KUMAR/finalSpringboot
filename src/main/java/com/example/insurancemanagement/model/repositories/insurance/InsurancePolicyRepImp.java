package com.example.insurancemanagement.model.repositories.insurance;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.example.insurancemanagement.model.classes.InsurancePolicy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Configuration
public class InsurancePolicyRepImp implements InsurancePolicyCustomRep {
   @Autowired
   EntityManager entityManager;

   @Bean 
   public LocalSessionFactoryBean sessionFactory() {
       LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean(); 
   
       return sessionFactory;
   }
   



private Object type;
private Object coverageAmount;
private Object premium;
private Object startDate;
private Object endDate;
//private Object insuranceId;
private Object policyNumber;

@Override
public List<InsurancePolicy> createPolicy(InsurancePolicy insurancePolicy) {
    String sql="INSERT INTO insurancepolicy( policyNumber,type, coverageAmount, premium, startDate,endDate)";
    final TypedQuery<InsurancePolicy> query= ((EntityManager) entityManager).createQuery(sql,InsurancePolicy.class);
    return  query.getResultList();
}

@Override
public List<InsurancePolicy> findAllPolicies() {

    String sql = "select i from insurancepolicy c";
    final TypedQuery<InsurancePolicy> query = ((EntityManager) entityManager).createQuery(sql, InsurancePolicy.class);

    return query.getResultList();
    
}

@Override
public List<InsurancePolicy> findPolicyById(Long insuranceId) {

    String sql = "select i from InsurancePolicy where i.policyNumber : policyNumber";
        final TypedQuery<InsurancePolicy> query = ((EntityManager) entityManager).createQuery(sql, InsurancePolicy.class);
        query.setParameter("InsuranceId", insuranceId);
        return query.getResultList();
}

@Override
public InsurancePolicy updatePolicy(Long insuranceId, InsurancePolicy insuranceDetails) {
    String sql = "UPDATE insurancepolicy i SET i.policyNumber = :policyNumber,i. type= :type, i.coverageAmount = :coverageAmount, i.premium= :preimum, i.startDate = :startDate,i.endDate=:endDate.i.insuranceId=:insuranceId";
    final TypedQuery<InsurancePolicy> query =  entityManager.createQuery(sql, InsurancePolicy.class);
    query.setParameter("policyNumber", policyNumber);
     query.setParameter("type", type);
    query.setParameter("covearageAmount", coverageAmount);
    query.setParameter("premium", premium);
    query.setParameter("startDate", startDate);
    query.setParameter("endDate",endDate);
    query.setParameter("insuranceId",insuranceId);
    query.executeUpdate();
    return (InsurancePolicy) query.getResultList();
}

@Override
public ResponseEntity<?> deletePolicy(Long insuranceId) {

    String sql = "DELETE FROM insurancepolicy i WHERE i.id = :insuranceId";
        final TypedQuery<InsurancePolicy> query = ((EntityManager) entityManager).createQuery(sql, InsurancePolicy.class);
        query.setParameter("insuranceId", insuranceId);
        query.executeUpdate();
        return (ResponseEntity<?>) query.getResultList();
}
    
    
}
