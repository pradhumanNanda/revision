package com.activity.revision.amadeus;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class FareDetail {
	
	@XmlElement(name = "PassengerRefs") private String passengerRefs;
	
	@XmlElement(name = "FareComponent") private ArrayList<FareComponent> fareComponent;
	
	@XmlElement(name = "Price") private FareDetailPrice price;

}
