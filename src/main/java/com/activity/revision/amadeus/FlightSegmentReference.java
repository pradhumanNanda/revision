package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class FlightSegmentReference {
	
	@XmlElement(name = "ClassOfService") private ClassOfService classOfService;

	@XmlAttribute(name = "ref") private String ref;
	
}
