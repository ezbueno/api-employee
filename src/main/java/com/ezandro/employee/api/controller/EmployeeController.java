package com.ezandro.employee.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping(value = "/")
	public ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeDTO dto) {
		EmployeeDTO newDto = employeeService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<EmployeeDTO> update(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
		EmployeeDTO newDto = employeeService.update(id, dto);
		return ResponseEntity.ok().body(newDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		employeeService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
		
}
