package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class DatedOperatingLeg {
	
	@XmlElement(name = "DatedOperatingLegID") private String DatedOperatingLegID;
	
	@XmlElement(name = "Arrival") private ArrivalDepartureInfo arrival;
	
	@XmlElement(name = "Dep") private ArrivalDepartureInfo departure;
	
	@XmlElement(name = "IATA_AircraftType") private IATA_AircraftType iATA_AircraftType;

}
