package com.library.backend.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

// Data Transfer Object for Patron
public class PatronDto {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Phone is mandatory")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,15}$", message = "Invalid phone number")
    private String phone;

    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email format")
    private String email;

    // No-args constructor
    public PatronDto() {}

    // All-args constructor
    public PatronDto(Long id, String name, String phone, String email) {
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
