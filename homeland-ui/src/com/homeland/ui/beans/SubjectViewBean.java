package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.criterias.TatimeRequest;
import com.homeland.ui.models.SubjectDTO;
import com.homeland.ui.models.TatimeDTO;
import com.homeland.ui.services.SubjectService;
import com.homeland.ui.services.TatimeService;
import com.homeland.ui.utils.Messages;
import com.homeland.ui.utils.StringUtil;

@ManagedBean
@ViewScoped
public class SubjectViewBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty("#{nav}")
	NavigationBean nav;
	
	@ManagedProperty("#{cacheBean}")
	CacheBean cache;
	
	SubjectDTO subject;
	List<TatimeDTO> tatimes;
	
	Integer year;
	Integer month;
	
	
	String selectedYearMonth;
	
	
	public NavigationBean getNav() {
		return nav;
	}

	public void setNav(NavigationBean nav) {
		this.nav = nav;
	}

	public SubjectDTO getSubject() {
		return subject;
	}

	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}

	public List<TatimeDTO> getTatimes() {
		return tatimes;
	}

	public void setTatimes(List<TatimeDTO> tatimes) {
		this.tatimes = tatimes;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public CacheBean getCache() {
		return cache;
	}

	public void setCache(CacheBean cache) {
		this.cache = cache;
	}

	public String getSelectedYearMonth() {
		return selectedYearMonth;
	}

	public void setSelectedYearMonth(String selectedYearMonth) {
		this.selectedYearMonth = selectedYearMonth;
	}

	public void init()
	{
		String nipt = nav.getParam("nipt");	
		
		loadSubjectRaport(nipt);
	}
	
	public void loadSubjectRaport(String nipt)
	{
		try {
			this.subject = new SubjectService().getSubjectByNipt(nipt);
			loadEmployees();
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
		
	}
	
	public void loadEmployees()
	{
		
		if(StringUtil.isValid(selectedYearMonth))
		{
			this.year = Integer.valueOf(selectedYearMonth.substring(0, 4));
			this.month = Integer.valueOf(selectedYearMonth.substring(5));
		}
		
		if(year == null || month == null)
		{
			if(cache.getMonthYears() == null || cache.getMonthYears().isEmpty()) {
				year = Calendar.getInstance().get(Calendar.YEAR);
				month = Calendar.getInstance().get(Calendar.MONTH);// January = 0; na duhet previous month
				if(month == 0) month = 12;
			}
			else
			{
				this.year = cache.getMonthYears().get(0).getYear();
				this.month = cache.getMonthYears().get(0).getMonth();
			}
		}
		
		TatimeRequest tr = new TatimeRequest();
		tr.setNipt(subject.getNipt());
		tr.setMonth(month);
		tr.setYear(year);
		try {
			this.tatimes = new TatimeService().searchTatime(tr); 
			if(tatimes == null || tatimes.isEmpty())
			{
				Messages.throwFacesMessage("Nuk ka listëpagesa per periudhen: "+month+"/"+year, 2);
			}
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
			this.tatimes = null;
		}
	}
	
	
	
	
	

}
