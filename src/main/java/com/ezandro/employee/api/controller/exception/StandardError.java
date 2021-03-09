package com.ezandro.employee.api.controller.exception;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandardError {
	
	private Instant timestamp;
	private int status;
	private String error;
	private String msg;
	private String path;
	
}
