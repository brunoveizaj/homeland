/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homeland.ui.models.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Bruno
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AkshiSubject {
    
    
    String extensionData;
    String nipt;
    String subjectName;
    String subjectStatus;
    String firstName;
    String lastName;
    String legalForm;
    String statusDescription;

    public String getExtensionData() {
        return extensionData;
    }

    public void setExtensionData(String extensionData) {
        this.extensionData = extensionData;
    }

    public String getNipt() {
        return nipt;
    }

    public void setNipt(String nipt) {
        this.nipt = nipt;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectStatus() {
        return subjectStatus;
    }

    public void setSubjectStatus(String subjectStatus) {
        this.subjectStatus = subjectStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    @Override
    public String toString() {
        return "Subject{" + "extensionData=" + extensionData + ", nipt=" + nipt + ", subjectName=" + subjectName + ", subjectStatus=" + subjectStatus + ", firstName=" + firstName + ", lastName=" + lastName + ", legalForm=" + legalForm + ", statusDescription=" + statusDescription + '}';
    }
    
    
    
    
}
