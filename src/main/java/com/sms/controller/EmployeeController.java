package com.sms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.Employee;
import com.sms.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
     @GetMapping("/getallemployee")
     public List<Employee>getAllEmployee()
     {
    	 return employeeService.getAllEmployee();
     }
     
     @GetMapping("/getemployeebyid/{id}")
     public Optional<Employee>getEmployeeById(@PathVariable Long id)
     {
    	 return employeeService.getEmployeeById(id);
     }
     @PostMapping("/register")
     public String registerEmployee(@RequestBody Employee emp)
     {
    	 return employeeService.addEmployee(emp);
     }
     
     @DeleteMapping ("/deletebyid/{id}")
     public String deleteEmployeeId(@PathVariable Long id)
     {
    	 return employeeService.deleteEmployee(id);
     }
     @PutMapping("/update/{id}")
     public String updateEmployeeById(@RequestBody Employee emp ,@PathVariable Long id)
     {
    	 return employeeService.updateEmployee(emp, id);
     }
     
     
     
}
