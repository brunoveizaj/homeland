package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.criterias.PersonRequest;
import com.homeland.ui.models.PersonDTO;
import com.homeland.ui.services.PersonService;
import com.homeland.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class PersonSxBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{nav}")
	NavigationBean nav;
	
	
	PersonRequest request;	
	
	boolean renderFilter;
	
	List<PersonDTO> persons;
	PersonDTO person;
	
	@PostConstruct
	public void load()
	{
		renderFilter = true;
		request = new PersonRequest();
	}
	
	
	public PersonRequest getRequest() {
		return request;
	}
	public void setRequest(PersonRequest request) {
		this.request = request;
	}
	public boolean isRenderFilter() {
		return renderFilter;
	}
	public void setRenderFilter(boolean renderFilter) {
		this.renderFilter = renderFilter;
	}
	public List<PersonDTO> getPersons() {
		return persons;
	}
	public void setPersons(List<PersonDTO> persons) {
		this.persons = persons;
	}
	public PersonDTO getPerson() {
		return person;
	}
	public void setPerson(PersonDTO person) {
		this.person = person;
	}
	public NavigationBean getNav() {
		return nav;
	}
	public void setNav(NavigationBean nav) {
		this.nav = nav;
	}

	
	

	public void personSelect()
	{		
		nav.navigate("person_view");
	}
	
	
	public void clear()
	{
		this.request = new PersonRequest();
		renderFilter();
		
	}

	public void renderFilter()
	{
		this.renderFilter = true;
		this.person = null;
		this.persons = null;
	}
	
	public void renderList()
	{
		this.renderFilter = false;
	}


	public void search()
	{
		this.persons = new PersonService().searchPerson(request);
		
		if(persons!=null && !persons.isEmpty())
		{
			renderList();
		}
		else
		{
			renderFilter();
			Messages.throwFacesMessage("Nuk u gjet asnje rezultat", 2);
		}
		
	}
	
	
	

}
