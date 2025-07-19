package com.banking.banking_app.mapper;

import com.banking.banking_app.Dto.AccountDto;
import com.banking.banking_app.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountDto) {
		Account account=new Account(
				accountDto.getId(),accountDto.getAccountHolderName(),accountDto.getBalance(),accountDto.getAccountNo()
				);
		return account;
		
	}

	
	public static AccountDto mapToAccount(Account account) {
		AccountDto accountDto=new AccountDto(
				account.getId(),account.getAccountHolderName(),account.getBalance(),account.getAccountNo()
				);
		return accountDto;
		
	}
}
