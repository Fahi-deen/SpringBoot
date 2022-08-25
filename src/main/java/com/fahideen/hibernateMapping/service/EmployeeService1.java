package com.fahideen.hibernateMapping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fahideen.hibernateMapping.model.Employee1;
@Service("EmployeeService1")
public interface EmployeeService1 {
  Employee1 saveEmployee(Employee1 employee);
  List<Employee1> getAllEmployees();
  Employee1 getEmployeeByid(long id);
  Employee1 updateEmployee(Employee1 employee,long id);
  void deleteEmployee(long id);
}
