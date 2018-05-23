package com.homeland.ui.services;

import com.homeland.ui.api.clients.UserClient;
import com.homeland.ui.models.Principal;
import com.homeland.ui.models.UserToken;

public class UserService {

	public UserToken login(Principal principal)
	{
		return new UserClient().login(principal);
	}
	
	
	
}
