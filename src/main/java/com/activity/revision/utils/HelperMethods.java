package com.activity.revision.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
    
    public static Envelope helper() throws Exception {
    	MessageFactory factory = MessageFactory.newInstance();
    	SOAPMessage message = factory.createMessage();
        URL url = new URL("https://nodeA3.test.webservices.amadeus.com/1ASIWCLTSQ");
        HttpURLConnection httpUrlCon = (HttpURLConnection) url.openConnection();
        httpUrlCon.setRequestProperty("Content-type", "text/xml; charset=utf-8");
        httpUrlCon.setRequestProperty("SOAPAction", "http://webservices.amadeus.com/NDC_AirShopping_18.1");
        httpUrlCon.setRequestMethod("POST");
        httpUrlCon.setDoOutput(true);
        httpUrlCon.connect();
        OutputStream os = httpUrlCon.getOutputStream();
        message.writeTo(os);
        StringWriter sw = new StringWriter();
     
        TransformerFactory.newInstance().newTransformer().transform(
            new DOMSource(message.getSOAPPart()),
            new StreamResult(sw));
        

        System.out.println(sw.toString()); 
        
        os.flush();
        os.close();
        
        httpUrlCon.disconnect();
        return null;
    }
    
}
