package com.spring.api.MhcPatient.Model;

import java.time.LocalDate;
import java.util.List;

public class Insurance {

	private List<Primary> primary;
	private List<Secondary> secondary;
	private List<Tertiary> tertiary;
	
	public List<Primary> getPrimary() {
		return primary;
	}
	public void setPrimary(List<Primary> primary) {
		this.primary = primary;
	}
	public List<Secondary> getSecondary() {
		return secondary;
	}
	public void setSecondary(List<Secondary> secondary) {
		this.secondary = secondary;
	}
	public List<Tertiary> getTertiary() {
		return tertiary;
	}
	public void setTertiary(List<Tertiary> tertiary) {
		this.tertiary = tertiary;
	}
	
	
	// ***** Primary-Insurance class  ****//


	public static class Primary{

		private String planName;
		private String subscriber;
		private String effectivedate;
		private String relationship;
		private String policyNumber;
		private LocalDate birthDate;
		private String groupNumber;
		private String ss;
		private String subscriberEmployee;
		private String gender;
		private List<SubscriberAddress> subscriberAddress;
		private String co_pay;
		private String acceptAssignment;
		
		public String getPlanName() {
			return planName;
		}
		public void setPlanName(String planName) {
			this.planName = planName;
		}
		public String getSubscriber() {
			return subscriber;
		}
		public void setSubscriber(String subscriber) {
			this.subscriber = subscriber;
		}
		public String getEffectivedate() {
			return effectivedate;
		}
		public void setEffectivedate(String effectivedate) {
			this.effectivedate = effectivedate;
		}
		public String getRelationship() {
			return relationship;
		}
		public void setRelationship(String relationship) {
			this.relationship = relationship;
		}
		public String getPolicyNumber() {
			return policyNumber;
		}
		public void setPolicyNumber(String policyNumber) {
			this.policyNumber = policyNumber;
		}
		public LocalDate getBirthDate() {
			return birthDate;
		}
		public void setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
		}
		public String getGroupNumber() {
			return groupNumber;
		}

		public void setGroupNumber(String groupNumber) {
			this.groupNumber = groupNumber;
		}
		public String getSs() {
			return ss;
		}
		public void setSs(String ss) {
			this.ss = ss;
		}
		public String getSubscriberEmployee() {
			return subscriberEmployee;
		}
		public void setSubscriberEmployee(String subscriberEmployee) {
			this.subscriberEmployee = subscriberEmployee;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public List<SubscriberAddress> getSubscriberAddress() {
			return subscriberAddress;
		}
		public void setSubscriberAddress(List<SubscriberAddress> subscriberAddress) {
			this.subscriberAddress = subscriberAddress;
		}
		public String getCo_pay() {
			return co_pay;
		}
		public void setCo_pay(String co_pay) {
			this.co_pay = co_pay;
		}
		public String getAcceptAssignment() {
			return acceptAssignment;
		}
		public void setAcceptAssignment(String acceptAssignment) {
			this.acceptAssignment = acceptAssignment;
		}
		
     // ***** SubscriberAddress **** //
		
		public static class SubscriberAddress{

			private String addressLine1;
			private String addressLine2;
			private String city;
			private String state;
			private String country;
			private Number zipCode;
			
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
			public String getCountry() {
				return country;
			}
			public void setCountry(String country) {
				this.country = country;
			}
			public Number getZipCode() {
				return zipCode;
			}
			public void setZipCode(Number zipCode) {
				this.zipCode = zipCode;
			}
			
			
		}
	}
	
	// ***** Secondary-Insurance class  ****//
	public static class Secondary {
	    private Primary insuranceDetails; // Renamed field

	    public Primary getInsuranceDetails() {
	        return insuranceDetails;
	    }

	    public void setInsuranceDetails(Primary insuranceDetails) {
	        this.insuranceDetails = insuranceDetails;
	    }
	}

	
	// ***** Tertiary-Insurance class  ****//
		public static class Tertiary{
		    private Primary insuranceDetails; // Renamed field

		    public Primary getInsuranceDetails() {
		        return insuranceDetails;
		    }

		    public void setInsuranceDetails(Primary insuranceDetails) {
		        this.insuranceDetails = insuranceDetails;
		    }
		}
}
