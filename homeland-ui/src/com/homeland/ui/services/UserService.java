package com.homeland.ui.services;

import java.util.List;

import com.homeland.ui.api.clients.UserClient;
import com.homeland.ui.models.Principal;
import com.homeland.ui.models.UserDTO;
import com.homeland.ui.models.UserToken;

public class UserService {

	public UserToken login(Principal principal)
	{
		return new UserClient().login(principal);
	}
	
	public List<UserDTO> loadUsers()
	{
		return new UserClient().loadUsers();
	}
	
	
	public UserDTO registerUser(UserDTO user)
	{
		return new UserClient().registerUser(user);
	}
	
	public UserDTO modifyUser(UserDTO user)
	{
		return new UserClient().modifyUser(user);
	}
	
}
