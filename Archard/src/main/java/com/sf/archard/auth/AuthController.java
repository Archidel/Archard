package com.sf.archard.auth;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sf.archard.auth.model.LoginRequest;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

	@PostMapping("/signin")
	public void authenticateUser(@Valid @RequestBody LoginRequest loginRequest, HttpServletResponse response) /*throws AuthenticationServiceException*/ {
		log.debug("authenticateUser {}", loginRequest.getUsernameOrEmail()); 
		System.out.println(loginRequest.getUsernameOrEmail());
		
//		authenticationService.authenticate(loginRequest.getUsernameOrEmail(), loginRequest.getPassword(), response);		
	}
	
	@PostMapping("/signout")
	public void signout() {
		log.debug("signout");
		
		
		
//		SecurityContextHolder.getContext().setAuthentication(null);
	}
	
}
