package com.homeland.zrpp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Envelope", namespace="http://schemas.xmlsoap.org/soap/envelope/")
public class ShkarkoKarteleResponse {
	
	
	ShkarkoKarteleBody body;

	
	@XmlElement(name="Body", namespace="http://schemas.xmlsoap.org/soap/envelope/")
	public ShkarkoKarteleBody getBody() {
		return body;
	}

	public void setBody(ShkarkoKarteleBody body) {
		this.body = body;
	}
	
	
	

}
