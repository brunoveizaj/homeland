package com.homeland.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class AddressDTO implements Serializable {
	
	    private static final long serialVersionUID = 1L;

	    private String id;
	    private BigInteger addressId;
	    private String subjectType;
	    private String nid;
	    private String name;
	    private String street;
	    private String buildingEntrance;
	    private String admUnit;
	    private String city;
	    private BigInteger entranceId;
	    private String entranceNo;
	    private BigInteger buildingId;
	    private BigInteger buildingNo;
	    private String buildingCode;
	    private String municipality;
	    private BigInteger unitId;
	    
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public BigInteger getAddressId() {
			return addressId;
		}
		public void setAddressId(BigInteger addressId) {
			this.addressId = addressId;
		}
		public String getSubjectType() {
			return subjectType;
		}
		public void setSubjectType(String subjectType) {
			this.subjectType = subjectType;
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
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getBuildingEntrance() {
			return buildingEntrance;
		}
		public void setBuildingEntrance(String buildingEntrance) {
			this.buildingEntrance = buildingEntrance;
		}
		public String getAdmUnit() {
			return admUnit;
		}
		public void setAdmUnit(String admUnit) {
			this.admUnit = admUnit;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public BigInteger getEntranceId() {
			return entranceId;
		}
		public void setEntranceId(BigInteger entranceId) {
			this.entranceId = entranceId;
		}
		public String getEntranceNo() {
			return entranceNo;
		}
		public void setEntranceNo(String entranceNo) {
			this.entranceNo = entranceNo;
		}
		public BigInteger getBuildingId() {
			return buildingId;
		}
		public void setBuildingId(BigInteger buildingId) {
			this.buildingId = buildingId;
		}
		public BigInteger getBuildingNo() {
			return buildingNo;
		}
		public void setBuildingNo(BigInteger buildingNo) {
			this.buildingNo = buildingNo;
		}
		public String getBuildingCode() {
			return buildingCode;
		}
		public void setBuildingCode(String buildingCode) {
			this.buildingCode = buildingCode;
		}
		public String getMunicipality() {
			return municipality;
		}
		public void setMunicipality(String municipality) {
			this.municipality = municipality;
		}
		public BigInteger getUnitId() {
			return unitId;
		}
		public void setUnitId(BigInteger unitId) {
			this.unitId = unitId;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AddressDTO other = (AddressDTO) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
	    
	    
	    
	    

}
