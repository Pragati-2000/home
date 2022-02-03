package com.capg.hmapp.hmapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="User_Tb")

public class User {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int uId;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",message="at least 8 characters and at most 20 characters,at least one digit.\r\n"
			+ "at least one upper case alphabet.\r\n"
			+ "at least one lower case alphabet.\r\n"
			+ "at least one special character which includes !@#$%&*()-+=^.!!")
	 private String password;
	@NotNull(message="Enter a valid role.....")

	 private String role;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uId, String password, String role) {
		super();
		this.uId = uId;
		this.password = password;
		this.role = role;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", password=" + password + ", role=" + role + "]";
	}
	
}
