package com.homeland.zrpp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Body", namespace="http://schemas.xmlsoap.org/soap/envelope/")
public class MerrPasuriPronaretBody {

	
	String result;

	
	@XmlElement(name="Merr_pasuri_per_pronaretResult")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	
	
}
