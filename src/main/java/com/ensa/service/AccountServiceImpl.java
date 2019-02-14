package com.ensa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ensa.dao.AppRoleRepository;
import com.ensa.dao.AppUserRepository;
import com.ensa.entity.AppRole;
import com.ensa.entity.AppUser;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private AppRoleRepository appRoleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public AppUser saveUser(String username, String password, String confirmedPassword) {
		
		
		AppUser user=appUserRepository.findUserByUsername(username);
		
		if(user!=null) throw new RuntimeException("User already exists !");
		if(!password.equals(confirmedPassword)) throw new RuntimeException("Please check your password ! !");
		
		AppUser appUser=new AppUser();
		appUser.setUsername(username);
		appUser.setActivated(true);
		appUser.setPassword(bCryptPasswordEncoder.encode(password));
		
		appUserRepository.save(appUser);
		addRoleToUser(username, "USER");
		return appUser;
	}

	@Override
	public AppRole save(AppRole role) {
		
		return appRoleRepository.save(role);
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		
		return appUserRepository.findUserByUsername(username);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppUser appUser=appUserRepository.findUserByUsername(username);
		AppRole appRole=appRoleRepository.findRoleByRoleName(roleName);
		appUser.getRoles().add(appRole);
		
	}

}
