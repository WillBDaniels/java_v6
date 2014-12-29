package com.vantiv.pws.soap.handlers;

/**
 Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
 Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
 This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
 Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
 Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
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
