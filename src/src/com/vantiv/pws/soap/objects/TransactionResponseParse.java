/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.soap.objects;

import com.vantiv.pws.resources.DataStore;
import com.vantiv.types.payment.transactions.v6.TransactionResponseType;

/*
 * This class takes a transaction response object from a SOAP response
 * and parses out any useful information from it to display to the user in a string.
 */
public class TransactionResponseParse {

	private DataStore globals;

	private TransactionResponseType response;
	private String testTitle = "";
	private String transactionStatus = "";
	private String declineCode = "";
	private String declineMsg = "";
	private String cvvResultCode = "";
	private String avsResultCode = "";
	private String cvvResultMsg = "";
	private String avsResultMsg = "";
	private String authCode = "";
	private String transId = "";
	private String validationCode = "";
	private String declineFullMsg = "";

	public TransactionResponseParse(TransactionResponseType resp, DataStore ds,
			String title) {

		testTitle = title;
		globals = ds;
		response = resp;

		try {
			transactionStatus = resp.getTransactionStatus().value();
		} catch (Exception e1) {
		}
		try {
			declineCode = resp.getDeclineCode();
			declineMsg = resp.getDeclineMessage();
		} catch (Exception e1) {
		}
		try {
			cvvResultCode = resp.getCardSecurityCodeResult().getCode();
			cvvResultMsg = resp.getCardSecurityCodeResult().getType().value();
		} catch (Exception e2) {
		}
		try {
			avsResultCode = resp.getAddressVerificationResult().getCode();
			avsResultMsg = resp.getAddressVerificationResult().getType()
					.value();
		} catch (Exception e2) {
		}
		try {
			authCode = resp.getAuthorizationCode();
		} catch (Exception e2) {
		}
		if (globals.getCardType().equalsIgnoreCase("visa")) {
			try {
				transId = resp.getPaymentServiceResults().getVisaResults()
						.getTransactionId();
				validationCode = resp.getPaymentServiceResults()
						.getVisaResults().getValidationCode();
			} catch (Exception e1) {
			}
		} else if (globals.getCardType().equalsIgnoreCase("masterCard")) {
			try {
				transId = resp.getPaymentServiceResults()
						.getMasterCardResults().getTransactionId();
				validationCode = resp.getPaymentServiceResults()
						.getMasterCardResults().getValidationCode();
			} catch (Exception e1) {
			}
		} else if (globals.getCardType().equalsIgnoreCase("amex")) {
			try {
				transId = resp.getPaymentServiceResults()
						.getAmericanExpressResults().getTransactionId();
				validationCode = resp.getPaymentServiceResults()
						.getAmericanExpressResults().getValidationCode();
			} catch (Exception e1) {
			}
		} else if (globals.getCardType().equalsIgnoreCase("discover")) {
			try {
				transId = resp.getPaymentServiceResults().getDiscoverResults()
						.getTransactionId();
				validationCode = resp.getPaymentServiceResults()
						.getDiscoverResults().getValidationCode();
			} catch (Exception e1) {
			}
		}
		this.declineFullMsg = declineCode + "-" + declineMsg;
	}



	public String testString() {
		String out = "";
		out += "Test Title: " + testTitle;
		out += "\nStatus: " + transactionStatus;
		out += "\nDecline Code/Msg: " + declineCode + " - " + declineMsg;
		out += "\nCVV Results: " + cvvResultCode + " - " + cvvResultMsg;
		out += "\nAVS Results: " + avsResultCode + " - " + avsResultMsg;
		out += "\nTransactionId: " + transId;
		out += "\nValidation Code: " + validationCode;
		out += "\nAuthentication Code: " + authCode;
		out += "\n********************************\n";

		return out;
	}

	public DataStore getGlobals() {
		return globals;
	}

	public void setGlobals(DataStore globals) {
		this.globals = globals;
	}

	public TransactionResponseType getResponse() {
		return response;
	}

	public void setResponse(TransactionResponseType response) {
		this.response = response;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getDeclineCode() {
		return declineCode;
	}

	public void setDeclineCode(String declineCode) {
		this.declineCode = declineCode;
	}

	public String getDeclineMsg() {
		return declineMsg;
	}

	public void setDeclineMsg(String declineMsg) {
		this.declineMsg = declineMsg;
	}

	public String getCvvResultCode() {
		return cvvResultCode;
	}

	public void setCvvResultCode(String cvvResultCode) {
		this.cvvResultCode = cvvResultCode;
	}

	public String getAvsResultCode() {
		return avsResultCode;
	}

	public void setAvsResultCode(String avsResultCode) {
		this.avsResultCode = avsResultCode;
	}

	public String getCvvResultMsg() {
		return cvvResultMsg;
	}

	public void setCvvResultMsg(String cvvResultMsg) {
		this.cvvResultMsg = cvvResultMsg;
	}

	public String getAvsResultMsg() {
		return avsResultMsg;
	}

	public void setAvsResultMsg(String avsResultMsg) {
		this.avsResultMsg = avsResultMsg;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getValidationCode() {
		return validationCode;
	}

	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}

	public String getDeclineFullMsg() {
		if (declineCode == null)
			return "-";
		else
			return declineFullMsg;
	}

	public void setDeclineFullMsg(String declineFullMsg) {
		this.declineFullMsg = declineFullMsg;
	}

}
