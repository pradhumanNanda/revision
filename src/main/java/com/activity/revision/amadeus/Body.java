package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Body")
public class Body{
	
	@XmlElement(name = "AirShoppingRS", namespace = "http://www.iata.org/IATA/2015/00/2018.1/AirShoppingRS") private AirShoppingRS airShoppingRs;
	
}
