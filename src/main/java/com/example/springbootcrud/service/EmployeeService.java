package com.example.springbootcrud.service;

import com.example.springbootcrud.EmployeeRepository;
import com.example.springbootcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public List<Employee> addAllEmployee(List<Employee> employee) {
        List<Employee>  employeeList = employeeRepository.saveAll(employee);
        return employeeList;
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
}
