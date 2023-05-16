package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PayloadAttributes {
	
	@XmlElement(name = "Version") private Double version;
	
	@XmlElement(name = "CorrelationID") private String correlationID;

}
