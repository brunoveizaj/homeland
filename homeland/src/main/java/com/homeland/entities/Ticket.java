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
@Table(name = "ticket")
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "serial_no")
    private String serialNo;
    @Temporal(TemporalType.DATE)
    @Column(name = "ticket_date")
    private Date ticketDate;
    @Column(name = "ticket_place")
    private String ticketPlace;
    @Column(name = "officer")
    private String officer;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "plate")
    private String plate;
    @Column(name = "producer")
    private String producer;
    @Column(name = "owner")
    private String owner;
    @Column(name = "owner_address")
    private String ownerAddress;
    @Column(name = "violator")
    private String violator;
    @Column(name = "violator_nid")
    private String violatorNid;
    @Column(name = "status")
    private String status;
    @Column(name = "inserted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inserted;
    @Column(name = "rid")
    private Long rid;
    @Column(name = "tims_rec_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timsRecDate;

    public Ticket() {
    }

    public Ticket(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getTicketPlace() {
        return ticketPlace;
    }

    public void setTicketPlace(String ticketPlace) {
        this.ticketPlace = ticketPlace;
    }

    public String getOfficer() {
        return officer;
    }

    public void setOfficer(String officer) {
        this.officer = officer;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public String getViolator() {
        return violator;
    }

    public void setViolator(String violator) {
        this.violator = violator;
    }

    public String getViolatorNid() {
        return violatorNid;
    }

    public void setViolatorNid(String violatorNid) {
        this.violatorNid = violatorNid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

	public Date getTimsRecDate() {
		return timsRecDate;
	}

	public void setTimsRecDate(Date timsRecDate) {
		this.timsRecDate = timsRecDate;
	}

	
    
}
