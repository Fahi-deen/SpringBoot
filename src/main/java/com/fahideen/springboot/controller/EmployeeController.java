package com.fahideen.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fahideen.springboot.model.Employee;
import com.fahideen.springboot.service.EmployeeService;

@RestController
@RequestMapping(value="/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	//build create Employee Rest API
	@PostMapping()
	public ResponseEntity<Employee> saveEmployeeEntity(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	//build get all employees REST API
	@GetMapping
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
	}
    //build get employee by id REST API
	@GetMapping("{id}") // this id must same as pathvariable id
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long Empid){
		return new ResponseEntity<Employee>(employeeService.getEmployeeByid(Empid), HttpStatus.OK);
		
	}
	//build update employee by id REST API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK );
		
	}
	//build delete employee by id REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id)
	{
		employeeService.deleteEmployee(id);
		return new  ResponseEntity<String>("Employee deleted Sucessfully", HttpStatus.OK);
	}
	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
