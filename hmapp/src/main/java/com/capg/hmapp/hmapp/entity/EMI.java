package com.capg.hmapp.hmapp.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

@Entity

public class EMI {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int EMIId;
	
	@Temporal(value=TemporalType.DATE)
	private Date dueDate;
	@Min(value=100,message="Minimum value for emiAmount should be 100  ")
	private double emiAmount;
	@Min(value=100,message="Minimum value for loanAmount should be 100  ")

	private double loanAmount;
	@Min(value=10,message="Minimum value for interestAmount should be 10  ")

	private double interestAmount;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="L_A")
	private LoanAgreement loanAggrement;
	public EMI() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EMI(int eMIId, Date dueDate, double emiAmount, double loanAmount, double interestAmount,
			LoanAgreement loanAggrement) {
		super();
		EMIId = eMIId;
		this.dueDate = dueDate;
		this.emiAmount = emiAmount;
		this.loanAmount = loanAmount;
		this.interestAmount = interestAmount;
		this.loanAggrement = loanAggrement;
	}
	public int getEMIId() {
		return EMIId;
	}
	public void setEMIId(int eMIId) {
		EMIId = eMIId;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public double getEmiAmount() {
		return emiAmount;
	}
	public void setEmiAmount(double emiAmount) {
		this.emiAmount = emiAmount;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getInterestAmount() {
		return interestAmount;
	}
	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}
	public LoanAgreement getLoanAggrement() {
		return loanAggrement;
	}
	public void setLoanAggrement(LoanAgreement loanAggrement) {
		this.loanAggrement = loanAggrement;
	}
	@Override
	public String toString() {
		return "EMI [EMIId=" + EMIId + ", dueDate=" + dueDate + ", emiAmount=" + emiAmount + ", loanAmount="
				+ loanAmount + ", interestAmount=" + interestAmount + ", loanAggrement=" + loanAggrement + "]";
	}
	
}
