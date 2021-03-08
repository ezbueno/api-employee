package com.ezandro.employee.api.dto;

import java.io.Serializable;
import java.time.Instant;

import com.ezandro.employee.api.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO implements Serializable {
	
	private Long id;
	private String name;
	private String address;
	private Double salary;
	private String seniorityLevel;
	private String role;
	private Instant entryDate;
	
	public EmployeeDTO(Employee entity) {
		id = entity.getId();
		name = entity.getName();
		address = entity.getAddress();
		salary = entity.getSalary();
		seniorityLevel = entity.getSeniorityLevel();
		role = entity.getRole();
		entryDate = entity.getEntryDate();
	}
}
