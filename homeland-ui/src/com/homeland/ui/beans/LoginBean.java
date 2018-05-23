package com.homeland.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.models.Principal;
import com.homeland.ui.models.UserToken;
import com.homeland.ui.services.UserService;
import com.homeland.ui.utils.Messages;
import com.homeland.ui.utils.StringUtil;
import com.homeland.ui.utils.Util;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{nav}")
	NavigationBean nav;
	
	String username;
	String password;
	
	UserToken userToken;
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserToken getUserToken() {
		return userToken;
	}

	public void setUserToken(UserToken userToken) {
		this.userToken = userToken;
	}
	
	public NavigationBean getNav() {
		return nav;
	}

	public void setNav(NavigationBean nav) {
		this.nav = nav;
	}

	public void login() {
		
		if(!StringUtil.isValid(username))
		{
			Messages.throwFacesMessage("Plotëso Përdoruesin", 3);
			return;
		}
		
		if(!StringUtil.isValid(password))
		{
			Messages.throwFacesMessage("Plotëso Fjalëkalimin", 3);
			return;
		}
		
		Principal principal = new Principal();
		principal.setUsername(username);
		principal.setPassword(password);
		
		try {
			
			this.userToken = new UserService().login(principal);
			
			if(userToken != null)
			{
				nav.setActualPage("person_sx_filter");
				Util.redirect("sec/main");
			}
			
		
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
			System.err.println(a.getMessage());
		}
		
		
		
	}
	

	 public String logout() {
		try {
		            HttpSession session = Util.getSession();
		            if (session != null) {
		                session.invalidate();
		            }
		            
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		return "/login.xhtml?faces-redirect=true";
	}

		
		
	

}
