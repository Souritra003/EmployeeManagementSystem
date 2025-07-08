package com.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Employee;
import com.sms.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee emp=employeeRepository.findByEmail(employee.getEmailId());
		if(emp!=null)
		{
			return "An employee with same record already present";
		}
		employeeRepository.save(employee);
		return "Data saved successfully";
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public String updateEmployee(Employee employee, Long id) {
	    Optional<Employee> optionalEmp = employeeRepository.findById(id);
	    
	    if (optionalEmp.isPresent()) {
	        Employee emp = optionalEmp.get();
	        emp.setFirstName(employee.getFirstName());
	        emp.setLastName(employee.getLastName());
	        emp.setEmailId(employee.getEmailId());
	        emp.setDepartment(employee.getDepartment());
	        employeeRepository.save(emp);
	        return "Data updated successfully";
	    }
	    
	    return "Updation Failed: Employee with ID " + id + " not found";
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	public String deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		Optional<Employee>emp=employeeRepository.findById(id);
		if(emp.isPresent())
		{
			employeeRepository.deleteById(id);
			return "Deletion Successfull";
		}
		return "Deletion Failed";
		
	}
	
}
