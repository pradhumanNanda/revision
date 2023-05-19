package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Detail {
	
	@XmlElement(name = "SubTotal") private Double subTotal;
	
	@XmlElement(name = "Application") private String application;
	
	@XmlAttribute(name = "refs") private String refs;

}
