package com.homeland.ui.utils;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.homeland.ui.beans.LoginBean;

public class Util {

	
	public static String getParam(String param)
	{
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(param);
	}
	
	public static HttpSession getSession() {
        try{
        return (HttpSession) FacesContext.
                getCurrentInstance().
                getExternalContext().
                getSession(false);
        }catch(Exception e){System.err.println("Faces Context eshte null:\n"+e.getMessage());
        return null;}
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.
                getCurrentInstance().
                getExternalContext().getRequest();
    }
    
    public static HttpServletResponse getResponse() {
        return (HttpServletResponse) FacesContext.
                getCurrentInstance().
                getExternalContext().getResponse();
    }
    
    public static String getToken()
    {
    	HttpSession ses = getSession();
    	LoginBean login = (LoginBean) ses.getAttribute("loginBean");
		if(login != null && login.getUserToken() != null)
		{
			return login.getUserToken().getToken();
		}
		
		return null;
    }

    /*
    public static User getUser() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            return (User) session.getAttribute("user");
        }

        return null;
    }
*/
    public static String getAuthenticatedUserIp() {
        HttpServletRequest request
                = (HttpServletRequest) FacesContext.getCurrentInstance().
                getExternalContext().
                getRequest();

        String ip = request.getHeader("X-Forwarded-For");
        
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_VIA");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    public static String getBrowser() {
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    String userAgent = externalContext.getRequestHeaderMap().get("User-Agent");

    if(userAgent.contains("MSIE")){ 
        return "Internet Explorer";
    }
    if(userAgent.contains("Firefox")){ 
        return "Firefox";
    }
    if(userAgent.contains("Chrome")){ 
        return "Chrome";
    }
    if(userAgent.contains("Opera")){ 
        return "Opera";
    }
    if(userAgent.contains("Safari")){ 
        return "Safari";
    }
    return "Unknown";
}
    
    public static String getViewId()
    {
        return FacesContext.getCurrentInstance().getViewRoot().getViewId();
    }

    public static String boundleMsg(String keyMsg)
    {
        String msg = null;
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            Application app = context.getApplication();
            ResourceBundle bundle = app.getResourceBundle(context, "msg");
            msg = bundle.getString(keyMsg);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return msg;
    }
    
    public static void redirect(String path) {
       ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
            try {
                ext.redirect(ext.getRequestContextPath() +"/"+ path);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
    
    
    
    public static String getRootPath()
    {
        ExternalContext ext = FacesContext.getCurrentInstance().getExternalContext();
        return ext.getRequestContextPath();
    }
	
	
}
