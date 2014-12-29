/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.soap.objects;

import com.vantiv.pws.resources.DataStore;
import com.vantiv.pws.resources.Utils;
import com.vantiv.services.merchant.payments.v6.PaymentPortType;
import com.vantiv.services.merchant.payments.v6.RequestValidationFault;
import com.vantiv.services.merchant.payments.v6.ServerFault;
import com.vantiv.types.payment.transactions.v6.AuthorizeRequest;
import com.vantiv.types.payment.transactions.v6.AuthorizeResponse;
import com.vantiv.types.payment.transactions.v6.PaymentType;
import com.vantiv.types.payment.transactions.v6.TransactionTypeType;

public class TestAuthorize {

	private AuthorizeRequest request = null;
	private Utils util = new Utils();
	private DataStore globals;

	public TestAuthorize(DataStore ds) {
		request = new AuthorizeRequest();
		globals = ds;
	}

	public AuthorizeRequest createAuthorizeRequest() {
		request.setDraftLocatorId(globals.getDraftLocatorId());
		request.setMerchantRefId(globals.getMerchantRefId());

		request.setNetworkResponseCode(globals.getNetworkResponseCode());
		request.setPurchaseOrder(globals.getPurchaseOrder());
		request.setReferenceNumber(globals.getReferenceNumber());
		request.setReportGroup(globals.getReportGroup());
		request.setSystemTraceId(globals.getSystemTraceId());
		request.setTokenRequested(globals.isTokenRequested());
		request.setBillPaymentPayee(globals.getBillPaymentPayeeType());


		// set credit/debit/gift
		if (globals.isCredit())
			request.setCredit(globals.getCreditInstument());
		else
			request.setGift(globals.getGiftCard());
		// auth.setIncrementalAuthorization(value);
		request.setMerchant(globals.getMerchant());
		request.setPaymentType(PaymentType.fromValue(globals.getPaymentType()));
		if (globals.isPurchaseLevel())
			request.setTax(globals.getTax());
		// auth.setTokenRequested(value);
		request.setTransactionAmount(globals.getTransactionAmountType());
		request.setTransactionTimestamp(util.stringToXMLGregorian(globals
				.getTransactionTimestamp()));
		request.setTransactionType(TransactionTypeType.fromValue(globals
				.getTransactionType()));

		return request;
	}

	// This is for testing in the main method..
	public void invokeAuthorize(PaymentPortType client) {

		AuthorizeResponse resp = new AuthorizeResponse();
		request = createAuthorizeRequest();

		try {
			resp = client.authorize(request);
		} catch (ServerFault e) {
			System.out
					.println("Server Fault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("Validation Fault: "
					+ e.getFaultInfo().getMessage());
		}
		System.out.println(resp.getTransactionStatus());

	}

	// For preliminary testing of the authorize request
	public static void main(String[] args) {
		DataStore ds = new DataStore();
		TestAuthorize auth = new TestAuthorize(ds);
		InitializeClient client = new InitializeClient();
		client.setup();
		PaymentPortType soapClient = client.getTestClient();
		auth.invokeAuthorize(soapClient);

	}

}
