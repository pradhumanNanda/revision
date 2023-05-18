package com.activity.revision.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;

import com.activity.revision.amadeus.Envelope;

public class HelperMethods {

    public static String readXMLFile() {
    	String filePath = "/Users/bharatjoshi/Downloads/AirShoppingRS.xml";
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contentBuilder.toString();
    }
    
    public static Object convert() throws Exception {
		
		String str = readXMLFile();
		    	
		SOAPMessage soapMessage = MessageFactory.newInstance().createMessage(null,new ByteArrayInputStream(str.getBytes()));
		
        SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();

        JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        
        Envelope unmarshalledEnvelope = (Envelope)unmarshaller.unmarshal(soapEnvelope);
		
		return unmarshalledEnvelope;
    }
    
}
