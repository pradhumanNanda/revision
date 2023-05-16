package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Desc {
	
	@XmlElement(name = "DescText") private String descText;
	
	@XmlElement(name = "DescID") private String descID;

}
