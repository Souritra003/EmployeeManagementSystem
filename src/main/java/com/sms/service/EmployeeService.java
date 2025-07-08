package com.sms.service;

import java.util.List;
import java.util.Optional;

import com.sms.entity.Employee;

public interface EmployeeService {
	String addEmployee(Employee student);
	List<Employee> getAllEmployee();
	String updateEmployee(Employee employee,Long id);
	Optional<Employee> getEmployeeById(Long id);
	String deleteEmployee(Long id);

}
