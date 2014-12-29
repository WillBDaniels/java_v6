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
import com.vantiv.types.payment.transactions.v6.AdjustRequest;
import com.vantiv.types.payment.transactions.v6.PaymentType;
import com.vantiv.types.payment.transactions.v6.TransactionTypeType;

/**
 * Creates an AdjustRequest object. Values pulled from DataStore.java.
 */
public class TestAdjust {

	private Utils util;
	private AdjustRequest request;
	private DataStore globals;

	public TestAdjust(DataStore ds) {
		globals = ds;
		util = new Utils();
	}

	public AdjustRequest createAdjustRequest() {
		request = new AdjustRequest();

		request.setAdjustedTotalAmount(globals.getAdjustedAmountType());
		request.setTipAmount(globals.getTipAmountType());
		request.setOriginalAmount(globals.getTransactionAmountType());

		request.setOriginalReferenceNumber(globals.getOriginalRefNum());
		request.setAuthorizationCode(globals.getAuthorizationCode());
		request.setDraftLocatorId(globals.getDraftLocatorId());
		request.setMerchantRefId(globals.getMerchantRefId());
		request.setNetworkResponseCode(globals.getNetworkResponseCode());
		request.setReferenceNumber(globals.getReferenceNumber());
		request.setReportGroup(globals.getReportGroup());
		request.setSystemTraceId(globals.getSystemTraceId());
		request.setBillPaymentPayee(globals.getBillPaymentPayeeType());
		// set credit/debit/gift
		request.setCredit(globals.getMaskedCreditInstument());
		request.setTokenRequested(globals.isTokenRequested());

		// request.setIncrementalAuthorization(value);
		request.setMerchant(globals.getMerchant());
		request.setPaymentType(PaymentType.fromValue(globals.getPaymentType()));
		// request.setTokenRequested(value);
		request.setTransactionTimestamp(util.stringToXMLGregorian(globals
				.getTransactionTimestamp()));
		request.setTransactionType(TransactionTypeType.fromValue(globals
				.getTransactionType()));

		return request;
	}

}
