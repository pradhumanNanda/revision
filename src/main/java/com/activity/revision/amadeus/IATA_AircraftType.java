package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class IATA_AircraftType {

	@XmlElement(name = "IATA_AircraftTypeCode") private String iATA_AircraftTypeCode;
	
}
