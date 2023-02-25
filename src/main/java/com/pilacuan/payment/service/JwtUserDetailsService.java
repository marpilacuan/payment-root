package com.pilacuan.payment.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	public static final String USER_NAME = "mpilacuan";
	public static final String USER_PASS = "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (USER_NAME.equals(username)) {
			return new User(USER_NAME, USER_PASS, new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
