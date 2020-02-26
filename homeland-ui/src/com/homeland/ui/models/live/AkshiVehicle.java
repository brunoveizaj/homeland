package com.homeland.ui.models.live;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AkshiVehicle {
	
	
	
	 private int id;

	    private String state;
	
	    private String plate;
	
	    private String producerModel;
	
	    private String capacity;
	
	    private String owner;
	
	    private String adress;
	
	    private String type;
	  
	    private String model;
	
	    private String vin;
	  
	    private String color;
	    
	    private String drivingPermitNo;
	    private String usedFor;
	    private String ownerNid;
	    private String year;
		@Override
		public String toString() {
			return "AkshiVehicle [id=" + id + ", state=" + state + ", plate=" + plate + ", producerModel="
					+ producerModel + ", capacity=" + capacity + ", owner=" + owner + ", adress=" + adress + ", type="
					+ type + ", model=" + model + ", vin=" + vin + ", color=" + color + ", drivingPermitNo="
					+ drivingPermitNo + ", usedFor=" + usedFor + ", ownerNid=" + ownerNid + ", year=" + year + "]";
		}
	
	
	    
	

}
