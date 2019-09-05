package com.homeland.models;

import java.io.Serializable;
import java.util.List;

import com.homeland.dto.BorderDTO;

public class BorderList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	List<BorderDTO> borders;


	public List<BorderDTO> getBorders() {
		return borders;
	}


	public void setBorders(List<BorderDTO> borders) {
		this.borders = borders;
	}
	
	
	
	
}
