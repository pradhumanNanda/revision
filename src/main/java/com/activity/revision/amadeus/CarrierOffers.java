package com.activity.revision.amadeus;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CarrierOffers {
	
	@XmlElement(name = "CarrierOffersSummary") private CarrierOffersSummary carrierOffersSummary;
	
	@XmlElement(name = "Offer") private List<Offer> offer;

}
