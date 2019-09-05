package com.homeland.zrpp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Body", namespace="http://schemas.xmlsoap.org/soap/envelope/")
public class GjeneroHarteBody {

	
	String content;

	
	@XmlElement(name="gjenero_harteResult")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
}
