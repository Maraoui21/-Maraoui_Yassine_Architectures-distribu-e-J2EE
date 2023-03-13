package com.example.thymeleaf.repository;

import com.example.thymeleaf.model.employeer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<employeer,Long> {
}
