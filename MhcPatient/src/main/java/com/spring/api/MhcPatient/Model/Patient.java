package com.spring.api.MhcPatient.Model;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.spring.api.MhcPatient.Request.PatientRequest;

@Document(collection = "Patientlist")
public class Patient {
	@Id
	private String id;
	private Boolean active;
	private List<resource> resource;
	private List<basicDetails> basicDetails;
	private List<Contact> contact;
	private List<Employer> employer;
	private List<Guardian> guardian;
	private List<Misc> misc;
	private List<Stats> stats;
	private List<Insurance> insurance;
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	public List<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(List<Insurance> insurance) {
		this.insurance = insurance;
	}
	
	public List<Stats> getStats() {
		return stats;
	}

	public void setStats(List<Stats> stats) {
		this.stats = stats;
	}

	public List<Misc> getMisc() {
		return misc;
	}

	public void setMisc(List<Misc> misc) {
		this.misc = misc;
	}
	
	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<resource> getResource() {
		return resource;
	}

	public void setResource(List<resource> resource) {
		this.resource = resource;
	}

	public List<basicDetails> getBasicDetails() {
		return basicDetails;
	}

	public void setBasicDetails(List<basicDetails> basicDetails) {
		this.basicDetails = basicDetails;
	}
	

	public List<Employer> getEmployer() {
		return employer;
	}

	public void setEmployer(List<Employer> employer) {
		this.employer = employer;
	}
	
	public List<Guardian> getGuardian() {
		return guardian;
	}

	public void setGuardian(List<Guardian> guardian) {
		this.guardian = guardian;
	}

	// ************ Constructor Method ************\\

	public Patient(String id, Boolean active, List<resource> resource, List<basicDetails> basicDetails,
			List<Contact> contact, List<Employer> employer, List<Guardian> guardian, List<Misc> misc,
			List<Stats> stats, List<Insurance> insurance) {
		this.id = id;
		this.active = active;
		this.resource = resource;
		this.basicDetails = basicDetails;
		this.contact = contact;
		this.employer = employer;
		this.guardian = guardian;
		this.misc = misc;
		this.stats = stats;
		this.insurance = insurance;
	}

	public static Patient build(String id, Boolean active, List<resource> resource, List<basicDetails> basicDetails,
			List<Contact> contact, List<Employer> employer, List<Guardian> guardian, List<Misc> misc,
			List<Stats> stats, List<Insurance> insurance) {
		return new Patient(id, active, resource, basicDetails, contact, employer, guardian, misc, stats, insurance);
	}

	public void update(PatientRequest patientRequest) {
		this.setResource(patientRequest.getResource());
		this.setBasicDetails(patientRequest.getBasicDetails());
		this.setContact(patientRequest.getContact());
		this.setEmployer(patientRequest.getEmployer());
		this.setGuardian(patientRequest.getGuardian());
		this.setMisc(patientRequest.getMisc());
		this.setStats(patientRequest.getStats());
		this.setInsurance(patientRequest.getInsurance());
	}

}
