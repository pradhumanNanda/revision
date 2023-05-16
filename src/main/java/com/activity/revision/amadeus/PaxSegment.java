package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PaxSegment {
	
	@XmlElement(name = "PaxSegmentID") private String paxSegmentID;
	
	@XmlElement(name = "Duration") private String duration;
	
	@XmlElement(name = "Arrival") private ArrivalDepartureInfo arrival;
	
	@XmlElement(name = "DatedOperatingLeg") private DatedOperatingLeg datedOperatingLeg;
	
	@XmlElement(name = "Dep") private ArrivalDepartureInfo dep;
	
	@XmlElement(name = "MarketingCarrierInfo") private MarketingCarrierInfo marketingCarrierInfo;
	
	@XmlElement(name = "OperatingCarrierInfo") private OperatingCarrierInfo operatingCarrierInfo;

}
