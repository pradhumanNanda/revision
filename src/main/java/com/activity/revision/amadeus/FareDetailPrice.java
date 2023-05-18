package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class FareDetailPrice {
	
	@XmlElement(name = "BaseAmount") private Double BbaseAmount;
	
	@XmlElement(name = "Taxes") private Taxes Taxes;
	
	@XmlElement(name = "TotalAmount") private TotalAmount totalAmount;

}
