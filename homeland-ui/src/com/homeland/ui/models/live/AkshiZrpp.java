/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homeland.ui.models.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Bruno
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AkshiZrpp {
    
    
    @JsonProperty("ZonaKadastrale")
    String zonaKadastrale;
    @JsonProperty("Volumi")
    String volumi;
    @JsonProperty("Faqja")
    String faqja;
    @JsonProperty("NumerPasurie")
    String numerPasurie;
    @JsonProperty("IndeksHarte")
    String indeksHarte;
    @JsonProperty("IDPasuria")
    String idPasuria;
    @JsonProperty("Adresa")
    AkshiZrppAddress address;

    public String getZonaKadastrale() {
        return zonaKadastrale;
    }

    public void setZonaKadastrale(String zonaKadastrale) {
        this.zonaKadastrale = zonaKadastrale;
    }

    public String getVolumi() {
        return volumi;
    }

    public void setVolumi(String volumi) {
        this.volumi = volumi;
    }

    public String getFaqja() {
        return faqja;
    }

    public void setFaqja(String faqja) {
        this.faqja = faqja;
    }

    public String getNumerPasurie() {
        return numerPasurie;
    }

    public void setNumerPasurie(String numerPasurie) {
        this.numerPasurie = numerPasurie;
    }

    public String getIndeksHarte() {
        return indeksHarte;
    }

    public void setIndeksHarte(String indeksHarte) {
        this.indeksHarte = indeksHarte;
    }

    public String getIdPasuria() {
        return idPasuria;
    }

    public void setIdPasuria(String idPasuria) {
        this.idPasuria = idPasuria;
    }

    public AkshiZrppAddress getAddress() {
        return address;
    }

    public void setAddress(AkshiZrppAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Zrpp{" + "zonaKadastrale=" + zonaKadastrale + ", volumi=" + volumi + ", faqja=" + faqja + ", numerPasurie=" + numerPasurie + ", indeksHarte=" + indeksHarte + ", idPasuria=" + idPasuria + ", address=" + address + '}';
    }
    
    
    
    
    
    
}
