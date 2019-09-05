package com.homeland.zrpp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Envelope", namespace="http://schemas.xmlsoap.org/soap/envelope/")
public class GjeneroHarteResponse {
	
	GjeneroHarteBody body;

	@XmlElement(name="Body", namespace="http://schemas.xmlsoap.org/soap/envelope/")
	public GjeneroHarteBody getBody() {
		return body;
	}

	public void setBody(GjeneroHarteBody body) {
		this.body = body;
	}
	
	
	

}
