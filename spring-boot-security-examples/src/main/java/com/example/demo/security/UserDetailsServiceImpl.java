package com.example.demo.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Login;
import com.example.demo.repo.LoginRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private LoginRepo loginRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = loginRepo.findByUsername(username);
		if (login == null)
			throw new UsernameNotFoundException("UsernameNotFoundException");
		UserDetails userDetails = new User(username, login.getPassword(), true, true, true, true,
				Collections.emptyList());
		return userDetails;
	}

}
