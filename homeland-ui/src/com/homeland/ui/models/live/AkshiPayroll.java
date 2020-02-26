/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homeland.ui.models.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.homeland.ui.utils.StringUtil;

/**
 *
 * @author Bruno
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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

    public double getContributionForHealth() {
        return contributionForHealth;
    }

    public void setContributionForHealth(double contributionForHealth) {
        this.contributionForHealth = contributionForHealth;
    }

    public double getContributionForSocial() {
        return contributionForSocial;
    }

    public void setContributionForSocial(double contributionForSocial) {
        this.contributionForSocial = contributionForSocial;
    }

    public double getContributionForSupp() {
        return contributionForSupp;
    }

    public void setContributionForSupp(double contributionForSupp) {
        this.contributionForSupp = contributionForSupp;
    }

    public double getContributionForTotal() {
        return contributionForTotal;
    }

    public void setContributionForTotal(double contributionForTotal) {
        this.contributionForTotal = contributionForTotal;
    }

    public double getDeclaredTotalContributions() {
        return declaredTotalContributions;
    }

    public void setDeclaredTotalContributions(double declaredTotalContributions) {
        this.declaredTotalContributions = declaredTotalContributions;
    }

    public String getInsuranceCategoryCode() {
        return insuranceCategoryCode;
    }

    public void setInsuranceCategoryCode(String insuranceCategoryCode) {
        this.insuranceCategoryCode = insuranceCategoryCode;
    }

    public String getInsuranceCategoryDescription() {
        return insuranceCategoryDescription;
    }

    public void setInsuranceCategoryDescription(String insuranceCategoryDescription) {
        if(StringUtil.isValid(insuranceCategoryDescription))
        {
            this.insuranceCategoryDescription = insuranceCategoryDescription.replace("Ã«", "ë");
        }
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTaxPayerName() {
        return taxPayerName;
    }

    public void setTaxPayerName(String taxPayerName) {
        this.taxPayerName = taxPayerName;
    }

    public String getTaxPayerNipt() {
        return taxPayerNipt;
    }

    public void setTaxPayerNipt(String taxpayerNipt) {
        this.taxPayerNipt = taxpayerNipt;
    }

    public double getWageForHealthContrib() {
        return wageForHealthContrib;
    }

    public void setWageForHealthContrib(double wageForHealthContrib) {
        this.wageForHealthContrib = wageForHealthContrib;
    }

    public double getWageForSocialContrib() {
        return wageForSocialContrib;
    }

    public void setWageForSocialContrib(double wageForSocialContrib) {
        this.wageForSocialContrib = wageForSocialContrib;
    }

    @Override
    public String toString() {
        return "Payroll{" + "\ncontributionForHealth=" + contributionForHealth + ", \ncontributionForSocial=" + contributionForSocial + ", \ncontributionForSupp=" + contributionForSupp + ", \ncontributionForTotal=" + contributionForTotal + ", \ndeclaredTotalContributions=" + declaredTotalContributions + ", \ninsuranceCategoryCode=" + insuranceCategoryCode + ", \ninsuranceCategoryDescription=" + insuranceCategoryDescription + ", \nnotes=" + notes + ", \nperiod=" + period + ", \ntaxPayerName=" + taxPayerName + ", \ntaxpayerNipt=" + taxPayerNipt + ", \nwageForHealthContrib=" + wageForHealthContrib + ", \nwageForSocialContrib=" + wageForSocialContrib + '}';
    }
    
    
    
    
    
}
