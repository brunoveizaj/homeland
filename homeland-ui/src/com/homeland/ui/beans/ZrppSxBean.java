package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.criterias.ZrppRequest;
import com.homeland.ui.models.Param;
import com.homeland.ui.models.PropertyDTO;
import com.homeland.ui.services.ZrppService;
import com.homeland.ui.utils.Messages;
import com.homeland.ui.utils.StringUtil;

@ManagedBean
@ViewScoped
public class ZrppSxBean implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@ManagedProperty("#{nav}")
	NavigationBean nav;
	
	ZrppRequest request;
	
	
	List<PropertyDTO> properties;
	PropertyDTO property;
	
	
	
	public NavigationBean getNav() {
		return nav;
	}
	public void setNav(NavigationBean nav) {
		this.nav = nav;
	}
	public ZrppRequest getRequest() {
		return request;
	}
	public void setRequest(ZrppRequest request) {
		this.request = request;
	}
	public List<PropertyDTO> getProperties() {
		return properties;
	}
	public void setProperties(List<PropertyDTO> properties) {
		this.properties = properties;
	}
	public PropertyDTO getProperty() {
		return property;
	}
	public void setProperty(PropertyDTO property) {
		this.property = property;
	}
	
	
	@PostConstruct
	public void load()
	{
		init();
	}
	
	
	public void init()
	{
		this.request = new ZrppRequest();
		this.property = null;
		this.properties = null;
	}
	
	public void onPropertySelect()
	{
		List<Param> params = new ArrayList<>();
		params.add(new Param("zk", property.getZk()));
		params.add(new Param("vol", property.getVolume()));
		params.add(new Param("page", property.getPage()));
		params.add(new Param("property_id", property.getPropertyId()));
		nav.navigate("zrpp_view",params);
	}
	
	public void search()
	{
		try {
			
			boolean simple = isValidSimpleSearch();
			boolean owner = isOwnerSearch();
			
			if(simple && owner)
			{
				Messages.throwFacesMessage("Kerkoni ose vetem me pronar ose vetem me te dhenat e tjera", 2);
				return;
			}
			
			if(simple)
			{
				this.properties = new ZrppService().searchProperty(request);
			}
			else if(owner)
			{
				this.properties = new ZrppService().searchPropertyByOwner(request);
			}
			else if(StringUtil.isValid(request.getSurname()))
			{
				Messages.throwFacesMessage("Plotesoni edhe Emrin", 2);
				return;
			}
			else
			{
				Messages.throwFacesMessage("Plotesoni me shume fusha kerkimi", 2);
				return;
			}
			
			if(properties == null || properties.isEmpty())
			{
				Messages.throwFacesMessage("Nuk u gjet asnje prone", 2);
			}
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
			this.properties = null;
		}
	}
	
	public void clear()
	{
		init();
	}
	
	private boolean isOwnerSearch()
	{
		return (StringUtil.isValid(request.getName()));
	}
	
	private boolean isValidSimpleSearch()
	{		
		int filled = 0;
		
		if (StringUtil.isValid(request.getZk())) {
			filled++;
		}
		if (StringUtil.isValid(request.getVol())) {
			filled++;
		}
		if (StringUtil.isValid(request.getPage())) {
			filled++;
		}
		if (StringUtil.isValid(request.getPropertyNo())) {
			filled++;
		}
		if (StringUtil.isValid(request.getRegion())) {
			filled++;
		}
		if (StringUtil.isValid(request.getStreet())) {
			filled++;
		}
		if (StringUtil.isValid(request.getCity())) {
			filled++;
		}
				
		return filled > 1;
		
	}
	
	
	
	

}
