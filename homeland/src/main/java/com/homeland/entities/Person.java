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
@Table(name = "person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "nid")
    private String nid;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "mother_name")
    private String motherName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "civil_status")
    private String civilStatus;
    @Column(name = "dob")
    private String dob;
    @Column(name = "pob")
    private String pob;
    @Column(name = "maiden_name")
    private String maidenName;
    @Column(name = "region")
    private String region;
    @Column(name = "municipality")
    private String municipality;
    @Column(name = "unit")
    private String unit;
    @Column(name = "qv")
    private String qv;
    @Column(name = "fraction")
    private String fraction;
    @Column(name = "voting_list_no")
    private String votingListNo;
    @Column(name = "street")
    private String street;
    @Column(name = "building")
    private String building;
    @Column(name = "address")
    private String address;
    @Column(name = "family_id")
    private long familyId;
    @Column(name = "family_row_id")
    private int familyRowId;
    @Column(name = "family_relation")
    private String familyRelation;
    @Column(name = "name_sx")
    private String nameSx;
    @Column(name = "surname_sx")
    private String surnameSx;
    @Column(name = "father_name_sx")
    private String fatherNameSx;
    @Column(name = "mother_name_sx")
    private String motherNameSx;
    @Column(name = "maiden_name_sx")
    private String maidenNameSx;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getQv() {
        return qv;
    }

    public void setQv(String qv) {
        this.qv = qv;
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public String getVotingListNo() {
        return votingListNo;
    }

    public void setVotingListNo(String votingListNo) {
        this.votingListNo = votingListNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(long familyId) {
        this.familyId = familyId;
    }

    public int getFamilyRowId() {
        return familyRowId;
    }

    public void setFamilyRowId(int familyRowId) {
        this.familyRowId = familyRowId;
    }

    public String getFamilyRelation() {
        return familyRelation;
    }

    public void setFamilyRelation(String familyRelation) {
        this.familyRelation = familyRelation;
    }

    public String getNameSx() {
        return nameSx;
    }

    public void setNameSx(String nameSx) {
        this.nameSx = nameSx;
    }

    public String getSurnameSx() {
        return surnameSx;
    }

    public void setSurnameSx(String surnameSx) {
        this.surnameSx = surnameSx;
    }

    public String getFatherNameSx() {
        return fatherNameSx;
    }

    public void setFatherNameSx(String fatherNameSx) {
        this.fatherNameSx = fatherNameSx;
    }

    public String getMotherNameSx() {
        return motherNameSx;
    }

    public void setMotherNameSx(String motherNameSx) {
        this.motherNameSx = motherNameSx;
    }

    public String getMaidenNameSx() {
        return maidenNameSx;
    }

    public void setMaidenNameSx(String maidenNameSx) {
        this.maidenNameSx = maidenNameSx;
    }

   
    
    
}