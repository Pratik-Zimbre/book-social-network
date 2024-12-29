/*
 * This code is part of the book-social-network project.
 * Use of this code anywhere without the project owner's (https://github.com/Pratik-Zimbre) permission is prohibited.
 */
package com.personal.book.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personal.book.repository.BsnUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final BsnUserRepository repository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return repository.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}

}
