package com.spring.api.MhcPatient.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.api.MhcPatient.Model.Patient;

public interface PatientRepository extends MongoRepository<Patient, String> {

    Optional<Patient> findById(String id);

    boolean existsByBasicDetailsNameGivenOrBasicDetailsNameFamily(String givenName, String familyName);
    
    boolean existsByBasicDetailsSsn(String ssn); // Custom query method to check if a patient with the given SSN exists

    boolean existsByBasicDetailsNameGiven(String givenName);
    
    boolean existsByBasicDetailsNameFamily(String familyname);
    
    boolean existsByBasicDetailsBirthDate(LocalDate birthdate);
    
    
    void deleteById(String id);

    Patient save(Optional<Patient> patient);

    Optional<Patient> findByBasicDetailsSsn(String ssn);
    
    List<Patient> findByBasicDetailsNameGiven(String givenName);
    
    List<Patient> findByBasicDetailsNameFamily(String familyName);

    List<Patient> findByBasicDetailsBirthDate(String birthDate);
 
    List<Patient> findByBasicDetailsNameGivenOrBasicDetailsNameFamily(String givenName, String familyName);
    
    List<Patient> findByBasicDetailsNameGivenOrBasicDetailsNameFamilyOrBasicDetailsBirthDate(String givenName, String familyName,String birthdate);
	
}