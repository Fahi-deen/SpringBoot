package com.fahideen.hibernateMapping.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fahideen.springboot.exception.ResourceNotFoundException;
import com.fahideen.springboot.model.Employee;
import com.fahideen.springboot.repository.EmployeeRepository;
import com.fahideen.springboot.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	} 

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeByid(long id) {
//		 java.util.Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else
//		{
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		
		//using lambda expression
		return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		return null;
	}

	@Override
	public void deleteEmployee(long id) {
		
		//check whether a employee exist in DB or not
		           employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "id", id));
		employeeRepository.deleteById(id);
	}

}
