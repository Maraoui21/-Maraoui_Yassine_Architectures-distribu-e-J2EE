package com.example.patients.service.Impl;
import com.example.patients.entities.Patients;
import com.example.patients.repository.PatientsRepository;
import com.example.patients.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientsServiceImpl implements PatientsService {
    @Autowired
    PatientsRepository patientsRepository;
    @Override
    public List<Patients> findAll() {
        return patientsRepository.findAll();
    }

    @Override
    public Patients save(Patients patient) {
        return patientsRepository.save(patient);
    }

    @Override
    public List<Patients> findByKeyword(String keyword) {
        return patientsRepository.findByKeyword(keyword);
    }

    @Override
    public void deletePatientById(Long id) {
        patientsRepository.deleteById(id);
    }

    @Override
    public Page<Patients> findPageble(Pageable page) {
        return patientsRepository.findAll(page);
    }

    @Override
    public Patients findById(Long id) {
        Optional<Patients> patient = patientsRepository.findById(id);
        return patient.orElse(null);
    }


}
