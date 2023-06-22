package com.spring.api.MhcPatient.Model;

import java.time.LocalDate;
import java.util.List;

public class basicDetails {
	
	private List<Coding> coding;
	private List<Name> name;
	private String gender;
	private LocalDate birthDate;
	private List<BirthDate> _birthDate;
	private String maritalStatus;
	private String sexualOrientation;
	
	public List<Name> getName() {
		return name;
	}

	public void setName(List<Name> name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<BirthDate> get_birthDate() {
		return _birthDate;
	}

	public void set_birthDate(List<BirthDate> _birthDate) {
		this._birthDate = _birthDate;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getSexualOrientation() {
		return sexualOrientation;
	}

	public void setSexualOrientation(String sexualOrientation) {
		this.sexualOrientation = sexualOrientation;
	}

	public List<Coding> getCoding() {
		return coding;
	}

	public void setCoding(List<Coding> coding) {
		this.coding = coding;
	}

	public static class Coding {
		
	    private String system;
	    private String code;
	    
	    public String getSystem() {
	        return system;
	    }
	    
	    public void setSystem(String system) {
	    	this.system = "http://terminology.hl7.org/CodeSystem/v2-0203";  
	    }
	    
	    public String getCode() {
	        return code;
	    }
	    
	    public void setCode(String code) {
	        this.code = code;
	    }
	}
	
	public static class Name {

		private String use;
		private String given;
		private String family;
		public String getUse() {
			return use;
		}
		public void setUse(String use) {
			this.use = use;
		}
		
		public String getGiven() {
			return given;
		}
		public void setGiven(String given) {
			this.given = given;
		}
		public String getFamily() {
			return family;
		}
		public void setFamily(String family) {
			this.family = family;
		}
	}
	
	public static class BirthDate {
	    private List<Extension> extension;

	    public List<Extension> getExtension() {
	        return extension;
	    }

	    public void setExtension(List<Extension> extension) {
	        this.extension = extension;
	    }

	    public static class Extension {
	        private String url;

	        public String getUrl() {
	            return url;
	        }

	        public void setUrl(String url) {
	            this.url = "http://hl7.org/fhir/StructureDefinition/patient-birthTime";
	        }
	    }
	}

}
