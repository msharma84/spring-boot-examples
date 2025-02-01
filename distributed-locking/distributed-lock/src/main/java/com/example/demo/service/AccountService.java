package com.example.demo.service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.repo.AccountRepository;

@Service
public class AccountService {
	
	private final Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	private final AccountRepository accountRepository;
    private final LockRegistry lockRegistry;
    
	public AccountService(AccountRepository accountRepository, LockRegistry lockRegistry) {
		this.accountRepository = accountRepository;
		this.lockRegistry = lockRegistry;
	}

	private ReentrantLock lock = new ReentrantLock();
	
	public void updateAccount(Integer id, Integer amount) {
		
		boolean lockAcquired = lock.tryLock();
		logger.info("Acquired Lock - {}",lockAcquired);
		if(lockAcquired) {
			try {
				Optional<Account> optAccount = accountRepository.findById(id);
				if(optAccount.isPresent()) {
					Account account = optAccount.get();
					account.setBalance(account.getBalance() + amount);
					TimeUnit.MILLISECONDS.sleep(1000);
					accountRepository.save(account);
				}
			}catch(InterruptedException ire) {
				Thread.currentThread().interrupt();
			}finally {
				lock.unlock();
			}
		}
	}
	
	public void updateAccountViaDistributedLock(Integer id, Integer amount) {
		
		Lock lock = lockRegistry.obtain(String.valueOf(id));
		
		boolean lockAcquired = lock.tryLock();
		logger.info("Acquired Distributed Lock - {}",lockAcquired);
		if(lockAcquired) {
			try {
				Optional<Account> optAccount = accountRepository.findById(id);
				if(optAccount.isPresent()) {
					Account account = optAccount.get();
					account.setBalance(account.getBalance() + amount);
					TimeUnit.MILLISECONDS.sleep(1000);
					accountRepository.save(account);
				}
			}catch(InterruptedException ire) {
				Thread.currentThread().interrupt();
			}finally {
				lock.unlock();
			}
		}
	}
    
}
