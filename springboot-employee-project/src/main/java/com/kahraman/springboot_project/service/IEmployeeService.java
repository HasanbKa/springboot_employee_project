package com.kahraman.springboot_project.service;

import com.kahraman.springboot_project.model.Employee;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees(Pageable pageable);
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee, Long id);

    void deleteEmployee(Long id);
}
