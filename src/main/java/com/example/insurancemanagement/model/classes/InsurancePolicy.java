package com.example.insurancemanagement.model.classes;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//import com.example.insurancemanagement.model.oneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "insurancepolicy")
@manyToOne
public class InsurancePolicy {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)



    Long id;
    
    String policyNumber;
    String type;
    BigDecimal coverageAmount;
    BigDecimal premium;
    LocalDate startDate;
    LocalDate endDate;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public BigDecimal getCoverageAmount() {
        return coverageAmount;
    }
    public void setCoverageAmount(BigDecimal coverageAmount) {
        this.coverageAmount = coverageAmount;
    }
    public BigDecimal getPremium() {
        return premium;
    }
    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    Client client;
    public List<InsurancePolicy> save(InsurancePolicy insurancePolicy) {
        return null;
    }
    public Object getInsuranceId() {
        return null;
    }
    
}

