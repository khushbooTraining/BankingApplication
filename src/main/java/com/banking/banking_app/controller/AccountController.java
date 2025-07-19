package com.banking.banking_app.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.banking_app.Dto.AccountDto;
import com.banking.banking_app.entity.Account;
import com.banking.banking_app.repository.AccountRepository;
import com.banking.banking_app.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping
public class AccountController {
	
	private AccountService accountService;
	//private AccountRepository accountRepository;

	@Autowired
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	/*@PostMapping("/api/account/post")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account a=accountRepository.save(account);
		//URI location=ServletUriComponentsBuilder().from
		return (ResponseEntity<Account>) ResponseEntity.created(null);
	}*/
	
	@PostMapping("/api/account/post")
	public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED) ;
		
	}
	
	@GetMapping("/api/account/get/{id}")
	public ResponseEntity<AccountDto> getAllAccountHolderDetail(@PathVariable long id) {
	AccountDto ac=	accountService.getAccountHolderDetailById(id);
		
		return new ResponseEntity<>(ac,HttpStatus.OK);
	}
	
	@GetMapping("/api/account/getAll/{pageNo}/{size}")
	public ResponseEntity<List<AccountDto>> getAllAccountDetail(@PathVariable int pageNo,@PathVariable int size) {
		List<AccountDto> ac=accountService.getAllAccountDetail(pageNo,size);
		return new ResponseEntity<>(ac,HttpStatus.OK);
		
	}

	@PutMapping("/api/account/deposite/{id}")
	public ResponseEntity<AccountDto> deposite(@Valid @PathVariable long id, @Valid @RequestBody Map<String,Double> amount) {
		AccountDto ad=accountService.deposite(id, amount.get("amount"));
		return new ResponseEntity<>(ad,HttpStatus.OK);
		
	}
	
	@PutMapping("/api/account/withdraw/{id}")
	public ResponseEntity<AccountDto> withdraw(@Valid @PathVariable long id, @Valid @RequestBody Map<String,Double> amount) {
		AccountDto dd=accountService.withdraw(id, amount.get("amount"));
		return new ResponseEntity<>(dd,HttpStatus.OK);
		
	}
	
	@PostMapping("/getAccount/accountno")
	public ResponseEntity<AccountDto> getAccountDetailByAccount(@RequestBody @Valid Map<String,String> accountNo) {
		AccountDto ad=accountService.getAccountDetailByAccount(accountNo.get("accountno"));
		return new ResponseEntity<AccountDto>(ad,HttpStatus.OK);
		
	}
}
