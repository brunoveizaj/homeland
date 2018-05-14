package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.homeland.ui.models.SubjectDTO;
import com.homeland.ui.models.TatimeDTO;
import com.homeland.ui.services.SubjectService;

@ManagedBean
@ViewScoped
public class SubjectViewBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty("#{nav}")
	NavigationBean nav;
	
	SubjectDTO subject;
	List<TatimeDTO> tatimes;
	
	Integer year;
	Integer month;
	
	
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
	
	

	public void init()
	{
		if(FacesContext.getCurrentInstance().isPostback())
		{
			System.out.println("POSTBACKKKKK");
		}
		else
		{
			System.out.println("NOOOOOOO    POSTBACKKKKK");
		}
		
		String nipt = nav.getParam("nipt");
		System.out.println("Niptiii nga params e nav : NIPT="+nipt);
		
		loadSubjectRaport(nipt);
		
	}
	
	public void loadSubjectRaport(String nipt)
	{
		this.subject = new SubjectService().getSubjectByNipt(nipt);
		loadEmployees();
		
	}
	
	public void loadEmployees()
	{
		this.tatimes = null; //get employees
	}
	
	

}