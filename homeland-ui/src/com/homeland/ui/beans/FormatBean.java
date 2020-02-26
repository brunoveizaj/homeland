package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.homeland.ui.constants.IBorder;
import com.homeland.ui.utils.DateUtil;
import com.homeland.ui.utils.StringUtil;

@ManagedBean
@RequestScoped
public class FormatBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public String formatBCE(String event)
	{
		return event.equals(IBorder.ENTRY)?"green-row":"red-row";
	}
	
	public String cropStr(String value,int size)
    {
        if(StringUtil.isValid(value) && value.length()>=size)
        {
            return value.substring(0,size)+"...";
        }
        
        return value;
    }
	
	public boolean validString(String value)
	{
		return StringUtil.isValid(value);
	}
	
	
	public String formatDate(Date d)
	{
		return DateUtil.formatDate(d);
	}
	
	public String formatTimestamp(Date d)
	{
		return DateUtil.formatTimestamp(d);
	}
	
	

}
