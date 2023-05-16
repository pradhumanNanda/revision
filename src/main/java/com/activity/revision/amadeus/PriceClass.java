package com.activity.revision.amadeus;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PriceClass {

	@XmlElement(name = "PriceClassID") private String PriceClassID;
	
	@XmlElement(name = "Name") private String name;
	
	@XmlElement(name = "Desc") private List<Desc> desc;

	
}
