package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Price {

	@XmlElement(name = "BaseAmount") private Double baseAmount;
	
	@XmlElement(name = "TotalAmount") private Double totalAmount;
	
	@XmlElement(name = "TaxSummary") private TaxSummary taxSummary;
}
