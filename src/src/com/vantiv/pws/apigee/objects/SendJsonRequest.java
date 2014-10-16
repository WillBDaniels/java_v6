/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.apigee.objects;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

/**
 * This class sends a JSON request to Apigee with RESTFUL services. It returns a
 * HttpResponse object.
 */
public class SendJsonRequest {
	private String apiUrl = "http://vantiv-nonprod-dev.apigee.net/v1/credit/";
	private String apiKey = "5HNcmF1tAvUgbYg5aw7YAOzkkBF7FWTT";
	private Gson gson = new Gson();
	private static Logger logger = org.apache.log4j.Logger
			.getLogger(SendJsonRequest.class);
	
	public HttpResponse sendJson(ApigeeObject ao, String requestType){
		
		if (requestType != null) {
			if (requestType.equals("authorize") || requestType.equals("tokenize")) {
				apiUrl += "authorization?sp=1";
			} else if (requestType.equals("capture")) {
				apiUrl += "authorizationcompletion?sp=1";
			} else if (requestType.equals("cancel")) {
				apiUrl += "reversal?sp=1";
			} else if (requestType.equals("purchase")) {
				apiUrl += "sale?sp=1";
			} else if (requestType.equals("refund")) {
				apiUrl += "return?sp=1";
			} else if (requestType.equals("batchClose")) {
				apiUrl += "batchclose?sp=1";
			} else if (requestType.equals("batchBalance")) {
				apiUrl += "batchbalance?sp=1";
			}
		}
			
		String jsonData = gson.toJson(ao);
		logger.debug("JSON Request: " + jsonData);
			
			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse httpResponse = null;
			try {
				HttpPost request = new HttpPost(apiUrl);
				StringEntity params = new StringEntity(jsonData);
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
}
