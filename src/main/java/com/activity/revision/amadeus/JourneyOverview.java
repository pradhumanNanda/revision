package com.activity.revision.amadeus;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class JourneyOverview {
	
	@XmlElement(name = "PriceClassRefID") private String priceClassRefID;
	
	@XmlElement(name = "JourneyPriceClass") private ArrayList<JourneyPriceClass> journeyPriceClass;

}
