package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class DetailCurrencyPrice {
	
	@XmlElement(name = "Details") private Details details;
	
	@XmlElement(name = "Total") private Double total;

}
