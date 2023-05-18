package com.activity.revision.amadeus;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class BaggageAllowance {
	
	@XmlElement(name = "BaggageAllowanceRefID") private String baggageAllowanceRefID;
	
	@XmlElement(name = "PaxJourneyRefID") private ArrayList<String> paxJourneyRefID;
	
	@XmlElement(name = "PaxRefID") private String paxRefID;

}
