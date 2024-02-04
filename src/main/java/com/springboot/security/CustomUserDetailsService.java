package com.springboot.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.entity.Userdetails;
import com.springboot.repositry.Userrepositry;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
	Userrepositry ur;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

		Userdetails u = ur.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("Username or email doesnot exists"));

		Set<GrantedAuthority> authorities = u.getRoles().stream()
		        .map((role) -> new SimpleGrantedAuthority(role.getRole_name()))
		        .collect(Collectors.toSet());

		return new User(usernameOrEmail,
                u.getPassword(),
                authorities);

	}

}
