package com.devsuperior.movieflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.services.AuthService;
import com.devsuperior.movieflix.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthService authService;
	
	@GetMapping(path = "/profile")
	public ResponseEntity<User> getProfile(){
		
		User user = authService.authenticated();
		
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id){
		return ResponseEntity.ok().body(userService.findById(id));
	}
}
