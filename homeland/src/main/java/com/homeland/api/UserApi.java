package com.homeland.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homeland.dto.UserDTO;
import com.homeland.exceptions.NoContentException;
import com.homeland.requests.api.UserRequest;
import com.homeland.services.TokenService;
import com.homeland.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserApi {

	
	@Autowired
	UserService userService;
	@Autowired 
	TokenService tokenService;
	
	
	@RequestMapping(value="/searchUser", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> searchUser(@RequestHeader(value="Authorization",required=false) String token, UserRequest req)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
		System.err.println("AUTH USER_ID: "+userId);
		
		System.err.println(req);
		
		List<UserDTO> list = userService.searchUser(req);
		
		if(list == null || list.isEmpty())
		{
			throw new NoContentException("Nuk ka te dhena");
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/uname/{username}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getUserByUsername(@RequestHeader(value="Authorization",required=false) String token, @PathVariable String username)
	{
        Integer userId = tokenService.getUserIdFromToken(token);
		System.err.println("AUTH USER_ID: "+userId);
		
		System.err.println(username);
		
		UserDTO user = userService.findUserByUsername(username);
		
		if(user == null)
		{
			throw new NoContentException("Nuk ka te dhena");
		}
		
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/id/{userId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getUserByUsername(@RequestHeader(value="Authorization",required=false) String token, @PathVariable Integer userId)
	{
		Integer authUserId = tokenService.getUserIdFromToken(token);
		System.err.println("AUTH USER_ID: "+authUserId);
		
		UserDTO user = userService.findUserById(userId);
		
		if(user == null)
		{
			throw new NoContentException("Nuk ka te dhena");
		}
		
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?>registerUser(@RequestHeader(value="Authorization",required=false) String token, @RequestBody UserDTO payload)
	{
				
		Integer userId = tokenService.getUserIdFromToken(token);
		
		UserDTO u = userService.registerUser(payload, userId);
		
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?>modifyUser(@RequestHeader(value="Authorization",required=false) String token, @RequestBody UserDTO payload)
	{
				
		Integer userId = tokenService.getUserIdFromToken(token);
		
		UserDTO u = userService.modifyUser(payload, userId);
		
		return new ResponseEntity<>(u,HttpStatus.OK);
	}
	
	
	
	
}
