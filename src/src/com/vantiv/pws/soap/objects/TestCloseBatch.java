/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided �AS IS� and �AS AVAILABLE� and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.soap.objects;

import com.vantiv.pws.resources.DataStore;
import com.vantiv.pws.resources.Utils;
import com.vantiv.types.payment.transactions.v6.CloseBatchRequest;

public class TestCloseBatch {

	private Utils util = new Utils();
	private DataStore globals;
	private CloseBatchRequest request;

	public TestCloseBatch(DataStore ds) {
		request = new CloseBatchRequest();
		globals = ds;
	}

	public CloseBatchRequest createCloseBatch() {
		CloseBatchRequest cbr = new CloseBatchRequest();
		cbr.setMerchant(globals.getMerchant());
		cbr.setMerchantRefId(globals.getMerchantRefId());
		cbr.setSystemTraceId(globals.getSystemTraceId());
		cbr.setDraftLocatorId(globals.getDraftLocatorId());
		cbr.setTransactionTimestamp(util.stringToXMLGregorian(globals
				.getTransactionTimestamp()));
		return cbr;
	}

}
