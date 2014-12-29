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
import com.google.gson.GsonBuilder;

/**
 * This class sends a JSON request to Apigee with RESTFUL services. It returns a
 * HttpResponse object.
 */
public class SendJsonRequest {


	private String apiKey = "4pQQpyKdAbDTGZvGU5Rh2QdWXzqMfgJh";
	private String licenseid1 = "572d606c967f412cb8d840e38fb48010$$#$$MphfoMed030iGRXOd6pBhDzGQnzEMmz7$$#$$2015-11-26$$#$$dev_key$$#$$SHA512withRSA$$#$$RSA$$#$$1$$#$$52BC72E18D55CC77AE2DE3C27C0AFE6C0FCE3E3E6C1638EE824E5DB7775ADBBB616D82127D46DF9272D6A39ABC6BA8AD6797000A52F769C982B5360C06CED1FFA8FABA0DEA70E1CD77DC4DAF912E81319538857CAABE16DB6C412AF478BC059B29232337AE09020069B96E741982FB5E6BC053E98FE7C33789288CAA6A9883C0D2380DD1812FCF2681A8B31545B97DD0736EB3ECBD9329F144CDB93C35780559DB6219604ADB3F5A8DC57E06CFD715FFCECD3CB65DE7BFDA065D4DB3BDC84B7E0FD66116C71AC41E0B875BA18C742A8ECE9E690AC37457DD43845F5C64EA00BF7B585A6FCF75A0F398026CD79C74C3C946C11BAFD1404997917C5592B91E8415";
	private Gson gson = new GsonBuilder().disableHtmlEscaping().create();;

	private static Logger logger = org.apache.log4j.Logger
			.getLogger(SendJsonRequest.class);


	public HttpResponse sendJson(ApigeeObject ao, String requestType) {
		// test env
		// String apiUrl = "http://vantiv-nonprod-dev.apigee.net/v1/";
		String apiUrl = "https://apis.cert.vantiv.com/v1/";

		if (requestType != null) {

			if (requestType.equals("authorize")
					|| requestType.equals("tokenize")) {
				apiUrl += "credit/authorization?sp=1";
			} else if (requestType.equals("authorizeGift")) {
				apiUrl += "gift/authorization?sp=1";

			} else if (requestType.equals("capture")) {

				apiUrl += "credit/authorizationcompletion?sp=1";
			} else if (requestType.equals("captureGift")) {
				apiUrl += "gift/authorizationcompletion?sp=1";
			} else if (requestType.equals("cancel"))
				apiUrl += "credit/reversal?sp=1";
			else if (requestType.equals("cancelGift"))
				apiUrl += "gift/reversal?sp=1";
			else if (requestType.equals("cancelDebit"))
				apiUrl += "debit/reversal?sp=1";
			else if (requestType.equals("purchase"))
				apiUrl += "credit/sale?sp=1";
			else if (requestType.equals("purchaseGift"))
				apiUrl += "gift/sale?sp=1";
			else if (requestType.equals("purchaseDebit"))
				apiUrl += "debit/sale?sp=1";
			else if (requestType.equals("refund")) {
				apiUrl += "credit/return?sp=1";
			} else if (requestType.equals("refundDebit")) {
				apiUrl += "debit/return?sp=1";
			} else if (requestType.equals("refundGift")) {
				apiUrl += "gift/return?sp=1";

			} else if (requestType.equals("batchClose")) {
				apiUrl += "credit/batchclose?sp=1";
			} else if (requestType.equals("batchBalance")) {
				apiUrl += "credit/batchbalance?sp=1";
			} else if (requestType.equals("activate")) {
				apiUrl += "gift/activation?sp=1";
			} else if (requestType.equals("reload")) {
				apiUrl += "gift/reload?sp=1";
			} else if (requestType.equals("unload")) {
				apiUrl += "gift/unload?sp=1";
			} else if (requestType.equals("close")) {
				apiUrl += "gift/close?sp=1";
			} else if (requestType.equals("balanceInquiry")) {
				apiUrl += "gift/balanceinquiry?sp=1";
			}

		}


		String jsonData = gson.toJson(ao);

		logger.debug("JSON Request: " + apiUrl + " - " + jsonData);


		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = null;
		try {
			HttpPost request = new HttpPost(apiUrl);
			StringEntity params = new StringEntity(jsonData);
			request.addHeader("apikey", apiKey);
			request.addHeader("licenseid", licenseid1);
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
