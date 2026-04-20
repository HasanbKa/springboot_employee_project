package com.kahraman.springboot_project.controller;

import com.kahraman.springboot_project.model.Employee;
import com.kahraman.springboot_project.service.IEmployeeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = this.employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam (required = false, defaultValue= "1") int pageNo, @RequestParam (required = false, defaultValue= "5") int pageSize){
        PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize);
        List<Employee> employeesList = this.employeeService.getAllEmployees(pageRequest);
        return new ResponseEntity<>(employeesList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = this.employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
        Employee updatedEmployee = this.employeeService.updateEmployee(employee, id);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee with id "+ id + " was deleted successfully", HttpStatus.OK);
    }

}
