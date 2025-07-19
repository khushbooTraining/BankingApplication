package com.banking.banking_app.service.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.banking.banking_app.Dto.AccountDto;
import com.banking.banking_app.entity.Account;
import com.banking.banking_app.exception.AccountNotFound;
import com.banking.banking_app.mapper.AccountMapper;
import com.banking.banking_app.repository.AccountRepository;
import com.banking.banking_app.service.AccountService;



@Service
public class AccountServiceImpl implements AccountService{
       
	private AccountRepository accountRepository;
	
	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override//convert dto into jpaentity and then jpaentity to database
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=AccountMapper.mapToAccount(accountDto);
		Account saveaccount=accountRepository.save(account);
		
		return AccountMapper.mapToAccount(saveaccount);
	}

	@Override
	public AccountDto getAccountHolderDetailById(long id) {
		Account d=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account doesnot exist"));
		return AccountMapper.mapToAccount(d);
	}

	@Override
	@Cacheable("GetAccount")
	public List<AccountDto> getAllAccountDetail(int no,int size) {

		Page<Account> dc=accountRepository.findAll(PageRequest.of(no, size));
		List<Account> dd=dc.getContent();
		return dd.stream().map((d)->AccountMapper.mapToAccount(d)).collect(Collectors.toList()) ;
	}

	@Override
	public AccountDto deposite(long id,double balance) {
		Account ac=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account doesnot exist"));
		double dd=ac.getBalance()+balance;
		ac.setBalance(dd);
		Account saved=	accountRepository.save(ac);
		return AccountMapper.mapToAccount(saved);
	}

	@Override
	public AccountDto withdraw(long id, double balance) {
		Account aa=accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account doesnot exist"));
		
		if(aa.getBalance()<balance) {
			throw new RuntimeException("Insufficient balance");
		}
		double dd=aa.getBalance()-balance;
		aa.setBalance(dd);
		Account a=accountRepository.save(aa);
		return AccountMapper.mapToAccount(a);
	}

	@Override
	public AccountDto getAccountDetailByAccount(String id) {
		Account a=accountRepository.findByAccountNo(id).orElseThrow(()->new AccountNotFound("this account are not found ,please try with account Number again"));
		return AccountMapper.mapToAccount(a);
	}

}
