package com.example.insurancemanagement.model.classes;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import javax.persistence.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "claim")
@manyToOne
public class Claim {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        Long id;
      /*  public Claim() {
        }*/
    
        String claimNumber;
        String description;
        LocalDate claimDate;
        String claimStatus;
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getClaimNumber()
        {
            return claimNumber;
        }
        public void setClaimNuber(String claimNumber)
        {
            this.claimNumber=claimNumber;
        }
        public String getDescription(){
            return description;
        }
        public void setDescription(String description)
        {
            this.description=description;
        }
        public LocalDate getClaimDate()
        {
            return claimDate;
        }
        public void setClaimDate(LocalDate claimDate)
        {
            this.claimDate=claimDate;
        }
        public String getClaimStatus(){
            return claimStatus;
        }
        public void setClaimStatus(String claimStatus)
        {
           this.claimStatus=claimStatus;
        }
    
    
        InsurancePolicy insurancepolicy;
    }
    





