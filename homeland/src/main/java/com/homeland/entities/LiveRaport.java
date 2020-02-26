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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "live_report")
@Getter @Setter
public class LiveRaport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "request_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestTime;
    @Column(name = "response_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date responseTime;
    @Column(name = "request_user")
    private String requestUser;
    @Column(name = "type")
    private String type;
    @Column(name = "key_value")
    private String key;
    @Column(name = "data_json")
    private String dataJson;
    @Column(name = "status")
    private String status;
    
}