package com.homeland.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.homeland.utils.StringUtil;

public class BuildingMAP {

	
	BigInteger buildingId;
	String buildingNo;
	String buildingCode;
	Integer unitId;
	String center;
	String shape;
	
	
	
	public BigInteger getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(BigDecimal buildingId) {
		if(buildingId != null)
		this.buildingId = buildingId.toBigInteger();
	}
	public void setBuildingId(BigInteger buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}
	public String getBuildingCode() {
		return buildingCode;
	}
	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		if(StringUtil.isValid(unitId))
		this.unitId = Integer.valueOf(unitId);
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	
	
	
}
