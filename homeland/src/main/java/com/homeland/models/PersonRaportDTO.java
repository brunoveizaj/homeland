package com.homeland.models;

import java.util.List;

import com.homeland.dto.BorderDTO;
import com.homeland.dto.CardDTO;
import com.homeland.dto.OsheeDTO;
import com.homeland.dto.PassportDTO;
import com.homeland.dto.PersonDTO;
import com.homeland.dto.PhoneDTO;
import com.homeland.dto.TatimeDTO;

public class PersonRaportDTO {
	
	
	PersonDTO person;
	List<PersonDTO> family;
	List<CardDTO> cards;
	List<PassportDTO> passports;
	List<PhoneDTO> phones;
	List<TatimeDTO> tatime;
	List<OsheeDTO> oshees;
	List<BorderDTO> borders;
	
	
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
	

	
	
	
	
	
}
