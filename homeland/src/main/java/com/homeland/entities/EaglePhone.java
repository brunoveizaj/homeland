package com.homeland.entities;

import java.io.Serializable;

import javax.persistence.Column;
//import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.Table;

//@Entity
//@Table(name="eagle_phone")
public class EaglePhone implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	Integer id;
	@Column(name="nid")
	String nid;
	@Column(name="name")
	String name;
	@Column(name="surname")
	String surname;
	@Column(name="father_name")
	String fatherName;
	@Column(name="mother_name")
	String motherName;
	@Column(name="dob")
	String dob;
	@Column(name="contact_no")
	String contactNo;
	@Column(name="phone")
	String phone;
	
	public EaglePhone()
	{}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}
	
	
	
	

}
