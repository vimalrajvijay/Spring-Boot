package com.example.demo_transactional.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_transactional.entity.Account;
import com.example.demo_transactional.repository.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}
	
	@Transactional
	public String transfer(int fromId, int toId, double amount) {
		Account account1 = accountRepository.findById(fromId).get();
		Account account2 = accountRepository.findById(toId).get();
		
		account1.setBalance(account1.getBalance()-amount);
		accountRepository.save(account1);	
		if(true) {
			throw new RuntimeException("Network Issue");
		}
		account2.setBalance(account2.getBalance()+amount);
		accountRepository.save(account2);
		
		return "Transaction Successful";
	}
	
	public Page<Account> readAccounts(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}
}
