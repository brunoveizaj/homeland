package com.homeland.security;

import java.util.Calendar;

import com.homeland.dto.UserDTO;
import com.homeland.utils.StringUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

public class TokenUtil {

	public static String getUsername(String token)
	{
		if(!StringUtil.isValid(token))
		{
			return null;
		}
		
		String jwt = token.substring(7);
		Claims claims = Jwts.parser().setSigningKey(TextCodec.BASE64.decode(SecurityConstants.SECRET))
			       .parseClaimsJws(jwt).getBody();
			    
		return claims.getSubject();
	}
	
	public static Integer getUserId(String token)
	{
		if(!StringUtil.isValid(token))
		{
			return null;
		}
		
		String jwt = token.substring(7);
		Claims claims = Jwts.parser().setSigningKey(TextCodec.BASE64.decode(SecurityConstants.SECRET))
			       .parseClaimsJws(jwt).getBody();
			    
		return claims.get("u_id", Integer.class);
	}
	
	
	
	public static String generateToken(UserDTO user)
	{
		String jws = Jwts.builder()
				  .setIssuer("Homeland")
				  .setSubject(user.getUsername())
				  .claim("u_id", user.getId())
				  .setIssuedAt(Calendar.getInstance().getTime())
				//  .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
				  .signWith(
				    SignatureAlgorithm.HS256,
				    TextCodec.BASE64.decode(SecurityConstants.SECRET)
				  )
				  .compact();
		
		return jws;
	}
	
}
