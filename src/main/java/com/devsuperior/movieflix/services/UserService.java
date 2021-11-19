package com.devsuperior.movieflix.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	private Logger logger = LoggerFactory.getLogger(UserDetailsService.class);

	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public User getProfile(String email) {
		return repository.findByEmail(email);
	}
	
	@Transactional(readOnly = true)
	public User findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		
		if(user == null) {
			logger.error("Email not found: " + username);
			throw new UsernameNotFoundException("Error");
		}
		logger.info("Email found: " + username);
		return user;
	}
}
