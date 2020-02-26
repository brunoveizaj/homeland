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

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AkshiIsshContribution {
    
    
    double employeeContrib;
    double employerContrib;
    String name;
    double grossSalary;
    double grossSalaryContrib;
    double healthContrib;
    String surname;
    double netSalary;
    String nipt;
    int month;
    int year;
    String nid;
    String schemaName;
    String subjectName;
    double supplementContrib;

    
    @Override
    public String toString() {
        return "IsshContribution{" + "employeeContrib=" + employeeContrib + ", employerContrib=" + employerContrib + ", name=" + name + ", grossSalary=" + grossSalary + ", grossSalaryContrib=" + grossSalaryContrib + ", healthContrib=" + healthContrib + ", surname=" + surname + ", netSalary=" + netSalary + ", nipt=" + nipt + ", month=" + month + ", year=" + year + ", nid=" + nid + ", schemaName=" + schemaName + ", subjectName=" + subjectName + ", supplementContrib=" + supplementContrib + '}';
    }
    
    
    
    
    
    
    
    
}
