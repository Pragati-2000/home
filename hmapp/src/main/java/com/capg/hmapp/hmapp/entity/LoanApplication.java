package com.capg.hmapp.hmapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;


@Entity
public class LoanApplication {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int appliactionId;
	private Date applicationDate;
	@Min(value=100,message="Minimum value for loanAppliedAmount should be 100  ")

	private double loanAppliedAmount;
	@Min(value=100,message="Minimum value for loanApprovedAmount should be 100  ")

	private double loanApprovedAmount;
	private boolean landVerificationApproval;
	private boolean financeVerificationApproval;
	private boolean adminApproval;
	@Enumerated(value=EnumType.STRING)
	private Status status;
	public LoanApplication() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoanApplication(int appliactionId, Date applicationDate, double loanAppliedAmount,
			double loanApprovedAmount, boolean landVerificationApproval, boolean financeVerificationApproval,
			boolean adminApproval, com.capg.hmapp.hmapp.entity.Status status) {
		super();
		this.appliactionId = appliactionId;
		this.applicationDate = applicationDate;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.financeVerificationApproval = financeVerificationApproval;
		this.adminApproval = adminApproval;
		this.status = status;
	}
	public int getAppliactionId() {
		return appliactionId;
	}
	public void setAppliactionId(int appliactionId) {
		this.appliactionId = appliactionId;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public double getLoanAppliedAmount() {
		return loanAppliedAmount;
	}
	public void setLoanAppliedAmount(double loanAppliedAmount) {
		this.loanAppliedAmount = loanAppliedAmount;
	}
	public double getLoanApprovedAmount() {
		return loanApprovedAmount;
	}
	public void setLoanApprovedAmount(double loanApprovedAmount) {
		this.loanApprovedAmount = loanApprovedAmount;
	}
	public boolean isLandVerificationApproval() {
		return landVerificationApproval;
	}
	public void setLandVerificationApproval(boolean landVerificationApproval) {
		this.landVerificationApproval = landVerificationApproval;
	}
	public boolean isFinanceVerificationApproval() {
		return financeVerificationApproval;
	}
	public void setFinanceVerificationApproval(boolean financeVerificationApproval) {
		this.financeVerificationApproval = financeVerificationApproval;
	}
	public boolean isAdminApproval() {
		return adminApproval;
	}
	public void setAdminApproval(boolean adminApproval) {
		this.adminApproval = adminApproval;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LoanApplication [appliactionId=" + appliactionId + ", applicationDate=" + applicationDate
				+ ", loanAppliedAmount=" + loanAppliedAmount + ", loanApprovedAmount=" + loanApprovedAmount
				+ ", landVerificationApproval=" + landVerificationApproval + ", financeVerificationApproval="
				+ financeVerificationApproval + ", adminApproval=" + adminApproval + ", status=" + status + "]";
	}
	
}
