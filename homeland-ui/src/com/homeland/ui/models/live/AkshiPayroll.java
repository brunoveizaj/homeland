/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homeland.ui.models.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.homeland.ui.utils.StringUtil;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Bruno
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class AkshiPayroll {
        
    double contributionForHealth;
    double contributionForSocial;
    double contributionForSupp;
    double contributionForTotal;
    double declaredTotalContributions;
    String insuranceCategoryCode;
    String insuranceCategoryDescription;
    String notes;
    String period;
    String taxPayerName;
    String taxPayerNipt;
    double wageForHealthContrib;
    double wageForSocialContrib;

   

    public String getInsuranceCategoryDescription() {
    	if(StringUtil.isValid(insuranceCategoryDescription))
        {
            this.insuranceCategoryDescription = insuranceCategoryDescription.replace("Ã«", "ë");
        }
        return insuranceCategoryDescription;
    }

    public void setInsuranceCategoryDescription(String insuranceCategoryDescription) {
        if(StringUtil.isValid(insuranceCategoryDescription))
        {
            this.insuranceCategoryDescription = insuranceCategoryDescription.replace("Ã«", "ë");
        }
    }

    
    
    
    
    
}
