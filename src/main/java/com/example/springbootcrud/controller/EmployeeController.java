package com.example.springbootcrud.controller;

import com.example.springbootcrud.entity.Employee;
import com.example.springbootcrud.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;


    @PostMapping("/save")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employeeSaved= employeeServiceInterface.addEmployee(employee);
        return new ResponseEntity<>(employeeSaved, HttpStatus.CREATED);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<List<Employee>> addAllEmployee(@RequestBody List<Employee> employee){
        List<Employee> employeeList= employeeServiceInterface.addAllEmployee(employee);
        return new ResponseEntity<>(employeeList, HttpStatus.CREATED);
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> allEmployees =  employeeServiceInterface.getAllEmployees();
        return new ResponseEntity<>(allEmployees,HttpStatus.OK);

    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Optional<Employee>> getAllEmployeesById(@PathVariable Long id){
        Optional<Employee> employee =  employeeServiceInterface.getEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);

    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeServiceInterface.deleteEmployeeById(id);

    }

    @DeleteMapping("/deleteAllEmployees")
    public void deleteAllEmployees(){
        employeeServiceInterface.deleteAllEmployees();

    }
}
