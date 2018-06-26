package com.homeland.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.homeland.ui.constants.IBorder;

@ManagedBean
@RequestScoped
public class FormatBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public String formatBCE(String event)
	{
		return event.equals(IBorder.ENTRY)?"green-lbl":"red-lbl";
	}
	
	

}
