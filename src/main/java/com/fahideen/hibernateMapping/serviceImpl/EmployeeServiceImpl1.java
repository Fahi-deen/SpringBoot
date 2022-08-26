package com.fahideen.hibernateMapping.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fahideen.hibernateMapping.model.Employee1;
import com.fahideen.hibernateMapping.repository.EmployeeRepository1;
import com.fahideen.hibernateMapping.service.EmployeeService1;
import com.fahideen.springboot.exception.ResourceNotFoundException;



@Service
public class EmployeeServiceImpl1 implements EmployeeService1 {

private EmployeeRepository1 employeeRepository1;
//public EmployeeServiceImpl1() {}
    
	public EmployeeServiceImpl1(EmployeeRepository1 employeeRepository) {
		super();
		this.employeeRepository1 = employeeRepository;
	} 

	@Override
	public Employee1 saveEmployee(Employee1 employee) {
		return employeeRepository1.save(employee);
	}

	@Override
	public List<Employee1> getAllEmployees() {
		return employeeRepository1.findAll();
	}

	@Override
	public Employee1 getEmployeeByid(long id) {
//		 java.util.Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else
//		{
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		
		//using lambda expression
		return employeeRepository1.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee1", "Id", id));
	}

	@Override
	public Employee1 updateEmployee(Employee1 employee, long id) {
		Employee1 existingEmployee=employeeRepository1.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository1.save(existingEmployee);
		return null;
	}

	@Override
	public void deleteEmployee(long id) {
		
		//check whether a employee exist in DB or not
		           employeeRepository1.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee1", "id", id));
		employeeRepository1.deleteById(id);
	}



}
