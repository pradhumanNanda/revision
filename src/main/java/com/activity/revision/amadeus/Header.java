package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Header")
public class Header {

	@XmlElement(name = "To", namespace = "http://www.w3.org/2005/08/addressing") private String to;
	
	@XmlElement(name = "From", namespace = "http://www.w3.org/2005/08/addressing") private From from;
	
	@XmlElement(name = "Session", namespace = "http://xml.amadeus.com/2010/06/Session_v3") private Session session;
	
	@XmlElement(name = "Action", namespace = "http://www.w3.org/2005/08/addressing") private String action;
	
	@XmlElement(name = "MessageID", namespace = "http://www.w3.org/2005/08/addressing") private String messageId;
	
	@XmlElement(name = "RelatesTo", namespace = "http://www.w3.org/2005/08/addressing") private String relatesTo;
	
	
	
}
