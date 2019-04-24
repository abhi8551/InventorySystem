package com.userSpringH2.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class ContactInformation {

	@Id
	private String username;
	private String emailAddress;
	private String contactNumber;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
}
