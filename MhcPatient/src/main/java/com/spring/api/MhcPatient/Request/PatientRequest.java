package com.spring.api.MhcPatient.Request;

import java.util.List;

import com.spring.api.MhcPatient.Model.Contact;
import com.spring.api.MhcPatient.Model.Employer;
import com.spring.api.MhcPatient.Model.Guardian;
import com.spring.api.MhcPatient.Model.Insurance;
import com.spring.api.MhcPatient.Model.Misc;
import com.spring.api.MhcPatient.Model.Stats;
import com.spring.api.MhcPatient.Model.basicDetails;
import com.spring.api.MhcPatient.Model.resource;

public class PatientRequest {

    private String id;
//    private Boolean active;
    private String active;
    private List<resource> resource;
    private List<basicDetails> basicDetails;
    private List<Contact> contact;
    private List<Employer> employer;
    private List<Guardian> guardian;
    private List<Misc> misc;
    private List<Stats> stats;
    private List<Insurance> insurance;
    
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

	public List<resource> getResource() {
        return resource;
    }

    public void setResource(List<resource> resource) {
        this.resource = resource;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}	
	
}