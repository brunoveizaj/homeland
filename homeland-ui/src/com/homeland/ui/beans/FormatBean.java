package com.homeland.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.homeland.ui.constants.IBorder;
import com.homeland.ui.utils.StringUtil;

@ManagedBean
@RequestScoped
public class FormatBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public String formatBCE(String event)
	{
		return event.equals(IBorder.ENTRY)?"green-row":"red-row";
	}
	
	public boolean validString(String value)
	{
		return StringUtil.isValid(value);
	}

}
