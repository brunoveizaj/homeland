package com.homeland.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.homeland.ui.api.security.ApiException;
import com.homeland.ui.criterias.SubjectRequest;
import com.homeland.ui.criterias.VehicleRequest;
import com.homeland.ui.models.AddressDTO;
import com.homeland.ui.models.BorderDTO;
import com.homeland.ui.models.CardDTO;
import com.homeland.ui.models.OsheeDTO;
import com.homeland.ui.models.PassportDTO;
import com.homeland.ui.models.PersonDTO;
import com.homeland.ui.models.PersonRaportDTO;
import com.homeland.ui.models.PhoneDTO;
import com.homeland.ui.models.SubjectDTO;
import com.homeland.ui.models.TatimeDTO;
import com.homeland.ui.models.VehicleDTO;
import com.homeland.ui.services.AddressService;
import com.homeland.ui.services.PersonService;
import com.homeland.ui.services.SubjectService;
import com.homeland.ui.services.VehicleService;
import com.homeland.ui.utils.Messages;

import lombok.Getter;
import lombok.Setter;


@ManagedBean
@ViewScoped
@Getter @Setter
public class PersonViewBean implements Serializable {

	private static final long serialVersionUID = 8544975675733910003L;
	
	@ManagedProperty("#{nav}")
	NavigationBean nav;
	

	PersonDTO person;
	List<PersonDTO> family;
	List<CardDTO> cards;
	List<PassportDTO> passports;
	List<PhoneDTO> phones;
	List<TatimeDTO> tatime;
	List<OsheeDTO> oshees;
	List<BorderDTO> borders;
	List<AddressDTO> addresses;
	
	List<AddressDTO> neighbors;
	AddressDTO selectedAddress;
	
	List<SubjectDTO> subjects;
	List<VehicleDTO> vehicles;
	
	PersonDTO familyMember;
	
	
	
	
	

	
	
	public void init()
	{		
		String nid = nav.getParam("nid");		
		loadPersonRaport(nid);	
	}
	
	
	public void loadPersonRaport(String nid)
	{
		try {
				PersonRaportDTO raport = new PersonService().personRaport(nid);
				if(raport != null)
				{
					this.person = raport.getPerson();
					this.family = raport.getFamily();
					this.familyMember = person;
					this.cards = raport.getCards();
					this.passports = raport.getPassports();
					this.tatime = raport.getTatime();
					this.phones = raport.getPhones();
					this.borders = raport.getBorders();
					this.oshees = raport.getOshees();
					this.addresses = raport.getAddresses();
					this.neighbors = null;
					this.selectedAddress = null;
					
					this.vehicles = null;
					this.subjects = null;
				}
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}
	
	public void loadVehicles()
	{
		try {
			VehicleRequest vr = new VehicleRequest();
			vr.setName(person.getName());
			vr.setSurname(person.getSurname());
			this.vehicles = new VehicleService().searchVehicle(vr);
			if(vehicles == null || vehicles.isEmpty())
			{
				Messages.throwFacesMessage("Nuk ka automjete", 2);
			}
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
			this.vehicles = null;
		}
	}
	
	public void loadSubjects()
	{
		try {
			SubjectRequest sr = new SubjectRequest();
			sr.setManagers(person.getName()+" "+person.getSurname());
			this.subjects = new SubjectService().searchSubject(sr);
			if(subjects == null || subjects.isEmpty())
			{
				Messages.throwFacesMessage("Nuk ka subjekte", 2);
			}
		}catch(ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
			this.subjects = null;
		}
	}
	
	public void onFamilySelect()
	{
		loadPersonRaport(this.familyMember.getNid());
	}
	
	public void viewNeighbors(AddressDTO a)
	{
		this.selectedAddress = a;
		this.neighbors = new AddressService().getAddressByBuildingId(a.getBuildingId());
	}

}
