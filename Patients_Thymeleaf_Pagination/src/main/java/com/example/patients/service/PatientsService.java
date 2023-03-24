package com.example.patients.service;

import com.example.patients.entities.Patients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientsService {
    List<Patients> findAll();
    Patients save(Patients patient);
    List<Patients> findByKeyword(String keyword);
    void deletePatientById(Long id);
    Page<Patients> findPageble(Pageable page);
    Patients findById(Long id);
}
