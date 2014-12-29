package com.vantiv.pws.soap.objects;

/**
 Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
 Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
 This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
 Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
 Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/

import com.google.gson.Gson;
import com.vantiv.pws.resources.DataStore;
import com.vantiv.services.merchant.payments.v6.PaymentPortType;
import com.vantiv.services.merchant.payments.v6.RequestValidationFault;
import com.vantiv.services.merchant.payments.v6.ServerFault;
import com.vantiv.types.payment.transactions.v6.ActivateRequest;
import com.vantiv.types.payment.transactions.v6.ActivateResponse;
import com.vantiv.types.payment.transactions.v6.AdjustRequest;
import com.vantiv.types.payment.transactions.v6.AdjustResponse;
import com.vantiv.types.payment.transactions.v6.AuthorizeRequest;
import com.vantiv.types.payment.transactions.v6.AuthorizeResponse;
import com.vantiv.types.payment.transactions.v6.BalanceInquiryRequest;
import com.vantiv.types.payment.transactions.v6.BalanceInquiryResponse;
import com.vantiv.types.payment.transactions.v6.BatchBalanceRequest;
import com.vantiv.types.payment.transactions.v6.BatchBalanceResponse;
import com.vantiv.types.payment.transactions.v6.BatchResponseType;
import com.vantiv.types.payment.transactions.v6.CancelRequest;
import com.vantiv.types.payment.transactions.v6.CancelResponse;
import com.vantiv.types.payment.transactions.v6.CaptureRequest;
import com.vantiv.types.payment.transactions.v6.CaptureResponse;
import com.vantiv.types.payment.transactions.v6.CloseBatchRequest;
import com.vantiv.types.payment.transactions.v6.CloseBatchResponse;
import com.vantiv.types.payment.transactions.v6.CloseRequest;
import com.vantiv.types.payment.transactions.v6.CloseResponse;
import com.vantiv.types.payment.transactions.v6.PurchaseRequest;
import com.vantiv.types.payment.transactions.v6.PurchaseResponse;
import com.vantiv.types.payment.transactions.v6.RefundRequest;
import com.vantiv.types.payment.transactions.v6.RefundResponse;
import com.vantiv.types.payment.transactions.v6.ReloadRequest;
import com.vantiv.types.payment.transactions.v6.ReloadResponse;
import com.vantiv.types.payment.transactions.v6.TokenizeRequest;
import com.vantiv.types.payment.transactions.v6.TokenizeResponse;
import com.vantiv.types.payment.transactions.v6.TransactionResponseType;
import com.vantiv.types.payment.transactions.v6.UnloadRequest;
import com.vantiv.types.payment.transactions.v6.UnloadResponse;

/**
 * This class is used to send/receive SOAP requests to PWS direct. To send an
 * authorize, call this.startTransaction("Authorize"). It will send a SOAP
 * request to PWS, the values for the Authorize request will be pulled from the
 * DataStore class. The response comes back as a Response Object object from
 * which you can pull the data from. The SOAP request and responses are logged
 * by CXF interceptors which is setup in InitializeClient.java.
 */
public class SoapDriver {

	private InitializeClient initClient;
	private TestAuthorize authorize;
	private TestPurchase testPurchase;
	private PaymentPortType client;
	private DataStore globals;
	private Gson gson;
	private String scriptString = "";

	/**
	 * Default constructor.
	 */
	public SoapDriver() {
		gson = new Gson();
		globals = new DataStore();
		initClient = new InitializeClient();
		initClient.setup();
		client = initClient.getTestClient();

	}

	/**
	 * Constructor that takes InitializeClient and DataStore objects.
	 */
	public SoapDriver(InitializeClient ic, DataStore ds) {
		globals = ds;
		ic.setup();
		client = ic.getTestClient();
		gson = new Gson();

	}

	/**
	 * This function takes a String which specifies the Transaction Type,
	 * Returns the response of the transaction. Based on what the transaction
	 * type is, it will call the correct function that processes the
	 * transaction. Supported transactions: Authorize, Purchase, Capture,
	 * Cancel, Adjust, Refund.
	 */
	public TransactionResponseType startTransaction(String requestType) {

		TransactionResponseType response = null;

		if (requestType.equals("Authorize")) {
			response = authorize();
		} else if (requestType.equals("Purchase")) {
			response = purchase();
		} else if (requestType.equals("Capture")) {
			response = capture();
		} else if (requestType.equals("Cancel")) {
			response = cancel();
		} else if (requestType.equals("Adjust")) {
			response = adjust();
		} else if (requestType.equals("Refund")) {
			response = refund();
		} else if (requestType.equals("Tokenize")) {
			response = tokenize();
		} else if (requestType.equals("Activate")) {
			response = activate();
		} else if (requestType.equals("BalanceInquiry")) {
			response = balanceInquiry();
		} else if (requestType.equals("Reload")) {
			response = reload();
		} else if (requestType.equals("Unload")) {
			response = unload();
		} else if (requestType.equals("Close")) {
			response = close();
		}

		return response;

	}

	public BatchResponseType batchTransaction(String batchType) {
		BatchResponseType response = null;
		if (batchType.equalsIgnoreCase("closeBatch"))
			response = this.closeBatch();
		else if (batchType.equalsIgnoreCase("batchBalance"))
			response = this.batchBalance();
		return response;
	}

	/**
	 * Send a purchase request. Return the response.
	 */
	public PurchaseResponse purchase() {
		PurchaseRequest purchase_soap = null;
		PurchaseResponse response = null;
		testPurchase = new TestPurchase(globals);
		purchase_soap = testPurchase.createPurchaseRequest();

		String json_string = null;

		try {
			response = client.purchase(purchase_soap);
		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}

		return response;

	}

	/**
	 * Send a capture request. Return the response.
	 */
	public CaptureResponse capture() {
		CaptureRequest capture = null;
		TestCapture testCapture = new TestCapture(globals);
		capture = testCapture.createCaptureRequest();
		CaptureResponse response = null;

		try {
			// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
			// = true;
			response = client.capture(capture);
		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}

		return response;

	}

	/**
	 * Send an authorize request. Return the response.
	 */
	public AuthorizeResponse authorize() {
		AuthorizeRequest auth = null;
		authorize = new TestAuthorize(globals);
		auth = authorize.createAuthorizeRequest();
		AuthorizeResponse response = null;

		// send soap request
		try {
			response = new AuthorizeResponse();
			response = client.authorize(auth);

		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}

		return response;
	}

	/**
	 * Send an cancel request. Return the response.
	 */
	public CancelResponse cancel() {
		CancelRequest cancel = null;
		TestCancel testCancel = new TestCancel(globals);
		cancel = testCancel.createCancelRequest();
		CancelResponse response = null;

		try {
			// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
			// = true;
			response = client.cancel(cancel);
		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}

		return response;
	}

	/**
	 * Send a capture request. Return the response.
	 */
	public RefundResponse refund() {
		RefundRequest refund = null;
		TestRefund testRefund = new TestRefund(globals);
		refund = testRefund.createRefundRequest();
		RefundResponse response = null;

		try {

			// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
			// = true;
			response = client.refund(refund);
		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}

		return response;
	}

	/**
	 * Send an adjust request. Return the response.
	 */
	public AdjustResponse adjust() {
		AdjustRequest adjust = null;
		TestAdjust testAdjust = new TestAdjust(globals);
		adjust = testAdjust.createAdjustRequest();
		AdjustResponse response = null;

		try {

			response = client.adjust(adjust);
		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}

		return response;
	}

	public ActivateResponse activate() {
		TestActivate testActivate = new TestActivate(globals);
		ActivateRequest activate = testActivate.createActivateRequest();
		ActivateResponse response = null;
		try {
			response = client.activate(activate);
		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}
		return response;
	}

	/**
	 * Send an cancel request. Return the response.
	 */
	public TokenizeResponse tokenize() {
		TokenizeRequest tokenize = null;
		TestTokenize testToken = new TestTokenize(globals);
		tokenize = testToken.createTokenizeRequest();
		TokenizeResponse response = null;

		try {
			// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
			// = true;
			response = client.tokenize(tokenize);
		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}

		return response;
	}

	public CloseBatchResponse closeBatch() {
		CloseBatchRequest cbr = null;
		TestCloseBatch testClose = new TestCloseBatch(globals);
		cbr = testClose.createCloseBatch();

		CloseBatchResponse response = null;

		try {
			// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
			// = true;
			response = client.closeBatch(cbr);
		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}

		return response;

	}

	public BatchBalanceResponse batchBalance() {
		BatchBalanceRequest bbr = null;
		TestBatchBalance testBalance = new TestBatchBalance(globals);
		bbr = testBalance.createBatchBalance();
		BatchBalanceResponse response = null;

		try {
			// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
			// = true;
			response = client.batchBalance(bbr);
		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}

		return response;

	}

	public BalanceInquiryResponse balanceInquiry() {
		TestBalanceInquiry tbi = new TestBalanceInquiry(globals);
		BalanceInquiryRequest request = tbi.createBalanceInquiry();
		BalanceInquiryResponse response = null;

		try {
			// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
			// = true;
			response = client.balanceInquiry(request);
		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}
		return response;
	}

	public ReloadResponse reload() {
		TestReload tl = new TestReload(globals);
		ReloadRequest request = tl.createReloadRequest();
		ReloadResponse response = null;

		try {
			// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
			// = true;
			response = client.reload(request);
		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}
		return response;
	}

	public UnloadResponse unload() {
		TestUnload tu = new TestUnload(globals);
		UnloadRequest request = tu.createReloadRequest();
		UnloadResponse response = null;

		try {
			// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
			// = true;
			response = client.unload(request);
		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}
		return response;
	}

	public CloseResponse close() {
		TestClose tc = new TestClose(globals);
		CloseRequest request = tc.createCloseRequest();
		CloseResponse response = null;

		try {
			// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
			// = true;
			response = client.close(request);
		} catch (ServerFault e) {
			System.out.println("ServerFault: " + e.getFaultInfo().getMessage());
		} catch (RequestValidationFault e) {
			System.out.println("ValidationFault: "
					+ e.getFaultInfo().getMessage());
		} catch (Exception e) {
			System.out.println("Transaction error: " + e.getMessage());
		}
		return response;
	}

	// getters and setters
	public String getScriptString() {
		return scriptString;
	}

	public void setScriptString(String scriptString) {
		this.scriptString = scriptString;
	}

	/**
	 * For testing...
	 */
	public static void main(String[] args) {
		SoapDriver d = new SoapDriver();
		d.startTransaction("Authorize");

	}

}
