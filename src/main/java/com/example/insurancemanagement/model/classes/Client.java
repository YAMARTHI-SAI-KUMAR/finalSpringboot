package com.example.insurancemanagement.model.classes;


import java.time.LocalDate;

//import com.example.insurancemanagement.model.oneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
//import javax.persistence.Id;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
@manyToOne
public class Client  {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
//@GeneratedValue(strategy = GenerationType.AUTO)

    Long id;
    String name;
    @Column(name="date_of_birth")
    LocalDate dateOfBirth;
    String address;
    String contactinformation;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }
    public void setLocalDate(LocalDate dateOfBirth)
    {
        this.dateOfBirth=dateOfBirth;
    }
    public String getAdresss() {
        return address;
    }
    public void setId(String address) {
        this.address = address;
    }
    public String getContactInformation()
    {
        return contactinformation;
    }
    public void setContactInformation(String contactinformation)
    {
        this.contactinformation=contactinformation;
    }
    
    
    
   
}



