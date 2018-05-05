package com.homeland.ui.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class Messages {

	public static void throwMessageInDialog(String message,int severity)
    {
        switch (severity)
        {
            case 1: RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", message));
                break;
            case 2: RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_WARN, "Kujdes", message));
                break;
            case 3: RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", message));
                break;
            case 4: RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_FATAL, "Gabim", message));       
        }
        
    }
    
    
    public static void throwFacesMessage(String message,int severity)
    {
         switch (severity)
        {
            case 1: FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", message));
                break;
            case 2: FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Kujdes", message));
                break;
            case 3: FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", message));
                break;
            case 4: FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Gabim", message));       
        }
    }
	
	
}
