package com.activity.revision.amadeus;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PaxJourney {
	
	@XmlElement(name = "PaxJourneyID") private String paxJourneyID;
	
	@XmlElement(name = "Duration") private String duration;
	
	@XmlElement(name = "PaxSegmentRefID") private ArrayList<String> paxSegmentRefID;

}
