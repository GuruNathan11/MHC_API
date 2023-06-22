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

    // Helper method to check for duplicate names
 
    private boolean isDuplicateName(List<basicDetails> basicDetailsList) {
        for (basicDetails basicDetails : basicDetailsList) {
            List<basicDetails.Name> nameList = basicDetails.getName();
            for (basicDetails.Name name : nameList) {
                String givenName = name.getGiven();
                String familyName = name.getFamily();

                // Check if the given or family name already exists in the database
                if (repository.existsByBasicDetailsNameGivenOrBasicDetailsNameFamily(givenName, familyName)) {
                    return true; // Duplicate name found
                }
            }
        }

        return false; // No duplicate names
    }


    public List<Patient> getAllPatient(){
    	return repository.findAll();
    }
    
    public Patient getPatient(String id) throws PageNotFound {
        Optional<Patient> patientOptional = repository.findById(id);
        if (patientOptional.isPresent()) {
            return patientOptional.get();
        } else {
            throw new PageNotFound("Patient Not Found With the Given Id: " + id);
        }
    }

//    public Optional<Patient> updatePatient(String id, PatientRequest patientRequest) throws PageNotFound {
//    	Optional<Optional<Patient>> patientOptional = Optional.ofNullable(repository.findById(id));
//    	if (patientOptional.isPresent()) {
//    		Optional<Patient> patient = patientOptional.get();
//    		patient.update(patientRequest);
//    		return repository.save(patient);
//    	} else {
//    		throw new PageNotFound ("Patient Not Found With the Given Id : "+ id);
//    	}
//    }
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
        repository.deleteById((String) id+ "Success...");
    }

    public Patient dischargePatient(String id) throws NoSuchElementException {
        Optional<Patient> patientOptional = repository.findById(id);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            patient.setActive(false); // Set active status to false
            repository.save(patient);
            return patient;
        } else {
            throw new NoSuchElementException("Patient not found with id: " + id);
        }
    }

    
    private String generateUID() {
        // Generate a random alphanumeric ID with 6 digits
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
}

