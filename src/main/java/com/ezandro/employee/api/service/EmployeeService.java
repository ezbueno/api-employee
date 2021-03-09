package com.ezandro.employee.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezandro.employee.api.dto.EmployeeDTO;
import com.ezandro.employee.api.entity.Employee;
import com.ezandro.employee.api.repository.EmployeeRepository;
import com.ezandro.employee.api.service.exception.EmployeeNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional(readOnly = true)
	public EmployeeDTO findById(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Id: " + id + " not found!"));
		return new EmployeeDTO(employee);
	}
	
	@Transactional(readOnly = true)
	public List<EmployeeDTO> findAll() {
		List<Employee> employee = employeeRepository.findAll();
		return employee.stream().map(e -> new EmployeeDTO(e)).collect(Collectors.toList());
	}
	
	@Transactional
	public EmployeeDTO insert(EmployeeDTO dto) {
		Employee employee = new Employee();
		employee.setName(dto.getName());
		employee.setAddress(dto.getAddress());
		employee.setSalary(dto.getSalary());
		employee.setSeniorityLevel(dto.getSeniorityLevel());
		employee.setRole(dto.getRole());
		employee.setEntryDate(dto.getEntryDate());
		employee = employeeRepository.save(employee);
		return new EmployeeDTO(employee);
	}
	
	@Transactional
	public EmployeeDTO update(Long id, EmployeeDTO dto) {
		findById(id);
		
		Employee employee = employeeRepository.getOne(id);
		employee.setName(dto.getName());
		employee.setAddress(dto.getAddress());
		employee.setSalary(dto.getSalary());
		employee.setSeniorityLevel(dto.getSeniorityLevel());
		employee.setRole(dto.getRole());
		employee.setEntryDate(dto.getEntryDate());
		return new EmployeeDTO(employee);
	}
	
	public void deleteById(Long id) {
		findById(id);
		employeeRepository.deleteById(id);
	}
}
