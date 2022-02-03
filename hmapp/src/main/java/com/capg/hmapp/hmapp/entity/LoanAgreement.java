package com.capg.hmapp.hmapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity

public class LoanAgreement {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int loanAggrementId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="L_App")
	private LoanApplication loanApplication;
	public LoanAgreement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoanAgreement(int loanAggrementId, LoanApplication loanApplicationId) {
		super();
		this.loanAggrementId = loanAggrementId;
		this.loanApplication = loanApplicationId;
	}
	public int getLoanAggrementId() {
		return loanAggrementId;
	}
	public void setLoanAggrementId(int loanAggrementId) {
		this.loanAggrementId = loanAggrementId;
	}
	public LoanApplication getLoanApplication() {
		return loanApplication;
	}
	public void setLoanApplication(LoanApplication loanApplicationId) {
		this.loanApplication= loanApplicationId;
	}
	@Override
	public String toString() {
		return "LoanAgreement [loanAggrementId=" + loanAggrementId + ", loanApplicationId=" + loanApplication + "]";
	}
	
}
