package com.example.patients.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Patients")
@Data
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom ;
    @Column(name = "dateNaissance")
    private Date dateNaissance;
    @Column(name = "malade")
    private boolean malade;
    @Column(name = "score")
    private Integer score;
}
