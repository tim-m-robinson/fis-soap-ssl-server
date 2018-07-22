package net.atos.services;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.ByteArrayOutputStream;
import java.util.Set;

public class MessageTraceLogHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
    	
    	try{
	    	SOAPMessage msg = context.getMessage();
	    	ByteArrayOutputStream out = new ByteArrayOutputStream();
	    	msg.writeTo(out);
	    	String strMsg = new String(out.toByteArray());
	    	
	        Boolean outboundProperty = (Boolean) context.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);
	
	        if (outboundProperty.booleanValue()) {
	            System.out.println("\nOutbound message:");
	        } else {
	            System.out.println("\nInbound message:");
	        }
	
	        System.out.println("** Body: "+ strMsg);
    	} catch (Exception e) {
    		 System.out.println("*** : Exception : " + e.getMessage()); 
    	}
        
        return true;
    }


    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {
    }


    @Override
    public Set<QName> getHeaders() {
        return null;
    }

}