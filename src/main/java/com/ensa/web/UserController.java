package com.ensa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ensa.entity.AppUser;
import com.ensa.service.AccountService;

import lombok.Data;

@RestController
public class UserController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/register")
	public AppUser register(@RequestBody UserForm userForm) {
		return accountService.saveUser(userForm.getUsername(), userForm.getPassword(), userForm.getCpnfirmedPassword());
	}

}

@Data
class UserForm{
	private String username;
	private String password;
	private String cpnfirmedPassword;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpnfirmedPassword() {
		return cpnfirmedPassword;
	}
	public void setCpnfirmedPassword(String cpnfirmedPassword) {
		this.cpnfirmedPassword = cpnfirmedPassword;
	}
	
}
