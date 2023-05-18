package com.activity.revision.singaNdc;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

	@XmlElement(name = "searchQuery")
    private SearchQuery searchQuery;
    
    @XmlElement(name = "isNewFlow")
    private Boolean isNewFlow;
    
    public static Root convert(String str) throws JAXBException {
    	
    	JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
		
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		InputStream inputStream = new ByteArrayInputStream(str.getBytes());

		Root root = (Root)unmarshaller.unmarshal(inputStream);
		
		return root;
    }
	
	
}
