package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeId  implements Serializable{

	private long employeeId;
	private long companyId;
	
	
	
	public EmployeeId() {
		super();
	}
	public EmployeeId(long employeeId, long companyId) {
		super();
		this.employeeId = employeeId;
		this.companyId = companyId;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
	
	
	
}
