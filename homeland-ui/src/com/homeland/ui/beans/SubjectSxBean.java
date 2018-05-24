package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.criterias.SubjectRequest;
import com.homeland.ui.models.Param;
import com.homeland.ui.models.SubjectDTO;
import com.homeland.ui.services.SubjectService;
import com.homeland.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class SubjectSxBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{nav}")
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
	
	@PostConstruct
	public void load()
	{
		init();
	}
	
	private void init()
	{
		this.request = new SubjectRequest();
		this.subjects = null;
		this.subject = null;
	}
	
	public void search()
	{
		try {
			this.subjects = new SubjectService().searchSubject(request);
			if(subjects == null || subjects.isEmpty())
			{
				Messages.throwFacesMessage("Nuk u gjet asnje subjekt", 2);
			}
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
			this.subjects = null;
		}
		this.subject = null;
	}
	
	public void clear()
	{
		init();
	}
	
	public void onSubjectSelect()
	{
		List<Param> params = new ArrayList<>();
		params.add(new Param("nipt",subject.getNipt()));
		nav.navigate("subject_view",params);
	}
	
	

}
