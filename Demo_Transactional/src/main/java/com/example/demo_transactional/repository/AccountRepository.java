package com.example.demo_transactional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_transactional.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
