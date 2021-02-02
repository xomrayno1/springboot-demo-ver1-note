package com.example.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Employee {
	@EmbeddedId
	private EmployeeId employeeId; // select employee.employeeId.employeeId from Employee employee
	
	private String firstName;
	private String lastName;
	
	
	

}
