package com.spring.api.MhcPatient.ErrorHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.api.MhcPatient.Error.PageNotFound;

import jakarta.validation.ConstraintViolationException;

public class PageExceptionHandler {

	@ExceptionHandler({ PageNotFound.class,})
	public ResponseEntity<Map<String, String>> handleNotFoundException(RuntimeException ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMap);
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class, ConstraintViolationException.class })
	public ResponseEntity<Map<String, String>> handleValidationExceptions(Exception ex) {
		Map<String, String> errorMap = new HashMap<>();
		if (ex instanceof MethodArgumentNotValidException) {
			((MethodArgumentNotValidException) ex).getBindingResult().getFieldErrors().forEach(error -> {
				errorMap.put(error.getField(), error.getDefaultMessage());
			});
		} else if (ex instanceof ConstraintViolationException) {
			((ConstraintViolationException) ex).getConstraintViolations().forEach(violation -> {
				errorMap.put(violation.getPropertyPath().toString(), violation.getMessage());
			});
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMap);
	}
}

