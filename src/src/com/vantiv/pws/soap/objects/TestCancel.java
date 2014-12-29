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
import com.vantiv.types.payment.transactions.v6.CancelRequest;
import com.vantiv.types.payment.transactions.v6.PaymentType;
import com.vantiv.types.payment.transactions.v6.TransactionTypeType;

public class TestCancel {
	private Utils util;
	private CancelRequest request;
	private DataStore globals;

	public TestCancel(DataStore ds) {
		globals = ds;
		util = new Utils();
	}

	public CancelRequest createCancelRequest() {
		request = new CancelRequest();
		request.setCancelType(globals.getCancelType());
		request.setOriginalAmount(globals.getTransactionAmountType());
		request.setOriginalTransactionTimestamp(globals
				.getOriginalTimestampXML());
		request.setOriginalAuthCode(globals.getAuthorizationCode());

		request.setOriginalSequenceNumber(globals.getSequenceNumber());
		request.setOriginalSystemTraceId(globals.getOriginalSystemTraceId());
		request.setReplacementAmount(globals.getReplacementAmountType());
		request.setReversalReason(globals.getReversalReasonType());
		request.setOriginalReferenceNumber(globals.getOriginalRefNum());

		request.setDraftLocatorId(globals.getDraftLocatorId());
		request.setMerchantRefId(globals.getMerchantRefId());
		request.setNetworkResponseCode(globals.getNetworkResponseCode());
		request.setReferenceNumber(globals.getReferenceNumber());
		request.setReportGroup(globals.getReportGroup());
		request.setSystemTraceId(globals.getSystemTraceId());
		request.setBillPaymentPayee(globals.getBillPaymentPayeeType());
		globals.setCardKeyed(true);
		globals.setEntryMode("manual");
		globals.setCardReader("unknown");
		globals.setCardSwiped(false);
		// set credit/debit/gift
		if (globals.isDebit())
			request.setDebit(globals.getDebitInstument());
		else if (globals.isGift())
			request.setGift(globals.getGiftCard());
		else {
			request.setCredit(globals.getMaskedCreditInstument());
			request.setTokenRequested(globals.isTokenRequested());
		}
		request.setTokenRequested(globals.isTokenRequested());

		// request.setIncrementalAuthorization(value);

		request.setMerchant(globals.getMerchant());
		request.setPaymentType(PaymentType.fromValue(globals.getPaymentType()));

		request.setTransactionTimestamp(util.stringToXMLGregorian(globals
				.getTransactionTimestamp()));
		request.setTransactionType(TransactionTypeType.fromValue(globals
				.getTransactionType()));

		return request;
	}

}
