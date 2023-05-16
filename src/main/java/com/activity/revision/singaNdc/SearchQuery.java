package com.activity.revision.singaNdc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchQuery {
    @XmlElement(name = "cabinClass")
    private String cabinClass;
    
    @XmlElement(name = "searchModifiers")
    private SearchModifiers searchModifiers;
    
    @XmlElement(name = "routeInfos")
    private RouteInfos routeInfos;
    
    @XmlElement(name = "paxInfo")
    private PaxInfo paxInfo;

}
