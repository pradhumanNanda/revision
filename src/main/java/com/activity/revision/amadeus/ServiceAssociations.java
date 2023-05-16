package com.activity.revision.amadeus;

import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceAssociations {
	
	@XmlElement(name = "PaxJourneyRefID") private Map<Long,String> paxJourneyRefID;

}
