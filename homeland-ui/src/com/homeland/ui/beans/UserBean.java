package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.models.UserDTO;
import com.homeland.ui.services.UserService;
import com.homeland.ui.utils.Messages;


@ManagedBean
@ViewScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	UserDTO user;
	UserDTO selectedUser;
	List<UserDTO> users;

	
	
	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}


	public UserDTO getSelectedUser() {
		return selectedUser;
	}


	public void setSelectedUser(UserDTO selectedUser) {
		this.selectedUser = selectedUser;
	}


	public List<UserDTO> getUsers() {
		return users;
	}


	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}


	@PostConstruct
	public void load()
	{
		init();
	}
	
	
	private void init()
	{
		this.user = new UserDTO();
		this.selectedUser = null;
		this.users = new UserService().loadUsers();
	}
	
	public void onUserSelect()
	{
		this.user = selectedUser;
	}
	
	
	public void register()
	{
		try {
			new UserService().registerUser(user);
			init();
			Messages.throwFacesMessage("Perdoruesi u regjistrua me sukses", 1);
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}
	
	public void modify()
	{
		try {
			new UserService().modifyUser(user);
			init();
			Messages.throwFacesMessage("Perdoruesi u modifikua me sukses", 1);
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}
	
	public void clear()
	{
		init();
	}
	

}
