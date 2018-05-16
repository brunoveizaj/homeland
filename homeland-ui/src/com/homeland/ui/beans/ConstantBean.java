package com.homeland.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.homeland.ui.constants.IBorder;
import com.homeland.ui.constants.IStatus;

@ManagedBean(name="constB")
@RequestScoped
public class ConstantBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String BORDER_ENTRY = IBorder.ENTRY;
	String BORDER_EXIT = IBorder.EXIT;
	int ACTIVE = IStatus.ACTIVE;
	int NOT_ACTIVE = IStatus.NOT_ACTIVE;
	int YES = IStatus.ACTIVE;
	int NO = IStatus.NOT_ACTIVE;
	
	
	
	
	public String getBORDER_ENTRY() {
		return BORDER_ENTRY;
	}
	public void setBORDER_ENTRY(String bORDER_ENTRY) {
		BORDER_ENTRY = bORDER_ENTRY;
	}
	public String getBORDER_EXIT() {
		return BORDER_EXIT;
	}
	public void setBORDER_EXIT(String bORDER_EXIT) {
		BORDER_EXIT = bORDER_EXIT;
	}
	public int getACTIVE() {
		return ACTIVE;
	}
	public void setACTIVE(int aCTIVE) {
		ACTIVE = aCTIVE;
	}
	public int getNOT_ACTIVE() {
		return NOT_ACTIVE;
	}
	public void setNOT_ACTIVE(int nOT_ACTIVE) {
		NOT_ACTIVE = nOT_ACTIVE;
	}
	public int getYES() {
		return YES;
	}
	public void setYES(int yES) {
		YES = yES;
	}
	public int getNO() {
		return NO;
	}
	public void setNO(int nO) {
		NO = nO;
	}
	
	

}
