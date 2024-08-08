package com.library.backend.entity;

import java.time.Year;
import java.util.Set;

import jakarta.persistence.CascadeType;

//import org.hibernate.annotations.processing.Pattern;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Entity
@Table(name = "patron")
@NoArgsConstructor

public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone", nullable = false, unique = true, length = 15)
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,15}$", message = "Invalid phone number")
    private String phone;

    @Column(name = "email", nullable = false, unique = true)
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
    private String email;

   // @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL, orphanRemoval = true)
   @OneToMany( fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,orphanRemoval = true, mappedBy = "patron") 
    private Set<BorrowingRecord> borrowingRecords;

     // Custom constructor excluding borrowingRecords
     public Patron(Long id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getter and Setter methods 
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    

}
