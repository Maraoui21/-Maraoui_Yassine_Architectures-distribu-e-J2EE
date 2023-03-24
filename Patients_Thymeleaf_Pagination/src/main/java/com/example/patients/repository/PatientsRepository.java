package com.example.patients.repository;

import com.example.patients.entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientsRepository extends JpaRepository<Patients,Long> {
    @Query("SELECT p FROM Patients p WHERE p.nom LIKE %:keyword%")
    List<Patients> findByKeyword(@Param("keyword") String keyword);
}
