package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class DescriptionMetadata {
	
	@XmlElement(name = "Topic") private String topic;
	
	@XmlElement(name = "Sequence") private Long sequence;

}
