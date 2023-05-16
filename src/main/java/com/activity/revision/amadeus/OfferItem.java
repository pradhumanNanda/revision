package com.activity.revision.amadeus;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferItem {
	
	@XmlElement(name = "FareDetail") private ArrayList<FareDetail> fareDetail;
	
	@XmlElement(name = "MandatoryInd") private Boolean mandatoryInd;
	
	@XmlElement(name = "OfferItemID") private String offerItemID;
	
	@XmlElement(name = "Price") private Price Price;
	
	@XmlElement(name = "Service") private Service Service;

}
