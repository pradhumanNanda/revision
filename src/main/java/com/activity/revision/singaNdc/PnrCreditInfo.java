package com.activity.revision.singaNdc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PnrCreditInfo {
	
    @XmlElement(name = "pnr")
    private String pnr;

}