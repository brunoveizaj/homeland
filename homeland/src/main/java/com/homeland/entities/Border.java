/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homeland.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "border")
public class Border implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "doc_state")
    private String docState;
    @Column(name = "doc_no")
    private String docNo;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "crossing_date")
    private Date crossingDate;
    @Column(name = "citizen_type")
    private String citizenType;
    @Column(name = "travel")
    private String travel;
    @Column(name = "crossing_gate")
    private String crossingGate;
    @Column(name = "bcg_id")
    private String bcgId;
    @Column(name = "driver")
    private Integer driver;
    @Column(name = "plate")
    private String plate;
    @Column(name = "nid")
    private String nid;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "dob")
    private String dob;
    @Column(name = "gender")
    private String gender;
    @Column(name = "pupose")
    private String pupose;
    @Column(name = "event")
    private String event;
    @Column(name = "is_foreign")
    private Integer foreign;
    @Column(name = "inserted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inserted;

    public Border() {
    }

    public Border(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocState() {
        return docState;
    }

    public void setDocState(String docState) {
        this.docState = docState;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Date getCrossingDate() {
        return crossingDate;
    }

    public void setCrossingDate(Date crossingDate) {
        this.crossingDate = crossingDate;
    }

    public String getCitizenType() {
        return citizenType;
    }

    public void setCitizenType(String citizenType) {
        this.citizenType = citizenType;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public String getCrossingGate() {
        return crossingGate;
    }

    public void setCrossingGate(String crossingGate) {
        this.crossingGate = crossingGate;
    }

    public Integer getDriver() {
        return driver;
    }

    public void setDriver(Integer driver) {
        this.driver = driver;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPupose() {
        return pupose;
    }

    public void setPupose(String pupose) {
        this.pupose = pupose;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getInserted() {
        return inserted;
    }

    public void setInserted(Date inserted) {
        this.inserted = inserted;
    }

	public String getBcgId() {
		return bcgId;
	}

	public void setBcgId(String bcgId) {
		this.bcgId = bcgId;
	}

	public Integer getForeign() {
		return foreign;
	}

	public void setForeign(Integer foreign) {
		this.foreign = foreign;
	}

    

   
    
}
