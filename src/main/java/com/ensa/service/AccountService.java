package com.ensa.service;

import com.ensa.entity.AppRole;
import com.ensa.entity.AppUser;

public interface AccountService {

	
	public AppUser saveUser(String username, String password, String confirmedPassword);
	public AppRole save(AppRole role);
	public AppUser loadUserByUsername(String username);
	public void addRoleToUser(String username, String roleName);
}
