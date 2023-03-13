package com.example.thymeleaf.service;

import com.example.thymeleaf.model.employeer;
import com.example.thymeleaf.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<employeer> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(employeer e) {
        employeeRepository.save(e);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<employeer> findPaginated(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1 ,pageSize);
        return employeeRepository.findAll(pageable);
    }

}
