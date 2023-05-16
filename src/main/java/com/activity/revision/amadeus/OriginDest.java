package com.activity.revision.amadeus;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class OriginDest {
	
	@XmlElement(name = "DestCode") private String destCode;
	
	@XmlElement(name = "OriginCode") private String originCode;
	
	@XmlElement(name = "OriginDestID") private String originDestID;
	
	@XmlElement(name = "PaxJourneyRefID") private Map<Long,String> paxJourneyRefID;

}
