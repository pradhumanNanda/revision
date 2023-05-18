package com.activity.revision.singaNdc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class RouteInfos {
    @XmlElement(name = "fromCityOrAirport")
    private CityOrAirport fromCityOrAirport;
    
    @XmlElement(name = "toCityOrAirport")
    private CityOrAirport toCityOrAirport;
    
    @XmlElement(name = "travelDate")
    private String travelDate;

}
