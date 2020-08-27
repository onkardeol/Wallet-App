package com.example.wallet;

import java.math.BigDecimal;

import com.example.wallet.entity.Currency;
import com.example.wallet.domain.CurrencyRepository;
import com.example.wallet.entity.User;
import com.example.wallet.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WalletApplication {

	@Autowired 
	private CurrencyRepository currencyRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(WalletApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {

			userRepository.save(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG")); // Pass is admin encrypted
			userRepository.save(new User("admin2", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG"));
		};
	}

}
