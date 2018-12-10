package com.homeland.zrpp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Envelope", namespace="http://schemas.xmlsoap.org/soap/envelope/")
public class KerkoPasuriResponse {
	
	
	KerkoPasuriBody body;

	
	@XmlElement(name="Body", namespace="http://schemas.xmlsoap.org/soap/envelope/")
	public KerkoPasuriBody getBody() {
		return body;
	}

	public void setBody(KerkoPasuriBody body) {
		this.body = body;
	}
	
	
	

}
