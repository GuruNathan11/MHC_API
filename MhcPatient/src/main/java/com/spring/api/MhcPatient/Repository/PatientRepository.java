package com.spring.api.MhcPatient.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.api.MhcPatient.Model.Patient;

public interface PatientRepository extends MongoRepository <Patient, String> {

	Optional<Patient> findById(String id);

//	Patient findById(String maritalStatus);
	 boolean existsByBasicDetailsNameGivenOrBasicDetailsNameFamily(String givenName, String familyName);

	void deleteById(String id);

	Patient save(Optional<Patient> patient);

}