package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class FareComponent {
	
	@XmlElement(name = "PriceClassRef") private String priceClassRef;
	
	@XmlElement(name = "SegmentRefs") private String segmentRefs;
	
	@XmlElement(name = "FareBasis") private FareBasis fareBasis;

}
