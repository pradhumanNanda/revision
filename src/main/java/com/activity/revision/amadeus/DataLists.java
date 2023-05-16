package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class DataLists {
	
	@XmlElement(name = "PriceClassList") private PriceClassList priceClassList;
	
	@XmlElement(name = "PenaltyList") private PenaltyList penaltyList;
	
	@XmlElement(name = "PaxSegmentList") private PaxSegmentList paxSegmentList;
	
	@XmlElement(name = "PaxList") private PaxList paxList;
	
	@XmlElement(name = "PaxJourneyList") private PaxJourneyList paxJourneyList;
	
	@XmlElement(name = "OriginDestList") private OriginDestList originDestList;
	
	@XmlElement(name = "BaggageAllowanceList") private BaggageAllowanceList baggageAllowanceList;

}
