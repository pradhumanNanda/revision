package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
public class Envelope {
	
	@XmlElement(name = "Header", namespace = "http://schemas.xmlsoap.org/soap/envelope/") private Header header;
	
	@XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/") private Body body;
	

}
