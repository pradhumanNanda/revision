package com.activity.revision.singaNdc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchModifiers {
    @XmlElement(name = "sourceId")
    private Integer sourceId;
    
    @XmlElement(name = "isDirectFlight")
    private Boolean isDirectFlight;
    
    @XmlElement(name = "isConnectingFlight")
    private Boolean isConnectingFlight;
    
    @XmlElement(name = "isMultiCity")
    private Boolean isMultiCity;
    
    @XmlElement(name = "pnrCreditInfo")
    private PnrCreditInfo pnrCreditInfo;
    
    @XmlElement(name = "iiss")
    private Boolean iiss;
    
    @XmlElement(name = "pft")
    private String pft;

}
