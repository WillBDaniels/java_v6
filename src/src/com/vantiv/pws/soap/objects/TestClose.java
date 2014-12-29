/* Copyright (C) 2014 Vantiv. All Rights Reserved.*/
package com.vantiv.pws.soap.objects;

import com.vantiv.pws.resources.DataStore;
import com.vantiv.pws.resources.Utils;
import com.vantiv.types.payment.transactions.v6.CloseRequest;
import com.vantiv.types.payment.transactions.v6.TransactionTypeType;

public class TestClose {
	private Utils util = new Utils();
	private DataStore globals;
	private CloseRequest request = new CloseRequest();

	public TestClose(DataStore ds) {
		globals = ds;
	}

	public CloseRequest createCloseRequest() {
		request.setDraftLocatorId(globals.getDraftLocatorId());
		request.setMerchant(globals.getMerchant());
		request.setMerchantRefId(globals.getMerchantRefId());
		request.setNetworkResponseCode(globals.getNetworkResponseCode());
		request.setGift(globals.getGiftCard());
		request.setSystemTraceId(globals.getSystemTraceId());
		request.setTransactionTimestamp(util.stringToXMLGregorian(""));
		request.setTransactionType(TransactionTypeType.fromValue(globals
				.getTransactionType()));


		return request;
	}
}
