package com.activity.revision.amadeus;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Offer {
	
	@XmlElement(name = "BaggageAllowance") private BaggageAllowance baggageAllowance;
	
	@XmlElement(name = "JourneyOverview") private JourneyOverview journeyOverview;
	
	@XmlElement(name = "OfferExpirationDateTime") private String offerExpirationDateTime;
	
	@XmlElement(name = "OfferID") private String offerID;
	
	@XmlElement(name = "OfferItem") private OfferItem offerItem;
	
	@XmlElement(name = "OwnerCode") private String ownerCode;
	
	@XmlElement(name = "PenaltyRefID") private ArrayList<String> penaltyRefID;

}
