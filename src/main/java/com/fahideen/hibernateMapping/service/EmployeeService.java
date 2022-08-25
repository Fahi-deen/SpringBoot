package com.fahideen.hibernateMapping.service;

import java.util.List;

import com.fahideen.springboot.model.Employee;
public interface EmployeeService {
  Employee saveEmployee(Employee employee);
  List<Employee> getAllEmployees();
  Employee getEmployeeByid(long id);
  Employee updateEmployee(Employee employee,long id);
  void deleteEmployee(long id);
}
