package com.homeland.ui.beans;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.homeland.ui.services.ZrppService;
import com.homeland.ui.utils.StringUtil;


@ManagedBean
@ApplicationScoped
public class PdfBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	
	public StreamedContent getPdfCartel() throws IOException
	{
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE)
		{
			return new DefaultStreamedContent();
		}
		
		try {
			
			String propId = context.getExternalContext().getRequestParameterMap().get("property_id");
			if(!StringUtil.isValid(propId))
			{
				return new DefaultStreamedContent();
			}
			
			String base64 = new ZrppService().getPropertyCartel(propId).getData();
			
			byte[] imgByte = Base64.getMimeDecoder().decode(base64);
			
			
			return new DefaultStreamedContent(new ByteArrayInputStream(imgByte));
			
		}catch(NullPointerException e)
		{
			return new DefaultStreamedContent();
		}
		
		
		
	}
	
	
	public StreamedContent getPdfMap() throws IOException
	{
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE)
		{
			return new DefaultStreamedContent();
		}
		
		try {
			
			String propId = context.getExternalContext().getRequestParameterMap().get("property_id");
			if(!StringUtil.isValid(propId))
			{
				return new DefaultStreamedContent();
			}
			
			String base64 = new ZrppService().getPropertyMap(propId).getData();
			
			byte[] imgByte = Base64.getMimeDecoder().decode(base64);
			
			
			return new DefaultStreamedContent(new ByteArrayInputStream(imgByte));
			
		}catch(NullPointerException e)
		{
			return new DefaultStreamedContent();
		}
		
		
		
	}
	
	
	
	
	

}
