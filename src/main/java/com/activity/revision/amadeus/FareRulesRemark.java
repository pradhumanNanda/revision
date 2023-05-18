package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class FareRulesRemark {

	@XmlElement(name = "Category") private String category;
	
	@XmlElement(name = "Text") private String text;
	
}
