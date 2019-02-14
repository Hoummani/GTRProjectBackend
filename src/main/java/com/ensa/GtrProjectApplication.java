package com.ensa;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ensa.entity.AppRole;
import com.ensa.service.AccountService;

@SpringBootApplication
public class GtrProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtrProjectApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(AccountService accountService) {
		return args->{
			accountService.save(new AppRole("USER"));
			accountService.save(new AppRole("ADMIN"));
			Stream.of("user1","user2","user3","admin").forEach(u->{
				accountService.saveUser(u, "1234", "1234");
			});
			accountService.addRoleToUser("admin", "ADMIN");
		};
	}
	
	@Bean
	BCryptPasswordEncoder getBCrypt() {
		return new BCryptPasswordEncoder();
	}
	

}

