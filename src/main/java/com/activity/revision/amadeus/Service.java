package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Service {

	@XmlElement(name = "PaxRefID") private String paxRefID;
	
	@XmlElement(name = "ServiceAssociations") private ServiceAssociations ServiceAssociations;
	
	@XmlElement(name = "ServiceID") private Long serviceID;
	
}
