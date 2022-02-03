package com.capg.hmapp.hmapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Admin_Tb")

public class Admin {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int userId;
	
	@NotNull(message="AdminName can not be null.....")
	@Column(name="ad_name")
	private String adminName;
	
	@Pattern(regexp="(^[0-9]{10})$",message="contact must contain 10 digits only.....")
	@Column(name="ad_com")

	private String adminContact;
	
	public Admin() {
		super();
	}
	public Admin(int userId, String adminName, String adminContact) {
		super();
		this.userId = userId;
		this.adminName = adminName;
		this.adminContact = adminContact;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminContact() {
		return adminContact;
	}
	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}
	@Override
	public String toString() {
		return "Admin [userId=" + userId + ", adminName=" + adminName + ", adminContact=" + adminContact + "]";
	}
	


}
