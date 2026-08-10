package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    void deleteEmployeeById(Long id);

    List<Employee> addAllEmployee(List<Employee> employee);

    void deleteAllEmployees();
}
