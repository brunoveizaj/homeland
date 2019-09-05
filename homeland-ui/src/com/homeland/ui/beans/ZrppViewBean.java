package com.homeland.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.models.PropertyDTO;
import com.homeland.ui.services.ZrppService;
import com.homeland.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class ZrppViewBean  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty("#{nav}")
	NavigationBean nav;
	
	
	PropertyDTO property;


	public NavigationBean getNav() {
		return nav;
	}


	public void setNav(NavigationBean nav) {
		this.nav = nav;
	}


	public PropertyDTO getProperty() {
		return property;
	}


	public void setProperty(PropertyDTO property) {
		this.property = property;
	}
	
	
	
	public void init()
	{
		String zk = nav.getParam("zk");
		String vol = nav.getParam("vol");
		String page = nav.getParam("page");
		try {
			this.property = new ZrppService().getProperty(zk, vol, page);
			if(this.property == null)
			{
				Messages.throwFacesMessage("Prona nuk u gjet", 3);
			}
			
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}
	
	
	
	
	

}
