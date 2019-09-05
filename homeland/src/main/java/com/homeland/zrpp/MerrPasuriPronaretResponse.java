package com.homeland.zrpp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Envelope", namespace="http://schemas.xmlsoap.org/soap/envelope/")
public class MerrPasuriPronaretResponse {
	
	MerrPasuriPronaretBody body;

	@XmlElement(name="Body", namespace="http://schemas.xmlsoap.org/soap/envelope/")
	public MerrPasuriPronaretBody getBody() {
		return body;
	}

	public void setBody(MerrPasuriPronaretBody body) {
		this.body = body;
	}
	
	
	

}
