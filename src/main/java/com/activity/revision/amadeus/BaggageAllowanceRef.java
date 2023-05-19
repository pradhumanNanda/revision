package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class BaggageAllowanceRef {

	@XmlElement(name = "BaggageAllowanceID") private String baggageAllowanceID;
	
	@XmlElement(name = "TypeCode") private String typeCode;
	
	@XmlElement(name = "WeightAllowance") private WeightAllowance weightAllowance;
	
}
