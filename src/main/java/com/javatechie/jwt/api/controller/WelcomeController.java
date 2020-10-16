package com.javatechie.jwt.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.jwt.api.entity.AuthRequest;
import com.javatechie.jwt.api.util.JwtTokenUtil;

@RestController
public class WelcomeController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/")
	public String welcome() {
		return "Welcome to Javatechie";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception e) {

			throw new Exception("Invalid Username and Password");
		}

		return jwtTokenUtil.generateToken(authRequest.getUserName());
	}
}
