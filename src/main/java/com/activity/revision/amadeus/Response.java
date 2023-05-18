package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Response", namespace = "http://www.iata.org/IATA/2015/00/2018.1/AirShoppingRS")
public class Response {
	
	@XmlElement(name = "AirShoppingProcessing") private AirShoppingProcessing airShoppingProcessing;
	
	@XmlElement(name = "DataLists") private DataLists dataLists;
	
	@XmlElement(name = "Metadata") private Metadata metadata;
	
	@XmlElement(name = "OffersGroup") private OffersGroup offersGroup;
	
	@XmlElement(name = "ShoppingResponse") private ShoppingResponse shoppingResponse;
	
	@XmlElement(name = "Warning") private Warning warning;

}
