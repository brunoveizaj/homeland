package com.homeland.dto;



public class PhotoDTO {

	
	private int id;
    private String idDoc;
    private byte[] photo;
	String docType;
	private Long rid;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdDoc() {
		return idDoc;
	}
	public void setIdDoc(String idDoc) {
		this.idDoc = idDoc;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	
	
	
	
	
	
	
	
}
