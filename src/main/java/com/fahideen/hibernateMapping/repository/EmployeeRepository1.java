package com.fahideen.hibernateMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fahideen.hibernateMapping.model.Employee1;
import com.fahideen.springboot.model.Employee;
//@Repository (optional) no need Spring JPA repository defaultly provided it
public interface EmployeeRepository1 extends JpaRepository<Employee1, Long>{

}
