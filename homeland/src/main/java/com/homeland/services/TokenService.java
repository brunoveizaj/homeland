package com.homeland.services;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

	
	public boolean validateToken(String token)
	{
		return true;
	}
	
	public Integer getUserIdFromToken(String token)
	{
		return 1;
	}
	
	
	
	
}
