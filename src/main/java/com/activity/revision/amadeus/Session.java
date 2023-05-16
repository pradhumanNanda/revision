package com.activity.revision.amadeus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Session {
	
	@XmlElement(name = "SessionId", namespace="http://xml.amadeus.com/2010/06/Session_v3") private String sessionId;
	
	@XmlElement(name = "SequenceNumber", namespace="http://xml.amadeus.com/2010/06/Session_v3") private Long sequenceNumber;
	
	@XmlElement(name = "SecurityToken", namespace="http://xml.amadeus.com/2010/06/Session_v3") private String securityToken;

}
