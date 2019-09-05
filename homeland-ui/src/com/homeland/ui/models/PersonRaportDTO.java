package com.homeland.ui.models;

import java.io.Serializable;
import java.util.List;



public class PersonRaportDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	PersonDTO person;
	List<PersonDTO> family;
	List<CardDTO> cards;
	List<PassportDTO> passports;
	List<PhoneDTO> phones;
	List<TatimeDTO> tatime;
	List<OsheeDTO> oshees;
	List<BorderDTO> borders;
	List<AddressDTO> addresses;
	
	
	public PersonDTO getPerson() {
		return person;
	}
	public void setPerson(PersonDTO person) {
		this.person = person;
	}
	public List<PersonDTO> getFamily() {
		return family;
	}
	public void setFamily(List<PersonDTO> family) {
		this.family = family;
	}
	public List<CardDTO> getCards() {
		return cards;
	}
	public void setCards(List<CardDTO> cards) {
		this.cards = cards;
	}
	public List<PassportDTO> getPassports() {
		return passports;
	}
	public void setPassports(List<PassportDTO> passports) {
		this.passports = passports;
	}
	public List<PhoneDTO> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}
	public List<TatimeDTO> getTatime() {
		return tatime;
	}
	public void setTatime(List<TatimeDTO> tatime) {
		this.tatime = tatime;
	}
	public List<OsheeDTO> getOshees() {
		return oshees;
	}
	public void setOshees(List<OsheeDTO> oshees) {
		this.oshees = oshees;
	}
	public List<BorderDTO> getBorders() {
		return borders;
	}
	public void setBorders(List<BorderDTO> borders) {
		this.borders = borders;
	}
	public List<AddressDTO> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}
	

	
	
	
	
	
}
