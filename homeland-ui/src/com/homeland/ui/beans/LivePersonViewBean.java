package com.homeland.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.models.live.LiveData;
import com.homeland.ui.models.live.LivePersonRaportDTO;
import com.homeland.ui.services.LiveRaportService;
import com.homeland.ui.utils.Messages;

import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
@Getter @Setter
public class LivePersonViewBean implements Serializable {

	private static final long serialVersionUID = 8544975675733910003L;
	
	@ManagedProperty("#{nav}")
	NavigationBean nav;
	
	String nid;
	
	LivePersonRaportDTO liveRaport;
	LiveData live = null;
	
	public void init()
	{		
		nid = nav.getParam("nid");	
		
		System.err.println(nid);
		
		loadLivePersonRaport(nid);	
	}
	
	
	public void loadLivePersonRaport(String nid)
	{
		try {
				liveRaport = new LiveRaportService().getLiveRaport("P", nid);
				
				System.out.println(liveRaport);
				
				if(liveRaport.isHasData())
				{
					System.out.println("HAS DATA");
					
					try {
							ObjectMapper om = new ObjectMapper();
							live = om.readValue(liveRaport.getDataJson(), LiveData.class);
							liveRaport.setDataJson(null);
							if(live != null)
							{
								
								liveRaport.setDataJson(null);
							}
						}catch(Exception e) 
						{e.printStackTrace();}
					
				 }
				else {
				System.err.println("NO DATA");
				}
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}
	
	
	
	public void requestLiveRaport()
	{
		try {
			
			new LiveRaportService().addRequest("P", nid);
			
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}
	
	public void cancelRequestRaport()
	{
		try {
			
			new LiveRaportService().cancelRequest(this.liveRaport.getLastRaportId());
			
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}
	

}
