package com.example.demo;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.jdbc.lock.DefaultLockRepository;
import org.springframework.integration.jdbc.lock.JdbcLockRegistry;
import org.springframework.integration.jdbc.lock.LockRepository;

@SpringBootApplication
public class DistributedLockApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedLockApplication.class, args);
	}
	
	@Bean
	public DefaultLockRepository DefaultLockRepository(DataSource dataSource){
	   return new DefaultLockRepository(dataSource);
	}
	
	@Bean
	public JdbcLockRegistry jdbcLockRegistry(LockRepository lockRepository){
	   return new JdbcLockRegistry(lockRepository);
	}
}
