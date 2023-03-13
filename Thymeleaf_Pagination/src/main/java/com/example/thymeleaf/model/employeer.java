package com.example.thymeleaf.model;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class employeer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "First_name")
    private String FirstName;
    @Column(name = "Last_Name")
    private String LastName;
    @Column(name = "Role")
    private String Role;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getRole() {
        return Role;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setRole(String role) {
        Role = role;
    }
}
