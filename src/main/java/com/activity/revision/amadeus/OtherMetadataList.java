package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class OtherMetadataList {
	
	@XmlElement(name = "CurrencyMetadatas") private CurrencyMetadatas currencyMetadatas;

	@XmlElement(name = "DescriptionMetadatas") private DescriptionMetadatas descriptionMetadatas;

}
