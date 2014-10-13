
package com.vantiv.pws.soap.objects;

/**
 Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
 Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
 This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
 Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
 Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/

import java.util.HashMap;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;
import com.vantiv.pws.apigee.objects.ApigeeObject;
import com.vantiv.pws.apigee.objects.PWS_ElementTranslator;
import com.vantiv.services.merchant.payments.v6.PaymentPortType;
import com.vantiv.services.merchant.payments.v6.RequestValidationFault;
import com.vantiv.services.merchant.payments.v6.ServerFault;
import com.vantiv.types.payment.instruments.v6.TokenType;
import com.vantiv.types.payment.transactions.v6.AdjustRequest;
import com.vantiv.types.payment.transactions.v6.AdjustResponse;
import com.vantiv.types.payment.transactions.v6.AuthorizeRequest;
import com.vantiv.types.payment.transactions.v6.AuthorizeResponse;
import com.vantiv.types.payment.transactions.v6.BatchBalanceRequest;
import com.vantiv.types.payment.transactions.v6.BatchBalanceResponse;
import com.vantiv.types.payment.transactions.v6.BatchRequestType;
import com.vantiv.types.payment.transactions.v6.BatchResponseType;
import com.vantiv.types.payment.transactions.v6.CancelRequest;
import com.vantiv.types.payment.transactions.v6.CancelResponse;
import com.vantiv.types.payment.transactions.v6.CaptureRequest;
import com.vantiv.types.payment.transactions.v6.CaptureResponse;
import com.vantiv.types.payment.transactions.v6.CloseBatchRequest;
import com.vantiv.types.payment.transactions.v6.CloseBatchResponse;
import com.vantiv.types.payment.transactions.v6.PurchaseRequest;
import com.vantiv.types.payment.transactions.v6.PurchaseResponse;
import com.vantiv.types.payment.transactions.v6.RefundRequest;
import com.vantiv.types.payment.transactions.v6.RefundResponse;
import com.vantiv.types.payment.transactions.v6.TokenizationResultType;
import com.vantiv.types.payment.transactions.v6.TokenizeRequest;
import com.vantiv.types.payment.transactions.v6.TokenizeResponse;
import com.vantiv.types.payment.transactions.v6.TransactionRequestType;
import com.vantiv.types.payment.transactions.v6.TransactionResponseType;
import com.vantiv.types.payment.transactions.v6.TransactionStatusType;

/**
 * This class is used to send SOAP/JSON requests to PWS or Apigee.
 */
public class Driver {

	private InitializeClient initClient;
	private TestAuthorize authorize;
	private TestPurchase testPurchase;
	private PaymentPortType client;
	private DataStore globals;
	private Gson gson;
	private boolean sendToApigee = true;
	private boolean sendToPWS = false;
	private String scriptString = "";
	private String apiKey = "5HNcmF1tAvUgbYg5aw7YAOzkkBF7FWTT";

	private static Logger logger = org.apache.log4j.Logger
			.getLogger("ApigeeLogger");

	/**
	 * Default constructor.
	 */
	public Driver() {
		gson = new Gson();
		globals = new DataStore();
		initClient = new InitializeClient();
		initClient.setup();
		client = initClient.getTestClient();


	}

	/**
	 * Constructor that takes InitializeClient and DataStore objects.
	 */
	public Driver(InitializeClient ic, DataStore ds) {
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
		}


		return response;

	}

	public BatchResponseType batchTransaction(String batchType) {
		BatchResponseType response = null;
		if (batchType.equalsIgnoreCase("closeBatch"))
			response = this.closeBatch();
		else if(batchType.equalsIgnoreCase("batchBalance"))
			response = this.batchBalance();
		return response;
	}

	/**
	 * Send a purchase request. Return the response.
	 */
	public PurchaseResponse purchase() {
		PurchaseRequest purchase = null;
		PurchaseResponse response = null;
		testPurchase = new TestPurchase(globals);
		purchase = testPurchase.createPurchaseRequest();
		HttpResponse httpResp = null;

		String json_string = null;

		if (sendToApigee) {
			httpResp = sendToApigee(purchase, null);
			json_string = null;
			try {
				json_string = EntityUtils.toString(httpResp.getEntity());
				logHttpResponse(json_string);
			} catch (Exception e) {

			}
		}

		if (sendToPWS) {
			try {
				response = client.purchase(purchase);
			} catch (ServerFault e) {
				System.out.println("ServerFault: "
						+ e.getFaultInfo().getMessage());
			} catch (RequestValidationFault e) {
				System.out.println("ValidationFault: "
						+ e.getFaultInfo().getMessage());
			} catch (Exception e) {
				System.out.println("Transaction error: " + e.getMessage());
			}
		}

		// If response is null, then that means that the transaction was not
		// sent to PWS direct and we need to evaluate the HTTPResponse from
		// apigee. We will still return a Response object, but it will need
		// to be created from the apigee response.
		if (response == null) {
			response = new PurchaseResponse();
			response = (PurchaseResponse) createResponseFromApigee(response,
					json_string);
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
		HttpResponse httpResp = null;
		String json_string = null;

		if (sendToApigee) {
			httpResp = sendToApigee(capture, null);
			json_string = null;
			try {
				json_string = EntityUtils.toString(httpResp.getEntity());
				logHttpResponse(json_string);
			} catch (Exception e) {

			}
		}
		if (sendToPWS) {
			try {
				// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
				// = true;
				response = client.capture(capture);
			} catch (ServerFault e) {
				System.out.println("ServerFault: "
						+ e.getFaultInfo().getMessage());
			} catch (RequestValidationFault e) {
				System.out.println("ValidationFault: "
						+ e.getFaultInfo().getMessage());
			} catch (Exception e) {
				System.out.println("Transaction error: " + e.getMessage());
			}
		}


		// If response is null, then that means that the transaction was not
		// sent to PWS direct and we need to evaluate the HTTPResponse from
		// apigee. We will still return a Response object, but it will need
		// to be created from the apigee response.
		if (response == null) {
			response = new CaptureResponse();
			response = (CaptureResponse) createResponseFromApigee(response,
					json_string);
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
		HttpResponse httpResp = null;
		String json_string = null;

		// send json request to apigee
		if (sendToApigee) {
			httpResp = sendToApigee(auth, null);
			json_string = null;
			try {
				json_string = EntityUtils.toString(httpResp.getEntity());
				logHttpResponse(json_string);
			} catch (Exception e) {

			}
		}

		if (sendToPWS) {
			// send soap request
			try {
				response = new AuthorizeResponse();
				response = client.authorize(auth);

			} catch (ServerFault e) {
				System.out.println("ServerFault: "
						+ e.getFaultInfo().getMessage());
			} catch (RequestValidationFault e) {
				System.out.println("ValidationFault: "
						+ e.getFaultInfo().getMessage());
			} catch (Exception e) {
				System.out.println("Transaction error: " + e.getMessage());
			}

		}


		// If response is null, then that means that the transaction was not
		// sent to PWS direct and we need to evaluate the HTTPResponse from
		// apigee. We will still return a Response object, but it will need
		// to be created from the apigee response.
		if (response == null) {
			response = new AuthorizeResponse();
			response = (AuthorizeResponse) createResponseFromApigee(response,
					json_string);
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
		HttpResponse httpResp = null;

		String json_string = null;

		if (sendToApigee) {
			httpResp = sendToApigee(cancel, null);
			json_string = null;
			try {
				json_string = EntityUtils.toString(httpResp.getEntity());
				logHttpResponse(json_string);
			} catch (Exception e) {

			}
		}
		if (sendToPWS) {
			try {
				// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
				// = true;
				response = client.cancel(cancel);
			} catch (ServerFault e) {
				System.out.println("ServerFault: "
						+ e.getFaultInfo().getMessage());
			} catch (RequestValidationFault e) {
				System.out.println("ValidationFault: "
						+ e.getFaultInfo().getMessage());
			} catch (Exception e) {
				System.out.println("Transaction error: " + e.getMessage());
			}
		}

		// If response is null, then that means that the transaction was not
		// sent to PWS direct and we need to evaluate the HTTPResponse from
		// apigee. We will still return a Response object, but it will need
		// to be created from the apigee response.
		if (response == null) {
			response = new CancelResponse();
			response = (CancelResponse) createResponseFromApigee(response,
					json_string);
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
		HttpResponse httpResp = null;

		String json_string = null;

		if (sendToApigee) {
			httpResp = sendToApigee(refund, null);
			json_string = null;
			try {
				json_string = EntityUtils.toString(httpResp.getEntity());
				logHttpResponse(json_string);
			} catch (Exception e) {

			}
		}

		if (sendToPWS) {
			try {

				// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
				// = true;
				response = client.refund(refund);
			} catch (ServerFault e) {
				System.out.println("ServerFault: "
						+ e.getFaultInfo().getMessage());
			} catch (RequestValidationFault e) {
				System.out.println("ValidationFault: "
						+ e.getFaultInfo().getMessage());
			} catch (Exception e) {
				System.out.println("Transaction error: " + e.getMessage());
			}
		}

		// If response is null, then that means that the transaction was not
		// sent to PWS direct and we need to evaluate the HTTPResponse from
		// apigee. We will still return a Response object, but it will need
		// to be created from the apigee response.
		if (response == null) {
			response = new RefundResponse();
			response = (RefundResponse) createResponseFromApigee(response,
					json_string);
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
		HttpResponse httpResp = null;

		String json_string = null;

		if (sendToApigee) {
			httpResp = sendToApigee(adjust, null);
			json_string = null;
			try {
				json_string = EntityUtils.toString(httpResp.getEntity());
				logHttpResponse(json_string);
			} catch (Exception e) {

			}
		}

		if (sendToPWS) {
			try {
				// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
				// = true;
				response = client.adjust(adjust);
			} catch (ServerFault e) {
				System.out.println("ServerFault: "
						+ e.getFaultInfo().getMessage());
			} catch (RequestValidationFault e) {
				System.out.println("ValidationFault: "
						+ e.getFaultInfo().getMessage());
			} catch (Exception e) {
				System.out.println("Transaction error: " + e.getMessage());
			}
		}

		// If response is null, then that means that the transaction was not
		// sent to PWS direct and we need to evaluate the HTTPResponse from
		// apigee. We will still return a Response object, but it will need
		// to be created from the apigee response.
		if (response == null) {
			response = new AdjustResponse();
			response = (AdjustResponse) createResponseFromApigee(response,
					json_string);
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
		HttpResponse httpResp = null;

		String json_string = null;

		if (sendToApigee) {
			httpResp = sendToApigee(tokenize, null);
			json_string = null;
			try {
				json_string = EntityUtils.toString(httpResp.getEntity());
				logHttpResponse(json_string);
			} catch (Exception e) {

			}
		}
		if (sendToPWS) {
			try {
				// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
				// = true;
				response = client.tokenize(tokenize);
			} catch (ServerFault e) {
				System.out.println("ServerFault: "
						+ e.getFaultInfo().getMessage());
			} catch (RequestValidationFault e) {
				System.out.println("ValidationFault: "
						+ e.getFaultInfo().getMessage());
			} catch (Exception e) {
				System.out.println("Transaction error: " + e.getMessage());
			}
		}

		// If response is null, then that means that the transaction was not
		// sent to PWS direct and we need to evaluate the HTTPResponse from
		// apigee. We will still return a Response object, but it will need
		// to be created from the apigee response.
		if (response == null) {
			response = new TokenizeResponse();
			response = (TokenizeResponse) createResponseFromApigee(response,
					json_string);
		}
		return response;
	}

	public CloseBatchResponse closeBatch() {
		CloseBatchRequest cbr = null;
		TestCloseBatch testClose = new TestCloseBatch(globals);
		cbr = testClose.createCloseBatch();

		CloseBatchResponse response = null;
		HttpResponse httpResp = null;

		String json_string = null;

		if (sendToApigee) {
			httpResp = sendToApigee(null, cbr);
			json_string = null;
			try {
				json_string = EntityUtils.toString(httpResp.getEntity());
				logHttpResponse(json_string);
			} catch (Exception e) {

			}
		}
		if (sendToPWS) {
			try {
				// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
				// = true;
				response = client.closeBatch(cbr);
			} catch (ServerFault e) {
				System.out.println("ServerFault: "
						+ e.getFaultInfo().getMessage());
			} catch (RequestValidationFault e) {
				System.out.println("ValidationFault: "
						+ e.getFaultInfo().getMessage());
			} catch (Exception e) {
				System.out.println("Transaction error: " + e.getMessage());
			}
		}
		return response;

	}

	public BatchBalanceResponse batchBalance() {
		BatchBalanceRequest bbr = null;
		TestBatchBalance testBalance = new TestBatchBalance(globals);
		bbr = testBalance.createBatchBalance();
		BatchBalanceResponse response = null;
		HttpResponse httpResp = null;

		String json_string = null;

		if (sendToApigee) {
			httpResp = sendToApigee(null, bbr);
			json_string = null;
			try {
				json_string = EntityUtils.toString(httpResp.getEntity());
				logHttpResponse(json_string);
			} catch (Exception e) {

			}
		}
		if (sendToPWS) {
			try {
				// com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump
				// = true;
				response = client.batchBalance(bbr);
			} catch (ServerFault e) {
				System.out.println("ServerFault: "
						+ e.getFaultInfo().getMessage());
			} catch (RequestValidationFault e) {
				System.out.println("ValidationFault: "
						+ e.getFaultInfo().getMessage());
			} catch (Exception e) {
				System.out.println("Transaction error: " + e.getMessage());
			}
		}
		return response;

	}


	/**
	 * This method takes a transaction request, converts it to a json object and
	 * then sends it to Apigee. It returns the HttpResponse from apigee.
	 */
	public HttpResponse sendToApigee(TransactionRequestType requestType,
			BatchRequestType batchRequest) {
		String apiUrl = "http://vantiv-nonprod-dev.apigee.net/v1/credit/";
		if (requestType != null) {
			if (requestType.getClass() == AuthorizeRequest.class
					|| requestType.getClass() == TokenizeRequest.class) {
				apiUrl += "authorization?sp=1";
			} else if (requestType.getClass() == CaptureRequest.class) {
				apiUrl += "authorizationcompletion?sp=1";
			} else if (requestType.getClass() == CancelRequest.class) {
				apiUrl += "reversal?sp=1";
			} else if (requestType.getClass() == PurchaseRequest.class) {
				apiUrl += "sale?sp=1";
			} else if (requestType.getClass() == RefundRequest.class) {
				apiUrl += "return?sp=1";
			}
		} else if (batchRequest != null)
			if (batchRequest.getClass() == CloseBatchRequest.class) {
				apiUrl += "batchclose?sp=1";
			} else if (batchRequest.getClass() == BatchBalanceRequest.class) {
				apiUrl += "batchbalance?sp=1";
		}
		// System.out.println(apiUrl);

		// JSON management
		PWS_ElementTranslator translator = new PWS_ElementTranslator();
		ApigeeObject elementObj = translator
				.translateFieldstoElement(requestType, batchRequest);
		String elementJson = gson.toJson(elementObj);

		logger.debug("JSON Request: " + elementJson);

		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = null;
		try {
			HttpPost request = new HttpPost(apiUrl);
			StringEntity params = new StringEntity(elementJson);
			request.addHeader("apikey", apiKey);
			request.addHeader("Content-Type", "application/json");
			request.setEntity(params);

			httpResponse = httpClient.execute(request);
		} catch (Exception e) {
			logger.error("Error sending json request to apigee: "
					+ e.getMessage());
		}



		return httpResponse;
	}

	/**
	 * Convert a HttpResponse Object to a JSONObject
	 */
	public JSONObject stringToJsonObject(String response) {


		JSONObject json_object = null;
		try {
			json_object = new JSONObject(response);
		} catch (JSONException e) {
			System.out
					.println("Error converting http response string to json object: "
							+ e);

		}
		return json_object;

	}

	/**
	 * Create a HashMap of all values that are contained in the http response
	 * from apigee. The HttpResponse must already be converted to a JSON object.
	 * This is used when we send a transaction request to Apigee instead of PWS
	 * direct.
	 */
	public HashMap<String, String> parseJsonResponse(JSONObject json_object){
		HashMap<String, String> map = new HashMap<String, String>();
		
		Iterator i = null;
		
		String responseType = null;
		
		
		if (json_object != null)
			i = json_object.keys();
		try {
			if (i.hasNext()) {
				// System.out.println("Root: " + jsonRoot);
				responseType = (String) i.next();
				if (!responseType.equalsIgnoreCase("error")) {
					map.put("ResponseType", responseType);

					JSONObject responseData = (JSONObject) json_object
							.get(responseType);

					if (responseData.has("ReferenceNumber"))
						map.put("ReferenceNumber",
								responseData.getString("ReferenceNumber"));
					if (responseData.has("AuthorizationCode"))
						map.put("AuthorizationCode",
								responseData.getString("AuthorizationCode"));
					if (responseData.has("TokenizationResult")) {
						JSONObject tokenResult = responseData
								.getJSONObject("TokenizationResult");
						if (tokenResult.has("tokenType")) {
							map.put("TokenId",
									tokenResult.getJSONObject("tokenType")
											.getString("tokenId"));
							map.put("TokenValue",
									tokenResult.getJSONObject("tokenType")
											.getString("tokenValue"));
						}
					}
					if (responseData.has("TransactionStatus"))
						map.put("TransactionStatus",
								responseData.getString("TransactionStatus"));
					if (responseData.has("AddressVerificationResult")) {
						JSONObject addressResult = responseData
								.getJSONObject("AddressVerificationResult");
						map.put("AddressVerificationCode",
								addressResult.getString("Code"));
						map.put("AddressVerificationType",
								addressResult.getString("Type"));
					}
					if (responseData.has("PaymentServiceResults")) {
						JSONObject paymentResults = responseData
								.getJSONObject("PaymentServiceResults");
						Iterator ii = paymentResults.keys();
						if (ii.hasNext()) {
							String cardType = (String) ii.next();
							if (cardType.equals("VisaResults")) {
								JSONObject cardResult = paymentResults
										.getJSONObject(cardType);
								map.put("TransactionId",
										cardResult.getString("TransactionId"));
								map.put("ValidationCode",
										cardResult.getString("ValidationCode"));
							}
						}

					}
					if (responseData.has("DeclineCode"))
						map.put("DeclineCode",
								responseData.getString("DeclineCode"));
					if (responseData.has("DeclineMessage"))
						map.put("DeclineMessage",
								responseData.getString("DeclineMessage"));
					
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR converting to hashMap: " + e);
			logger.error("JSON ERROR: " + e.getMessage());
		}
		return map;
		
	}

	/**
	 * Create a transaction response object from a Json string that was returned
	 * via apigee. This is used when we send a request through apigee instead of
	 * PWS direct.
	 */
	public TransactionResponseType createResponseFromApigee(
			TransactionResponseType response, String json_string) {
		HashMap<String, String> map = parseJsonResponse(stringToJsonObject(json_string));
		if (map.containsKey("AuthorizationCode"))
			response.setAuthorizationCode(map.get("AuthorizationCode"));
		if (map.containsKey("ReferenceNumber"))
			response.setReferenceNumber(map.get("ReferenceNumber"));
		if (map.containsKey("TokenId") && map.containsKey("TokenValue")) {
			TokenType tokenType = new TokenType();
			tokenType.setTokenId(map.get("TokenId"));
			tokenType.setTokenValue(map.get("TokenValue"));
			TokenizationResultType trt = new TokenizationResultType();
			trt.setTokenType(tokenType);
			response.setTokenizationResult(trt);
		}

		if (map.containsKey("TransactionStatus")) {
			String t = map.get("TransactionStatus");

			// apigee refunds are called "returns", so have to convert it to
			// "refunded"
			if (t.equalsIgnoreCase("returned"))
				t = "refunded";
			else if (t.equalsIgnoreCase("partially_reversed"))
				t = "partially_canceled";
			else if (t.equalsIgnoreCase("reversed"))
				t = "canceled";

			response.setTransactionStatus(TransactionStatusType.fromValue(t));


		}
		if (map.containsKey("DeclineCode"))
			response.setDeclineCode(map.get("DeclineCode"));
		if (map.containsKey("DeclineMessage"))
			response.setDeclineMessage(map.get("DeclineMessage"));

		return response;
	}

	/**
	 * This gets the Json object from the HttpResponse and logs it.
	 */
	public void logHttpResponse(String response) {

		logger.debug("JSON Response: " + response);

		Iterator i = null;

		String responseType = null;
		String requestId = null;

		JSONObject jsonRoot = null;
		try {
			jsonRoot = new JSONObject(response);
		} catch (JSONException e1) {
			System.out.println("Error converting string response to json: "
					+ e1);
		}

		if (jsonRoot != null)
			i = jsonRoot.keys();
		try {
			if (i.hasNext()) {
				// System.out.println("Root: " + jsonRoot);
				responseType = (String) i.next();
				// System.out.println("ResponseType: " + responseType);

				JSONObject jsonResponse = (JSONObject) jsonRoot
						.get(responseType);
				// System.out.println(jsonResponse);
				requestId = jsonResponse.getString("RequestId");
				// System.out.println(requestId);

				logger.info("TestName: " + globals.getTestName()
						+ " RequestId: " + requestId);
				scriptString += globals.getTestName() + " , " + requestId
						+ "\n";

			}
		} catch (Exception e) {
			logger.error("JSON ERROR: " + e.getMessage());
		}
		// System.out.println(jsonRoot);
		// System.out.println(requestId);

	}

	// getters and setters
	public String getScriptString() {
		return scriptString;
	}


	public void setScriptString(String scriptString) {
		this.scriptString = scriptString;
	}

	public boolean isSendToApigee() {
		return sendToApigee;
	}

	public void setSendToApigee(boolean sendToApigee) {
		this.sendToApigee = sendToApigee;
	}

	/**
	 * For testing...
	 */
	public static void main(String[] args) {
		Driver d = new Driver();
		d.startTransaction("Authorize");

	}

}
