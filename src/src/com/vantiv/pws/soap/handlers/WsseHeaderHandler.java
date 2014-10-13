package com.vantiv.pws.soap.handlers;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 * This handler class will add the correct username/password to the header of a
 * SOAP request. It uses WSSE security.
 */
public class WsseHeaderHandler implements SOAPHandler<SOAPMessageContext> {

    public static final String WSSE_SECEXT_XSD_URL = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
    public static final String WSSE_UTIL_XSD_URL = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";
    public static final String WSSE_PASSWORD_XSD_URL = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText";

    private String username;
    private String password;


    public WsseHeaderHandler(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
	public boolean handleMessage(SOAPMessageContext smc) {

        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty.booleanValue()) {

            try {
                SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				if (header == null)
					header = envelope.addHeader();

                SOAPElement security =
                        header.addChildElement("Security", "wsse", WSSE_SECEXT_XSD_URL);

                SOAPElement usernameToken =
                        security.addChildElement("UsernameToken", "wsse");
                usernameToken.addAttribute(new QName("xmlns:wsu"), WSSE_UTIL_XSD_URL);

                SOAPElement usernameElement =
                        usernameToken.addChildElement("Username", "wsse");
				// System.out.println("setting username to " + username );
                usernameElement.addTextNode(username);

                SOAPElement passwordElement =
                        usernameToken.addChildElement("Password", "wsse");
                passwordElement.setAttribute("Type", WSSE_PASSWORD_XSD_URL);
//                    System.out.printf("setting password to %s%n", password);
                passwordElement.addTextNode(password);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return outboundProperty;
    }

    @Override
	public Set getHeaders() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }

    @Override
	public boolean handleFault(SOAPMessageContext context) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return true;
    }

    @Override
	public void close(MessageContext context) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
