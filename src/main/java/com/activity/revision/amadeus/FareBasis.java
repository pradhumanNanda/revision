package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class FareBasis {
	
	@XmlElement(name = "CabinType") private CabinType cabinType;
	
	@XmlElement(name = "FareBasisCode") private FareBasisCode fareBasisCode;
	
	@XmlElement(name = "FareRulesRemarks") private FareRulesRemarks fareRulesRemarks;
	
	@XmlElement(name = "RBD") private String RBD;

}
