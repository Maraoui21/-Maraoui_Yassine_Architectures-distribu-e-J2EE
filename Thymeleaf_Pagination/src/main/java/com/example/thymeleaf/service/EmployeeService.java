package com.example.thymeleaf.service;
import com.example.thymeleaf.model.employeer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<employeer> getAllEmployees();
    void saveEmployee(employeer e);
    void deleteById(Long id);
    Page<employeer> findPaginated(int pageNum,int pageSize);
}
