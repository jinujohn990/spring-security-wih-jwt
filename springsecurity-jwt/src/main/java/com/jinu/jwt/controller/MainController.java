package com.jinu.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinu.jwt.dto.request.GenerateJwtTokenRequest;
import com.jinu.jwt.serviceimpl.JwtUtil;

@Controller
public class MainController {
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "You are authenticated...";
	}
	
    @PostMapping("/authenticate")
	public String generateJwtToken(@RequestBody GenerateJwtTokenRequest request) throws Exception {
    	try {
    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    	}catch (Exception e) {
    		 throw new Exception("inavalid username/password");
		}
    	
    	return jwtUtil.generateToken(request.getUsername());
    }
}
