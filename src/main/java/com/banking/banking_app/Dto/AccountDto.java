package com.banking.banking_app.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class AccountDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Size(min = 2, max = 50,message="atleast two charcter should be there")
	@Column(name="account_holder_name")
	private String accountHolderName;
	
	 @NotNull(message = "Balance is required")
	 @Positive(message = "Balance must be positive")
	private double balance;
	 
	 
	 @NotNull(message = "Account number is required")
	 @Size(min = 11, max = 11, message = "Account number must be 11 digits")
	 @Pattern(regexp = "^101\\d{8}$", message = "Account number must start with 101 and be 11 digits long")
	private String accountNo;
	 
	public AccountDto(Long id, String accountHolderName, double balance,String accountNo) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.accountNo=accountNo;
	}
	
	public AccountDto() {}

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
