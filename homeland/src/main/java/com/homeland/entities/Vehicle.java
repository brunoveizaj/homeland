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
@Table(name = "vehicle")
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "state")
    private String state;
    @Column(name = "plate")
    private String plate;
    @Column(name = "vin")
    private String vin;
    @Column(name = "producer")
    private String producer;
    @Column(name = "model")
    private String model;
    @Column(name = "capacity")
    private String capacity;
    @Column(name = "owner")
    private String owner;
    @Column(name = "address")
    private String address;
    @Column(name = "type")
    private String type;
    @Column(name = "color")
    private String color;
    @Column(name = "driving_permit_no")
    private String drivingPermitNo;
    @Column(name = "used_for")
    private String usedFor;
    @Column(name = "owner_nid")
    private String ownerNid;
    @Column(name = "year")
    private String year;
    @Column(name = "inserted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inserted;
    @Column(name = "rid")
    private Long rid;

    public Vehicle() {
    }

    public Vehicle(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDrivingPermitNo() {
        return drivingPermitNo;
    }

    public void setDrivingPermitNo(String drivingPermitNo) {
        this.drivingPermitNo = drivingPermitNo;
    }

    public String getUsedFor() {
        return usedFor;
    }

    public void setUsedFor(String usedFor) {
        this.usedFor = usedFor;
    }

    public String getOwnerNid() {
        return ownerNid;
    }

    public void setOwnerNid(String ownerNid) {
        this.ownerNid = ownerNid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Date getInserted() {
        return inserted;
    }

    public void setInserted(Date inserted) {
        this.inserted = inserted;
    }

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

    
    
}
