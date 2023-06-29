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
import org.springframework.web.bind.annotation.PutMapping;
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
	
	// ****** To Add the Patient *****\\
	@PostMapping("/add")
	public ResponseEntity<Patient> savePatient(@RequestBody @Validated PatientRequest patientRequest) {
	    patientRequest.setActive("0"); // Set active status to true
	    return new ResponseEntity<Patient>(service.savePatient(patientRequest), HttpStatus.CREATED);
	}

	// ****** To get all the Patient List *****\\
	@GetMapping("/get_all")
	public ResponseEntity <List<Patient>> getAllPatient() throws PageNotFound {
		return ResponseEntity.ok(service.getAllPatient());
	}
	
	// ****** To find the Specific Patient Based on id *****\\
	@GetMapping("/getPatient/{id}")
	public ResponseEntity<?> getPatient(@PathVariable String id) {
		try {
		return ResponseEntity.ok(service.getPatient(id));}
		catch (PageNotFound e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	// ****** To get the Specific Patient Based on SSN *****\\
	  @GetMapping("/getPatient/ssn/{ssn}")
	    public ResponseEntity<?> getPatientBySsn(@PathVariable String ssn) {
	        try {
	            return ResponseEntity.ok(service.getPatientBySsn(ssn));
	        } catch (PageNotFound f) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(f.getMessage());
	        }
	    }
	  
	// ****** To get the Specific Patient Based on Given Name *****\\
	    @GetMapping("/getPatient/givenName/{givenName}")
	    public ResponseEntity<?> getPatientsByGivenName(@PathVariable String givenName) {
	        try {
	            List<Patient> patients = service.getPatientsByGivenName(givenName);
	            if (!patients.isEmpty()) {
	                return ResponseEntity.ok(patients);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (PageNotFound e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
	    
	 // ****** To get the Patient List Based on Family Name *****\\
	    @GetMapping("/getPatient/familyName/{familyName}")
	    public ResponseEntity<?> getPatientsByFamilyName(@PathVariable String familyName) {
	        try {
	            List<Patient> patients = service.getPatientsByFamilyName(familyName);
	            if (!patients.isEmpty()) {
	                return ResponseEntity.ok(patients);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (PageNotFound e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
	    
	 // ****** To get the Patient List Based on Given Name And Family Name *****\\
	    @GetMapping("/getPatient/givenName/{givenName}/familyName/{familyName}")
	    public ResponseEntity<?> getPatientsByGivenNameAndFamilyName(@PathVariable String givenName, @PathVariable String familyName) {
	        try {
	            List<Patient> patients = service.getPatientsByGivenNameAndFamilyName(givenName,familyName);
	            if (!patients.isEmpty()) {
	                return ResponseEntity.ok(patients);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (PageNotFound e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
	    
	 // ****** To get the Patient List Based on Given Name And Family Name And DOB *****\\
	    @GetMapping("/getPatient/givenName/{givenName}/familyName/{familyName}/birthDate/{birthDate}")
	    public ResponseEntity<?> getPatientsByGivenNameAndFamilyNameAndBirthDate(@PathVariable String givenName, @PathVariable String familyName,
	    		@PathVariable String birthDate) {
	        try {
	            List<Patient> patients = service.getPatientsByGivenNameAndFamilyNameAndBirthDate(givenName,familyName,birthDate);
	            if (!patients.isEmpty()) {
	                return ResponseEntity.ok(patients);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (PageNotFound e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
	    
	 // ****** To get the Patient List Based on DOB *****\\
	    @GetMapping("/getPatient/dob/{birthDate}")
	    public ResponseEntity<?> getPatientsByBirthDate(@PathVariable String birthDate) {
	        try {
	            List<Patient> patients = service.getPatientsByBirthDate(birthDate);
	            if (!patients.isEmpty()) {
	                return ResponseEntity.ok(patients);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (PageNotFound e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
	  
	 // ****** To Update Specific Patient details Based on Id *****\\
	    @PutMapping("/update/{id}")
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
	
	// ****** To set the Specific Patient Active details to inactive *****\\
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