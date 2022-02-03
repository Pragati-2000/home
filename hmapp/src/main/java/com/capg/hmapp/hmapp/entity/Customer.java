package com.capg.hmapp.hmapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity

public class Customer {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@NotNull(message="Customer name can not be null.....")
	private String customerName;
	@Pattern(regexp="(^$|[0-9]{10})",message="mobileNumber must contain 10 digits.....")
	private String mobileNumber;
	@Email
	@NotBlank(message = "Email is mandatory")
	private String emailId;
	
	@Temporal(value=TemporalType.DATE)
	private Date dateOfBirth;
	
	 @NotNull(message="Gender can not be null.....")
	private String gender;
	
	 @NotNull(message="Nationality can not be null.....")
	private String nationality;
	 
	 @NotNull(message="AadharNumber can not be null.....")
	private String aadharNumber;
	
	 @Pattern( regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}",message="Enter a valid pan card Number.....")
	private String panNumber;
	public Customer() {
		super();
	}
	public Customer(int userId, String customerName, String mobileNumber, String emailId, Date dateOfBirth,
			String gender, String nationality, String aadharNumber, String panNumber) {
		super();
		this.userId = userId;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.nationality = nationality;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", customerName=" + customerName + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", nationality="
				+ nationality + ", aadharNumber=" + aadharNumber + ", panNumber=" + panNumber + "]";
	}


}
