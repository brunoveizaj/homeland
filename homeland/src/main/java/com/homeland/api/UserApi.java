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
import com.homeland.exceptions.EntityExistsException;
import com.homeland.exceptions.NoContentException;
import com.homeland.exceptions.NotFoundException;
import com.homeland.models.Principal;
import com.homeland.models.UserToken;
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
	public ResponseEntity<?> searchUser(@RequestHeader(value="Authorization") String token, UserRequest req)
	{
		Integer userId = tokenService.getUserIdFromToken(token);
				
		List<UserDTO> list = userService.searchUser(req,userId);
		
		if(list == null || list.isEmpty())
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/uname/{username}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getUserByUsername(@RequestHeader(value="Authorization") String token, @PathVariable String username)
	{
        Integer userId = tokenService.getUserIdFromToken(token);
		
		UserDTO user = userService.findUserByUsername(username,userId);
		
		if(user == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/id/{userId}", method=RequestMethod.GET, produces={"application/json"})
	public ResponseEntity<?> getUserByUsername(@RequestHeader(value="Authorization") String token, @PathVariable Integer userId)
	{
		Integer authUserId = tokenService.getUserIdFromToken(token);
		
		UserDTO user = userService.findUserById(userId,authUserId);
		
		if(user == null)
		{
			return new ResponseEntity<>("Nuk ka te dhena",HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?>registerUser(@RequestHeader(value="Authorization") String token, @RequestBody UserDTO payload)
	{
		try {
		Integer userId = tokenService.getUserIdFromToken(token);
		
		UserDTO u = userService.registerUser(payload, userId);
		
		return new ResponseEntity<>(u,HttpStatus.OK);
		
		}catch(NoContentException | EntityExistsException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST, produces={"application/json"})
	public ResponseEntity<?>modifyUser(@RequestHeader(value="Authorization") String token, @RequestBody UserDTO payload)
	{
				
		try {
		Integer userId = tokenService.getUserIdFromToken(token);
		
		UserDTO u = userService.modifyUser(payload, userId);
		
		return new ResponseEntity<>(u,HttpStatus.OK);
		}catch(NoContentException | EntityExistsException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> login(@RequestBody Principal principal)
	{
		try {
		UserToken ut = userService.login(principal);
		return new ResponseEntity<>(ut, HttpStatus.OK);
		}catch(NotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
