package com.homeland.zrpp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Envelope", namespace="http://schemas.xmlsoap.org/soap/envelope/")
public class MerrPasuriResponse {
	
	
	MerrPasuriBody body;

	
	@XmlElement(name="Body", namespace="http://schemas.xmlsoap.org/soap/envelope/")
	public MerrPasuriBody getBody() {
		return body;
	}

	public void setBody(MerrPasuriBody body) {
		this.body = body;
	}
	
	

}
