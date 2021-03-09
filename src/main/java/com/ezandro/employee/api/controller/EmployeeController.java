package com.ezandro.employee.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezandro.employee.api.dto.EmployeeDTO;
import com.ezandro.employee.api.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
		EmployeeDTO dto = employeeService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<EmployeeDTO>> findAll() {
		List<EmployeeDTO> dto = employeeService.findAll();
		return ResponseEntity.ok().body(dto);
	}
		
}
