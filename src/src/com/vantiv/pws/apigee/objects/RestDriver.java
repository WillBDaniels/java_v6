/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.apigee.objects;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.vantiv.pws.resources.DataStore;
import com.vantiv.types.payment.instruments.v6.TokenType;
import com.vantiv.types.payment.transactions.v6.ActivateResponse;
import com.vantiv.types.payment.transactions.v6.AdjustResponse;
import com.vantiv.types.payment.transactions.v6.AuthorizeResponse;
import com.vantiv.types.payment.transactions.v6.BalanceInquiryResponse;
import com.vantiv.types.payment.transactions.v6.CancelResponse;
import com.vantiv.types.payment.transactions.v6.CaptureResponse;
import com.vantiv.types.payment.transactions.v6.CloseResponse;
import com.vantiv.types.payment.transactions.v6.PurchaseResponse;
import com.vantiv.types.payment.transactions.v6.RefundResponse;
import com.vantiv.types.payment.transactions.v6.ReloadResponse;
import com.vantiv.types.payment.transactions.v6.TokenizationResultType;
import com.vantiv.types.payment.transactions.v6.TokenizeResponse;
import com.vantiv.types.payment.transactions.v6.TransactionResponseType;
import com.vantiv.types.payment.transactions.v6.TransactionStatusType;
import com.vantiv.types.payment.transactions.v6.UnloadResponse;

/**
 * This class is used to send/receive JSON requests to Apigee through RESTFUL
 * services. To send an authorize, call this.startTransaction("Authorize"). It
 * will send a JSON request over HTTP to Apigee, the values for the Authorize
 * request will be pulled from the DataStore class. The response comes back as a
 * JSON object from which you can pull the data from. This class converts the
 * JSON response into a Response object. The request and responses are logged by
 * log4j. The log4j properties file can be found in the Resources folder.
 */
public class RestDriver {

	private SendJsonRequest sjr;
	private CreateJsonRequest cjr;
	private DataStore globals;
	private static Logger logger = org.apache.log4j.Logger
			.getLogger(RestDriver.class);
	private String scriptString = "";

	public RestDriver(DataStore ds) {
		this.globals = ds;
		sjr = new SendJsonRequest(globals);
		cjr = new CreateJsonRequest(globals);
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
		} else if (requestType.equals("CloseBatch")) {
			response = closeBatch();
		} else if (requestType.equals("BatchBalance")) {
			response = batchBalance();

		} else if (requestType.equals("Activate")) {
			response = activate();
		} else if (requestType.equals("Reload")) {
			response = reload();
		} else if (requestType.equals("Unload")) {
			response = unload();
		} else if (requestType.equals("Close")) {
			response = close();
		} else if (requestType.equals("BalanceInquiry")) {
			response = balanceInquiry();
		}


		return response;

	}

	public PurchaseResponse purchase() {
		HttpResponse httpResp = null;
		String json_string = null;

		ApigeeObject ao = cjr.createPurchase();
		if (globals.isCredit())
			httpResp = sjr.sendJson(ao, "purchase");
		else if (globals.isDebit())
			httpResp = sjr.sendJson(ao, "purchaseDebit");
		else if (globals.isGift())
			httpResp = sjr.sendJson(ao, "purchaseGift");

		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {

		}

		PurchaseResponse response = new PurchaseResponse();
		response = (PurchaseResponse) createResponseFromApigee(response,
				json_string);

		return response;

	}

	/**
	 * Send a capture request. Return the response.
	 */
	public CaptureResponse capture() {

		CaptureResponse response = null;
		HttpResponse httpResp = null;
		String json_string = null;

		ApigeeObject ao = cjr.createCapture();
		if (globals.isCredit())
			httpResp = sjr.sendJson(ao, "capture");
		else if (globals.isDebit())
			httpResp = sjr.sendJson(ao, "captureDebit");
		else if (globals.isGift())
			httpResp = sjr.sendJson(ao, "captureGift");

		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {
			System.out.println("ERROR creating json string: " + e.getMessage());
		}

		response = new CaptureResponse();
		response = (CaptureResponse) createResponseFromApigee(response,
				json_string);

		return response;

	}

	/**
	 * Send an authorize request. Return the response.
	 */
	public AuthorizeResponse authorize() {

		AuthorizeResponse response = null;
		HttpResponse httpResp = null;
		String json_string = null;

		ApigeeObject ao = cjr.createAuthorize();

		if (globals.isCredit())
			httpResp = sjr.sendJson(ao, "authorize");
		else if (globals.isGift())
			httpResp = sjr.sendJson(ao, "authorizeGift");
		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {

		}

		response = new AuthorizeResponse();
		response = (AuthorizeResponse) createResponseFromApigee(response,
				json_string);
		return response;
	}

	/**
	 * Send an cancel request. Return the response.
	 */
	public CancelResponse cancel() {

		CancelResponse response = null;
		HttpResponse httpResp = null;

		String json_string = null;

		ApigeeObject ao = cjr.createCancel();
		if (globals.isCredit())
			httpResp = sjr.sendJson(ao, "cancel");
		else if (globals.isDebit())
			httpResp = sjr.sendJson(ao, "cancelDebit");
		else if (globals.isGift())
			httpResp = sjr.sendJson(ao, "cancelGift");
		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {

		}

		response = new CancelResponse();
		response = (CancelResponse) createResponseFromApigee(response,
				json_string);

		return response;
	}

	/**
	 * Send a capture request. Return the response.
	 */
	public RefundResponse refund() {

		RefundResponse response = null;
		HttpResponse httpResp = null;

		String json_string = null;

		ApigeeObject ao = cjr.createRefund();
		if (globals.isCredit())
			httpResp = sjr.sendJson(ao, "refund");
		else if (globals.isDebit())
			httpResp = sjr.sendJson(ao, "refundDebit");
		else if (globals.isGift())
			httpResp = sjr.sendJson(ao, "refundGift");
		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {

		}

		response = new RefundResponse();
		response = (RefundResponse) createResponseFromApigee(response,
				json_string);

		return response;
	}

	/**
	 * Send an adjust request. Return the response.
	 */
	public AdjustResponse adjust() {

		AdjustResponse response = null;
		HttpResponse httpResp = null;

		String json_string = null;

		ApigeeObject ao = cjr.createAdjust();

		httpResp = sjr.sendJson(ao, "adjust");
		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {

		}

		response = new AdjustResponse();
		response = (AdjustResponse) createResponseFromApigee(response,
				json_string);

		return response;
	}

	/**
	 * Send an cancel request. Return the response.
	 */
	public TokenizeResponse tokenize() {

		TokenizeResponse response = null;
		HttpResponse httpResp = null;

		String json_string = null;

		ApigeeObject ao = cjr.createTokenize();
		httpResp = sjr.sendJson(ao, "tokenize");
		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {

		}

		response = new TokenizeResponse();
		response = (TokenizeResponse) createResponseFromApigee(response,
				json_string);

		return response;
	}

	public TransactionResponseType closeBatch() {
		System.out.println("CLOSEBATCH");
		TransactionResponseType response = null;
		HttpResponse httpResp = null;

		String json_string = null;

		ApigeeObject ao = cjr.createBatchClose();
		httpResp = sjr.sendJson(ao, "batchClose");
		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {
			System.out.println("error logging close batch");
		}

		return response;

	}

	public TransactionResponseType batchBalance() {

		TransactionResponseType response = null;
		HttpResponse httpResp = null;

		String json_string = null;

		ApigeeObject ao = cjr.createBatchBalance();
		httpResp = sjr.sendJson(ao, "batchBalance");
		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {

		}

		return response;

	}


	public ActivateResponse activate() {
		ActivateResponse response = null;
		HttpResponse httpResp = null;

		String json_string = null;

		ApigeeObject ao = cjr.createActivate();
		httpResp = sjr.sendJson(ao, "activate");
		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {

		}

		response = new ActivateResponse();
		response = (ActivateResponse) createResponseFromApigee(response,
				json_string);

		return response;
	}

	public ReloadResponse reload() {
		ReloadResponse response = null;
		HttpResponse httpResp = null;

		String json_string = null;

		ApigeeObject ao = cjr.createReload();
		httpResp = sjr.sendJson(ao, "reload");
		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {

		}

		response = new ReloadResponse();
		response = (ReloadResponse) createResponseFromApigee(response,
				json_string);

		return response;
	}

	public UnloadResponse unload() {
		UnloadResponse response = null;
		HttpResponse httpResp = null;

		String json_string = null;

		ApigeeObject ao = cjr.createUnload();
		httpResp = sjr.sendJson(ao, "unload");
		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {

		}

		response = new UnloadResponse();
		response = (UnloadResponse) createResponseFromApigee(response,
				json_string);

		return response;
	}

	public CloseResponse close() {
		CloseResponse response = null;
		HttpResponse httpResp = null;

		String json_string = null;

		ApigeeObject ao = cjr.createClose();
		httpResp = sjr.sendJson(ao, "close");
		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {

		}

		response = new CloseResponse();
		response = (CloseResponse) createResponseFromApigee(response,
				json_string);

		return response;
	}

	public BalanceInquiryResponse balanceInquiry() {
		BalanceInquiryResponse response = null;
		HttpResponse httpResp = null;

		String json_string = null;

		ApigeeObject ao = cjr.createBalanceInquiry();
		httpResp = sjr.sendJson(ao, "balanceInquiry");
		json_string = null;
		try {
			json_string = EntityUtils.toString(httpResp.getEntity());
			logHttpResponse(json_string);
		} catch (Exception e) {

		}

		response = new BalanceInquiryResponse();
		response = (BalanceInquiryResponse) createResponseFromApigee(response,
				json_string);

		return response;
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
	 * Create a HashMap of all(most) values that are contained in the http
	 * response from apigee. The HttpResponse must already be converted to a
	 * JSON object. This is used when we send a transaction request to Apigee
	 * instead of PWS direct.
	 */
	public HashMap<String, String> parseJsonResponse(JSONObject json_object) {
		HashMap<String, String> map = new HashMap<String, String>();

		Iterator i = null;

		String responseType = null;

		if (json_object != null)
			i = json_object.keys();
		try {
			if (i.hasNext()) {
				responseType = (String) i.next();

				if (responseType.equals("error")) {
					System.out.println("ERROR: " + json_object);
					logger.error("Error: " + json_object);
					map.put("Error", "" + json_object);
				} else {
					JSONObject responseData = (JSONObject) json_object
							.get(responseType);

					map.put("ResponseType", responseType);
					// If there is a fault, put it in the decline message/code
					// field
					if (responseType.equalsIgnoreCase("fault")) {
						if (responseData.has("faultstring"))
							map.put("DeclineMessage",
									responseData.getString("faultstring"));
						if (responseData.has("errorcode"))
							map.put("DeclineCode",
									responseData.getJSONObject("detail")
											.getString("errorcode"));
						else if (responseData.has("detail")) {
							map.put("DeclineCode",
									responseData.getJSONObject("detail")
											.getJSONObject("ApplicationFault")
											.getString("message"));
						} else {
							map.put("DeclineCode",
									"Unrecognizable ERROR, please review logs");
						}

					} else {
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
						if (responseData.has("_system-trace-id")) {
							map.put("SystemTraceId",
									responseData.getString("_system-trace-id"));

						} else if (responseData.has("@system-trace-id")) {
							map.put("SystemTraceId",
									responseData.getString("@system-trace-id"));
							// System.out.println("HERE2");
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
									map.put("TransactionId", cardResult
											.getString("TransactionId"));
									map.put("ValidationCode", cardResult
											.getString("ValidationCode"));
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
		if (map.containsKey("Error")) {
			System.out.println("ERROR: " + map.get("Error"));
			// System.out.println("Terminating program...");
			logger.error("ERROR: " + map.get("Error"));
			// logger.error("Terminating program...");
			// System.exit(1);
		} else {
			if (map.containsKey("AuthorizationCode"))
				response.setAuthorizationCode(map.get("AuthorizationCode"));
			if (map.containsKey("ReferenceNumber"))
				response.setReferenceNumber(map.get("ReferenceNumber"));
			if (map.containsKey("SystemTraceId"))
				response.setSystemTraceId(Long.parseLong(map
						.get("SystemTraceId")));
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

				response.setTransactionStatus(TransactionStatusType
						.fromValue(t));

			}
			if (map.containsKey("DeclineCode"))
				response.setDeclineCode(map.get("DeclineCode"));
			if (map.containsKey("DeclineMessage"))
				response.setDeclineMessage(map.get("DeclineMessage"));


		}
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
		String referenceNumber = null;
		String julianDay = null;
		String batchNumber = null;

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

				responseType = (String) i.next();

				JSONObject jsonResponse = (JSONObject) jsonRoot
						.get(responseType);
				// System.out.println(jsonResponse);
				if (jsonResponse.has("RequestId"))
					requestId = jsonResponse.getString("RequestId");

				if (jsonResponse.has("ReferenceNumber"))
					referenceNumber = jsonResponse.getString("ReferenceNumber");
				if (jsonResponse.has("JulianDay")) {
					int jday = Integer.parseInt(jsonResponse
							.getString("JulianDay"));
					julianDay = String.format("%03d", jday);
				}
				if (jsonResponse.has("BatchNumber")) {
					int batchNum = Integer.parseInt(jsonResponse
							.getString("BatchNumber"));
					batchNumber = String.format("%03d", batchNum);
				}

				logger.info("TestName: " + globals.getTestName());

				scriptString += globals.getTestName() + " , " + julianDay
						+ batchNumber + ", " + referenceNumber + "\n";
				
				// scriptString += globals.getTestName() + ", " + requestId
				// + "\n";

				// scriptString += globals.getTestName() + ", " + requestId
				// + "\n";

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

	public static void main(String[] args) {
		DataStore ds = new DataStore();
		RestDriver driver = new RestDriver(ds);
		driver.authorize();
	}

}
