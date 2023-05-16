package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ArrivalDepartureInfo {
	
	@XmlElement(name = "TerminalName") private Long terminalName;
	
	@XmlElement(name = "IATA_LocationCode") private String iATA_LocationCode;
	
	@XmlElement(name = "AircraftScheduledDateTime") private String aircraftScheduledDateTime;

}
