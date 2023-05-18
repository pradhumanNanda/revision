package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class MarketingCarrierInfo {
	
	@XmlElement(name = "CarrierDesigCode") private String carrierDesigCode;
	
	@XmlElement(name = "MarketingCarrierFlightNumberText") private Long marketingCarrierFlightNumberText;

}
