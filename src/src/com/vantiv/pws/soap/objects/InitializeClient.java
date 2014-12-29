/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.soap.objects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import com.vantiv.pws.soap.handlers.PaymentsHandlerResolver;
import com.vantiv.services.merchant.payments.v6.PaymentPortType;
import com.vantiv.services.merchant.payments.v6.PaymentPortTypeService;
import com.vantiv.types.payment.transactions.v6.EchoRequest;
import com.vantiv.types.payment.transactions.v6.EchoResponse;

/**
 * This class sets up the PWS SOAP client that is used to send and receive SOAP
 * messages to PWS.
 */
public class InitializeClient {

	private PaymentPortType client = null;
	private String user = "s.MID5.PAY.WS.NP";
	private String pass = "Tu2u2AHU";
	private String wsdlLocation = "Resources/PWS V6-cert.wsdl";
	private String endpoint = "https://ws-cert.vantiv.com/merchant/payments-cert/v6";
	public PrintWriter logInPrintWriter;
	public PrintWriter logOutPrintWriter;


	public InitializeClient() {

	}
	/*
	 * Sets up and initializes the client.
	 */
	public void setup() {
		System.out.println("Setting up client...");

		// Create a URL from the file path of the wsdl
		URL url = null;
		try {
			url = new File(wsdlLocation).toURI().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		// create service
		PaymentPortTypeService service = new PaymentPortTypeService(url);

		// Handlers are used to set the security headers on the SOAP envelope.
		PaymentsHandlerResolver handlerResolver = new PaymentsHandlerResolver(
				user, pass);
		service.setHandlerResolver(handlerResolver);
		
		// create client
		client = service.getPaymentPortTypeSoap11();

		// add endpoint
		BindingProvider provider = (BindingProvider) client;

		provider.getRequestContext().put(
				BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

		/********************************************************
		 * Comment out the following to disable logging of soap
		 * requests/response
		 *******************************************************/

		File file = new File("logs/SoapLogs.txt");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		LoggingInInterceptor loggingInInterceptor = new LoggingInInterceptor(pw);
		loggingInInterceptor.setPrettyLogging(true);
		LoggingOutInterceptor loggingOutInterceptor = new LoggingOutInterceptor(
				pw);
		loggingOutInterceptor.setPrettyLogging(true);

		Client c = ClientProxy.getClient(client);
		c.getInInterceptors().add(loggingInInterceptor);
		c.getOutInterceptors().add(loggingOutInterceptor);

		/********************************************************/
		System.out.println("Done");
	}

	public PaymentPortType getTestClient() {
		return client;
	}

	/*
	 * Invokes the echo test, returns true if it was successful, false
	 * otherwise.
	 */
	public boolean invokeEchoTest() {
		System.out.println("Validating connection with echo test...");
		boolean b = false;
		EchoRequest echo = new EchoRequest();
		Date d = new Date();
		String test = "This is my echo test: " + d.getTime();
		echo.setTest(test);

		// This command can be used to see the raw xml request.
		// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
		// = true;
		EchoResponse resp = new EchoResponse();

		try {

			resp = client.echo(echo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// System.out.println(resp.getResponse());

		if (resp.getResponse().equals(test)) {
			System.out.println("Echo test successful");
			b = true;
		} else
			System.out.println("Echo test did not return the expected value");

		return b;
	}


	/**
	 * Getters and setters
	 */
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getWsdlLocation() {
		return wsdlLocation;
	}


	public PrintWriter getLogInPrintWriter() {
		return logInPrintWriter;
	}

	public void setLogInPrintWriter(PrintWriter logInPrintWriter) {
		this.logInPrintWriter = logInPrintWriter;
	}

	public PrintWriter getLogOutPrintWriter() {
		return logOutPrintWriter;
	}

	public void setLogOutPrintWriter(PrintWriter logOutPrintWriter) {
		this.logOutPrintWriter = logOutPrintWriter;
	}
	public void setWsdlLocation(String wsdlLocation) {
		this.wsdlLocation = wsdlLocation;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	// For Testing
	public static void main(String[] args) {
		InitializeClient client = new InitializeClient();
		client.setup();
		client.invokeEchoTest();

		// TestAuthorize auth = new TestAuthorize(new DataStore());

	}

}
