package com.homeland.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.homeland.ui.utils.Util;


@ManagedBean
@RequestScoped
public class MenuBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value="#{nav}")
	NavigationBean nav;
	

	
	public NavigationBean getNav() {
		return nav;
	}
	
	public void setNav(NavigationBean nav) {
		this.nav = nav;
	}

	
	
	public void navigate(String page)
	{
		nav.navigate(page);
		Util.redirect("sec/main");
	}
	

}
