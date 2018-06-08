package com.homeland.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "photo_card")
public class PhotoCard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "idc")
    private String idc;
  //  @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "insterted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insterted;
    @Column(name = "rid")
    private Long rid;

    public PhotoCard() {
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdc() {
        return idc;
    }

    public void setIdc(String idc) {
        this.idc = idc;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Date getInsterted() {
        return insterted;
    }

    public void setInsterted(Date insterted) {
        this.insterted = insterted;
    }




	public Long getRid() {
		return rid;
	}




	public void setRid(Long rid) {
		this.rid = rid;
	}

    
    
    
}
