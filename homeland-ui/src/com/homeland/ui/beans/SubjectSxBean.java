package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.criterias.SubjectRequest;
import com.homeland.ui.models.SubjectDTO;

@ManagedBean
@ViewScoped
public class SubjectSxBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="{nav}")
	NavigationBean nav;
	
	SubjectRequest request;
	
	List<SubjectDTO> subjects;
	SubjectDTO subject;
	
	
	
	public NavigationBean getNav() {
		return nav;
	}
	public void setNav(NavigationBean nav) {
		this.nav = nav;
	}
	public SubjectRequest getRequest() {
		return request;
	}
	public void setRequest(SubjectRequest request) {
		this.request = request;
	}
	public List<SubjectDTO> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<SubjectDTO> subjects) {
		this.subjects = subjects;
	}
	public SubjectDTO getSubject() {
		return subject;
	}
	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}
	
	
	private void init()
	{
		this.request = new SubjectRequest();
		this.subjects = null;
		this.subject = null;
	}
	
	public void search()
	{
		init();
	}
	
	public void clear()
	{
		init();
	}
	
	public void onSubjectSelect()
	{
		
	}
	
	

}
