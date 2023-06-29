package com.spring.api.MhcPatient.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.MhcPatient.Error.PageNotFound;
import com.spring.api.MhcPatient.Model.Patient;
import com.spring.api.MhcPatient.Model.basicDetails;
import com.spring.api.MhcPatient.Model.resource;
import com.spring.api.MhcPatient.Repository.PatientRepository;
import com.spring.api.MhcPatient.Request.PatientRequest;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repository;

	public Patient savePatient(PatientRequest patientRequest) {
		String uid = generateUID(); // Generate UID

		resource resource = new resource();
		resource.setFullUrl("urn:uuid:" + uid);
		resource.setResourceType("PATIENT");
		
		List<basicDetails> basicDetailsList = patientRequest.getBasicDetails();
		List<basicDetails> basicDetailsList1 = patientRequest.getBasicDetails();
		if (isDuplicateSSN(basicDetailsList1)) {
			throw new IllegalArgumentException("Given SSN already registered");
		}

		if (isDuplicateName(basicDetailsList)) {
			throw new IllegalArgumentException("Given or Family name already exists");
		}

		Patient patient = Patient.build(uid, patientRequest.getActive(), List.of(resource),
				patientRequest.getBasicDetails(), patientRequest.getContact(), patientRequest.getEmployer(),
				patientRequest.getGuardian(), patientRequest.getMisc(), patientRequest.getStats(),
				patientRequest.getInsurance());
		patient.setId(uid); // Set the _id value as UID
		return repository.save(patient);
	}

	// ****** To Validate the SSN *****\\
	private boolean isDuplicateSSN(List<basicDetails> basicDetailsList) {
		for (basicDetails basicDetails : basicDetailsList) {
			String ssn = basicDetails.getSsn();

			if (repository.existsByBasicDetailsSsn(ssn)) {
				return true; // Duplicate SSN found
			}
		}
		return false; // No duplicate SSN
	}

	// ****** To Validate the GIven Name and Family Name *****\\
	private boolean isDuplicateName(List<basicDetails> basicDetailsList) {
		for (basicDetails basicDetails : basicDetailsList) {
			List<basicDetails.Name> nameList = basicDetails.getName();
			for (basicDetails.Name name : nameList) {
				String givenName = name.getGiven();
				String familyName = name.getFamily();

				if (repository.existsByBasicDetailsNameGivenOrBasicDetailsNameFamily(givenName, familyName)) {
					return true; // Duplicate name found
				}
			}
		}
		return false; // No duplicate names
	}

	public List<Patient> getAllPatient() {
		return repository.findAll();
	}

	// ****** To get the Patient Details Based on ID *****\\
	public Patient getPatient(String id) throws PageNotFound {
		Optional<Patient> patientOptional = repository.findById(id);
		if (patientOptional.isPresent()) {
			return patientOptional.get();
		} else {
			throw new PageNotFound("Patient Not Found With the Given Id: " + id);
		}
	}

	//
	// ****** To get the Patient Details Based on SSN *****\\
	public Patient getPatientBySsn(String ssn) throws PageNotFound {
		boolean patientExists = repository.existsByBasicDetailsSsn(ssn);
		if (patientExists) {
			return repository.findByBasicDetailsSsn(ssn)
					.orElseThrow(() -> new PageNotFound("Patient Not Found With the Given SSN: " + ssn));
		} else {
			throw new PageNotFound("Patient Not Found With the Given SSN: " + ssn);
		}
	}

	// ****** To get the Patient Details Based on GIVEN NAME *****\\
	public List<Patient> getPatientsByGivenName(String givenName) throws PageNotFound {
		List<Patient> patients = repository.findByBasicDetailsNameGiven(givenName);
		if (patients.isEmpty()) {
			throw new PageNotFound("No patients found with given name: " + givenName);
		}
		return patients;
	}

	// ****** To get the Patient Details Based on FAMILY NAME *****\\
	public List<Patient> getPatientsByFamilyName(String familyName) throws PageNotFound {
		List<Patient> patients = repository.findByBasicDetailsNameFamily(familyName);
		if (patients.isEmpty()) {
			throw new PageNotFound("No patients found with given name: " + familyName);
		}
		return patients;
	}

//	// ****** To get the Patient Details Based on BIRTH DATE(date Format) *****\\
//	public List<Patient> getPatientsByBirthDate(LocalDate birthDate) throws PageNotFound {
//		Date date = Date.from(birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
//		List<Patient> patients = repository.findByBasicDetailsBirthDate(date);
//		if (patients.isEmpty()) {
//			throw new PageNotFound("No patients found with given birth date: " + birthDate);
//		}
//		return patients;
//	}
	
	// ****** To get the Patient Details Based on BIRTH DATE(String Format) *****\\
		public List<Patient> getPatientsByBirthDate(String birthDate) throws PageNotFound {
			List<Patient> patients = repository.findByBasicDetailsBirthDate(birthDate);
			if (patients.isEmpty()) {
				throw new PageNotFound("No patients found with given birth date: " + birthDate);
			}
			return patients;
		}

	
	// ****** To get the Patient Details Based on GIVEN NAME AND FAMILY NAME *****\\
	public List<Patient> getPatientsByGivenNameAndFamilyName(String givenName, String familyName) throws PageNotFound {
	    List<Patient> patients = repository.findByBasicDetailsNameGivenOrBasicDetailsNameFamily(givenName, familyName);
	    if (patients.isEmpty()) {
	        throw new PageNotFound("No patients found with given name: " + givenName + " and family name: " + familyName);
	    }
	    return patients;
	}
	
	// ****** To get the Patient Details Based on GIVEN NAME AND FAMILY NAME AND BIRTHDATE *****\\
		public List<Patient> getPatientsByGivenNameAndFamilyNameAndBirthDate(String givenName, String familyName, String birthDate) throws PageNotFound {
			List<Patient> patients = repository.findByBasicDetailsNameGivenOrBasicDetailsNameFamilyOrBasicDetailsBirthDate(givenName, familyName, birthDate);
		    if (patients.isEmpty()) {
		        throw new PageNotFound("No patients found with given name: " + givenName + " and family name: " + familyName + " and birthDate: " + birthDate);
		    }
		    return patients;
		}

	// ****** Update the Patient Details Based on ID *****\\
	public Patient updatePatient(String id, PatientRequest patientRequest) throws PageNotFound {
		Optional<Patient> patientOptional = repository.findById(id);
		if (patientOptional.isPresent()) {
			Patient patient = patientOptional.get();
			patient.update(patientRequest);
			return repository.save(patient);
		} else {
			throw new PageNotFound("Patient not found with id: " + id);
		}
	}

	public void deletePatient(String id) throws PageNotFound {
		if (!repository.existsById((String) id)) {
			throw new PageNotFound("Patient not found with id: " + id);
		}
		repository.deleteById((String) id + "Success...");
	}

	// ****** To Discharge the Patient Based on ID *****\\
	public Patient dischargePatient(String id) throws NoSuchElementException {
		Optional<Patient> patientOptional = repository.findById(id);
		if (patientOptional.isPresent()) {
			Patient patient = patientOptional.get();
			patient.setActive("1"); // Set active status to false
			repository.save(patient);
			return patient;
		} else {
			throw new NoSuchElementException("Patient not found with id: " + id);
		}
	}

	private String generateUID() {
		// Generate a random alphanumeric ID with 10 digits
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
}
