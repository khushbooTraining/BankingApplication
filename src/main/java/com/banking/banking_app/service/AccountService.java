package com.banking.banking_app.service;

import java.util.List;

import com.banking.banking_app.Dto.AccountDto;

public interface AccountService {
	
	AccountDto createAccount(AccountDto account);
	
	AccountDto getAccountHolderDetailById(long id);
	
	List<AccountDto> getAllAccountDetail(int no,int size);
	
	AccountDto deposite(long id,double balance);
	
	AccountDto withdraw(long id,double balance);
	
	AccountDto getAccountDetailByAccount(String id);


}
