package com.homeland.ui.beans;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.homeland.ui.constants.IDocument;
import com.homeland.ui.criterias.PhotoRequest;
import com.homeland.ui.models.PhotoDTO;
import com.homeland.ui.services.DocumentService;
import com.homeland.ui.utils.PhotoUtil;

@ManagedBean
@ApplicationScoped
public class PhotoBean {

		
	public StreamedContent getCardImage() throws IOException
	{
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		if(ctx.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE)
		{
			return new DefaultStreamedContent();
		}
		
		String idn = ctx.getExternalContext().getRequestParameterMap().get("idc");
		PhotoRequest req = new PhotoRequest(idn, IDocument.CARD);
		PhotoDTO image = new DocumentService().getDocumentPhoto(req);
		byte[] imgByte;
		if(image == null)
		{
			imgByte = null;
		}
		else
		{
			imgByte = image.getPhoto();
		}
		try {
			return new DefaultStreamedContent(new ByteArrayInputStream(imgByte));
		}catch(NullPointerException np)
		{
			return new DefaultStreamedContent();
		}
	}
	
	public StreamedContent getPassportImage() throws IOException
	{
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		if(ctx.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE)
		{
			return new DefaultStreamedContent();
		}
		
		String idn = ctx.getExternalContext().getRequestParameterMap().get("idp");
		PhotoRequest req = new PhotoRequest(idn, IDocument.PASSPORT);
		PhotoDTO image = new DocumentService().getDocumentPhoto(req);
		byte[] imgByte;
		if(image == null)
		{
			imgByte = Base64.getDecoder().decode(PhotoUtil.NO_IMAGE);
		}
		else
		{
			imgByte = Base64.getDecoder().decode(PhotoUtil.NO_IMAGE);
		}
		try {
			return new DefaultStreamedContent(new ByteArrayInputStream(imgByte));
		}catch(NullPointerException np)
		{
			return new DefaultStreamedContent();
		}
	}
	
	
}
