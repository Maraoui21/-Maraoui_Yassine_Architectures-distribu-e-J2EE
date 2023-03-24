package com.example.patients;

import com.example.patients.entities.Patients;
import com.example.patients.repository.PatientsRepository;
import com.example.patients.service.Impl.PatientsServiceImpl;
import com.example.patients.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class PatientsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatientsApplication.class, args);
    }
}
