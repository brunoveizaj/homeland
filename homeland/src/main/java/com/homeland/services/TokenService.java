package com.homeland.services;

import org.springframework.stereotype.Service;

import com.homeland.dto.UserDTO;
import com.homeland.security.TokenUtil;

@Service
public class TokenService {

	
	public boolean isValid(String token)
	{
		return true;
	}
	
	
	public String generateToken(UserDTO dto)
	{
		return TokenUtil.generateToken(dto);
	}
	
	public Integer getUserIdFromToken(String token)
	{
		return TokenUtil.getUserId(token);
	}
	
	public String getUsernameFromToken(String token)
	{
		return TokenUtil.getUsername(token);
	}
	
	
	
	
}
