package com.spring.api.MhcPatient.Model;

import java.util.List;



public class Contact {

	private List<Address> address;
	private String motherName;
	private Number homePhone;
	private Number workPhone;
	private Number mobilePhone;
	private String contactEmail;
	private String trustedEmail;
	private List<Emergency> emergency;
	private List<AdditionalAddress> additionalAddress;
	
	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Number getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(Number homePhone) {
		this.homePhone = homePhone;
	}

	public Number getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(Number workPhone) {
		this.workPhone = workPhone;
	}

	public Number getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(Number mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getTrustedEmail() {
		return trustedEmail;
	}

	public void setTrustedEmail(String trustedEmail) {
		this.trustedEmail = trustedEmail;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public List<Emergency> getEmergency() {
		return emergency;
	}

	public void setEmergency(List<Emergency> emergency) {
		this.emergency = emergency;
	}
	
	public List<AdditionalAddress> getAdditionalAddress() {
		return additionalAddress;
	}

	public void setAdditionalAddress(List<AdditionalAddress> additionalAddress) {
		this.additionalAddress = additionalAddress;
	}

	//*****  Constrained class  *****\\
	
	

	//Address Class
	public static class Address{
		
		private String addressLine1;
		private String addressLine2;
		private String city;
		private String state;
		private String postalCode;
		private String Country;
		public String getAddressLine1() {
			return addressLine1;
		}
		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}
		public String getAddressLine2() {
			return addressLine2;
		}
		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		public String getCountry() {
			return Country;
		}
		public void setCountry(String country) {
			Country = country;
		}		
	}
	
	
	//Emergency Class;
	public static class Emergency{
		
		private String relationship;
		private String emergencyContact;
		private String emergencyMobile;
		public String getRelationship() {
			return relationship;
		}
		public void setRelationship(String relationship) {
			this.relationship = relationship;
		}
		public String getEmergencyContact() {
			return emergencyContact;
		}
		public void setEmergencyContact(String emergencyContact) {
			this.emergencyContact = emergencyContact;
		}
		public String getEmergencyMobile() {
			return emergencyMobile;
		}
		public void setEmergencyMobile(String emergencyMobile) {
			this.emergencyMobile = emergencyMobile;
		}	
	}

	//Additional-Address class;
	
	public static class AdditionalAddress {
		
		private String addressUse;
		private String  addressType;
		private String startDate;
		private String endDate;
		private String addressLine1;
		private String addressLine2;
		private String city;
		private String district;
		private String state;
		private String postalCodeNumber;
		private String country;
		
		public String getAddressUse() {
			return addressUse;
		}
		public void setAddressUse(String addressUse) {
			this.addressUse = addressUse;
		}
		public String getAddressType() {
			return addressType;
		}
		public void setAddressType(String addressType) {
			this.addressType = addressType;
		}
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		public String getAddressLine1() {
			return addressLine1;
		}
		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}
		public String getAddressLine2() {
			return addressLine2;
		}
		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getPostalCodeNumber() {
			return postalCodeNumber;
		}
		public void setPostalCodeNumber(String postalCodeNumber) {
			this.postalCodeNumber = postalCodeNumber;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		
		
	}
}
