package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
	
	private final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	private final AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping("/updateAccount/{id}")
    public void updateAccount(@PathVariable("id") Integer id) throws InterruptedException {
		logger.info(" :: UPDATE ACCOUNT ::");
        accountService.updateAccount(id,100);
    }

    @PostMapping("/updateAccountViaDistributedLocks/{id}")
    public void updateAccountViaDistributedLocks(@PathVariable("id") Integer id) throws InterruptedException {
    	logger.info(" :: UPDATE ACCOUNT VIA DISTRIBUTED LOCK ::");
        accountService.updateAccountViaDistributedLock(id,100);
    }

}
