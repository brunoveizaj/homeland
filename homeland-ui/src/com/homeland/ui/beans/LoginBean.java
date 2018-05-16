package com.homeland.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.homeland.ui.models.UserToken;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String username;
	String password;
	
	UserToken userToken;
	
	
	public void login()
	{
		
	}
	
	public void logout()
	{
		
	}
	

}
