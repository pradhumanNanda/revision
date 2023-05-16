package com.activity.revision.singaNdc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PaxInfo {
	
    @XmlElement(name = "ADULT")
    private Integer adult;
    
    @XmlElement(name = "CHILD")
    private Integer child;
    
    @XmlElement(name = "INFANT")
    private Integer infant;

}
