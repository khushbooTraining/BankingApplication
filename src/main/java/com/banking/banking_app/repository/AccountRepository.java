package com.banking.banking_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.banking_app.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{
	Optional<Account> findByAccountNo(String accountNo);
}
