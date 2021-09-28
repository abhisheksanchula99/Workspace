package com.example.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.model.AuthenticationRequest;
import com.example.springsecurity.model.AuthenticationResponse;

@RestController
public class AdminResource {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/admin")
	private ResponseEntity<?> adminClient(@RequestBody AuthenticationRequest authenticationRequest ){
			
		String username= authenticationRequest.getUsername(); 
		String password= authenticationRequest.getPassword();
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

			
		} catch (BadCredentialsException e) {
			// TODO: handle exception
			return ResponseEntity.ok(new AuthenticationResponse("Invalid Credentials"));

		}
		
		
		
		return ResponseEntity.ok(new AuthenticationResponse("Credentials validated successfully"));
		
	}
	
			

		


}