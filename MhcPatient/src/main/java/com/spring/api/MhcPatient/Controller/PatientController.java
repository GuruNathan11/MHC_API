package com.spring.api.MhcPatient.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.MhcPatient.Error.PageNotFound;
import com.spring.api.MhcPatient.Model.Patient;
import com.spring.api.MhcPatient.Request.PatientRequest;
import com.spring.api.MhcPatient.Service.PatientService;

@RestController
@RequestMapping("/api/patient")

public class PatientController {

	@Autowired
	private PatientService service;

	@GetMapping
	public String welcome() {
		return "Welcome to Patient API";
	}
	
//	@PostMapping("/add")
//	public ResponseEntity<Patient> savePatient(@RequestBody @Validated PatientRequest patientRequest) {
//		return new ResponseEntity<Patient>(service.savePatient(patientRequest), HttpStatus.CREATED);
//	}
	@PostMapping("/add")
	public ResponseEntity<Patient> savePatient(@RequestBody @Validated PatientRequest patientRequest) {
	    patientRequest.setActive(true); // Set active status to true
	    return new ResponseEntity<Patient>(service.savePatient(patientRequest), HttpStatus.CREATED);
	}

	
	@GetMapping("/get_all")
	public ResponseEntity <List<Patient>> getAllPatient() throws PageNotFound {
		return ResponseEntity.ok(service.getAllPatient());
	}
	
	@GetMapping("/getPatient/{id}")
	public ResponseEntity<?> getPatient(@PathVariable String id) {
		try {
		return ResponseEntity.ok(service.getPatient(id));}
		catch (PageNotFound e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	

	public ResponseEntity<?> updatePatient(@PathVariable String id, @RequestBody @Validated PatientRequest patientRequest) {
	    try {
	        Patient updatePatient = service.updatePatient(id, patientRequest);
	        return ResponseEntity.ok(updatePatient);
	    } catch (PageNotFound e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); // Set the error message in the response body
	    }
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePatient(@PathVariable String id) throws PageNotFound {
		service.deletePatient(id);
		return ResponseEntity.noContent().build();
	}
	@PostMapping("/discharge/{id}")
	public ResponseEntity<?> dischargePatient(@PathVariable String id) {
	    try {
	        Patient dischargedPatient = service.dischargePatient(id);
	        return ResponseEntity.ok(dischargedPatient);
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.notFound().build();
	    }
	}
}