package com.example.demo_transactional.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_transactional.entity.Account;
import com.example.demo_transactional.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		Account savedAccount = accountService.saveAccount(account);
		return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
	}
	
	@PatchMapping("/{fromId}/{toId}/{amount}")
	public ResponseEntity<String> transfer(
			@PathVariable int fromId,
			@PathVariable int toId,
			@PathVariable double amount){
		String message = accountService.transfer(fromId, toId, amount);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Page<Account>> getAllAccounts(Pageable pageable){
		Page<Account> page = accountService.readAccounts(pageable);
		return new ResponseEntity<>(page, HttpStatus.OK);
	}
}
