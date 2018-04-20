/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homeland.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "subject")
public class Subject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "nipt")
    private String nipt;
    @Column(name = "name")
    private String name;
    @Column(name = "region")
    private String region;
    @Column(name = "city")
    private String city;
    @Column(name = "municipality")
    private String municipality;
    @Column(name = "city_center")
    private String cityCenter;
    @Column(name = "address")
    private String address;
    @Column(name = "legal_form")
    private String legalForm;
    @Column(name = "administrators")
    private String administrators;
    @Column(name = "reg_date")
    private String regDate;
    @Column(name = "activity")
    private String activity;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "status")
    private String status;
    @Column(name = "main_activity")
    private String mainActivity;
    @Column(name = "actioners")
    private String actioners;
    @Column(name = "extra_sx")
    private String extraSx;

    public Subject() {
    }

    public Subject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNipt() {
        return nipt;
    }

    public void setNipt(String nipt) {
        this.nipt = nipt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getCityCenter() {
        return cityCenter;
    }

    public void setCityCenter(String cityCenter) {
        this.cityCenter = cityCenter;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }

    public String getAdministrators() {
        return administrators;
    }

    public void setAdministrators(String administrators) {
        this.administrators = administrators;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(String mainActivity) {
        this.mainActivity = mainActivity;
    }

    public String getActioners() {
        return actioners;
    }

    public void setActioners(String actioners) {
        this.actioners = actioners;
    }

    public String getExtraSx() {
        return extraSx;
    }

    public void setExtraSx(String extraSx) {
        this.extraSx = extraSx;
    }

    
    
}
