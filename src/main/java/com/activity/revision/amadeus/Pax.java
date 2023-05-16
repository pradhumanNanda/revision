package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Pax {
	
	@XmlElement(name = "PaxID") private String PaxID;
	
	@XmlElement(name = "PTC") private String PTC;

}
