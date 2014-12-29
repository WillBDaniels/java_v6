/* Copyright (C) 2014 Vantiv. All Rights Reserved.*/
package com.vantiv.pws.soap.objects;

import com.vantiv.pws.resources.DataStore;
import com.vantiv.pws.resources.Utils;
import com.vantiv.types.payment.transactions.v6.TransactionTypeType;
import com.vantiv.types.payment.transactions.v6.UnloadRequest;

public class TestUnload {
	private Utils util = new Utils();
	private DataStore globals;
	private UnloadRequest request = new UnloadRequest();

	public TestUnload(DataStore ds) {
		globals = ds;
	}

	public UnloadRequest createReloadRequest() {
		request.setDraftLocatorId(globals.getDraftLocatorId());
		request.setMerchant(globals.getMerchant());
		request.setMerchantRefId(globals.getMerchantRefId());
		request.setNetworkResponseCode(globals.getNetworkResponseCode());
		request.setGift(globals.getGiftCard());
		request.setSystemTraceId(globals.getSystemTraceId());
		request.setTransactionAmount(globals.getTransactionAmountType());
		request.setTransactionTimestamp(util.stringToXMLGregorian(""));
		request.setTransactionType(TransactionTypeType.fromValue(globals
				.getTransactionType()));


		return request;
	}
}
