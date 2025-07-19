package com.banking.banking_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


@Table(name="accounts")
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Size(min = 2, max = 50,message="atleast two charcter should be there")
	@Column(name="account_holder_name")
	private String accountHolderName;
	
	 @NotNull(message = "Balance is required")
	 @Positive(message = "Balance must be positive")
	private double balance;

	 @Column(name = "account_no")
	private String accountNo;
	 
	public Account(Long id, String accountHolderName, double balance,String accountNo) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.accountNo=accountNo;
	}
	
	public Account() {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	

}
