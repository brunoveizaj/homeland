package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.homeland.ui.models.BorderGateDTO;
import com.homeland.ui.models.MonthYear;
import com.homeland.ui.services.BorderService;
import com.homeland.ui.services.TatimeService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;


@ManagedBean
@ApplicationScoped
public class CacheBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	List<MonthYear> monthYears;
	List<BorderGateDTO> gates;

	
	public List<BorderGateDTO> getGates() {
		return gates;
	}
	public void setGates(List<BorderGateDTO> gates) {
		this.gates = gates;
	}
	public List<MonthYear> getMonthYears() {
		return monthYears;
	}
	public void setMonthYears(List<MonthYear> monthYears) {
		this.monthYears = monthYears;
	}






	@PostConstruct
	public void load()
	{
		this.monthYears = new TatimeService().getTatimeMonthYears();
		this.gates = new BorderService().loadGates();
	}
	
	

}
