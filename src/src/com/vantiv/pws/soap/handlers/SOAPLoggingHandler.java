package com.vantiv.pws.soap.handlers;

/**
 Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
 Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
 This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
 Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
 Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
import java.io.PrintStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/*
 * This simple SOAPHandler will output the contents of incoming
 * and outgoing messages.
 */
public class SOAPLoggingHandler implements SOAPHandler<SOAPMessageContext> {

	// change this to redirect output if desired
	private static PrintStream out = System.out;

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

    @Override
	public boolean handleMessage(SOAPMessageContext smc) {
		logToSystemOut(smc);
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext smc) {
		logToSystemOut(smc);
		return true;
	}

	// nothing to clean up
	@Override
	public void close(MessageContext messageContext) {
	}

	/*
	 * Check the MESSAGE_OUTBOUND_PROPERTY in the context to see if this is an
	 * outgoing or incoming message. Write a brief message to the print stream
	 * and output the message. The writeTo() method can throw SOAPException or
	 * IOException
	 */
	private void logToSystemOut(SOAPMessageContext smc) {
		Boolean outboundProperty = (Boolean) smc
				.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty.booleanValue()) {
			out.println("\nOutbound message:");
        } else {
			out.println("\nInbound message:");
        }

		SOAPMessage message = smc.getMessage();

        try {
			message.writeTo(out);
			out.println(""); // just to add a newline
        } catch (Exception e) {
			out.println("Exception in handler: " + e);
        }
    }
}