package com.homeland.ui.beans;

import java.io.Serializable;

import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@ViewScoped
public class PersonViewBean implements Serializable {

	private static final long serialVersionUID = 8544975675733910003L;
	
	@ManagedProperty("#{nav}")
	NavigationBean nav;
	

	
	public void init()
	{
		if(FacesContext.getCurrentInstance().isPostback())
		{
			System.out.println("POSTBACKKKKK");
		}
		else
		{
			System.out.println("NOOOOOOO    POSTBACKKKKK");
		}
		
		String nid = nav.getParam("nid");
		System.out.println("VIEW PARAM # init() : NID="+nid);
	}
	
	
	

}
