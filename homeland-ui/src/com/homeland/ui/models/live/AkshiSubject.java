/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homeland.ui.models.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class AkshiSubject {
    
    
    String extensionData;
    String nipt;
    String subjectName;
    String subjectStatus;
    String firstName;
    String lastName;
    String legalForm;
    String statusDescription;

    
    
    
}
