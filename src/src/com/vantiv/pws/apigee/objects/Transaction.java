/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.apigee.objects;


public class Transaction {
	// Required
	private String TransactionID;
	private String TransactionAmount;
	private String MarketCode;
	private String TransactionTimestamp;
	private String ClerkNumber;
	// Optional-Conditional
	private String CancelType;
	private String PaymentType;
	private String ReferenceNumber;
	private String DraftLocatorId;
	private String AuthorizationCode;
	private String OriginalAuthorizedAmount;
	private String CaptureAmount;
	private String CashBackAmount;
	private String OriginalTransactionTimestamp;
	private String OriginalSystemTraceId;
	private String OriginalSequenceNumber;
	private String OriginalAuthCode;
	private String NetworkResponseCode;
	private String ReversalReason;
	private String ReplacementAmount;
	private String OriginalReferenceNumber;
	private String TipAmount;
	private String ConvenienceFee;
	private String TaxExempt;
	private String Taxable;
	private String TaxAmount;
	private String PurchaseOrder;
	private String TokenRequested;
	private String SystemTraceID;

	public String getSystemTraceId() {
		return SystemTraceID;
	}

	public void setSystemTraceId(String systemTraceId) {
		SystemTraceID = systemTraceId;
	}

	public String getOriginalAuthCode() {
		return OriginalAuthCode;
	}

	public String getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(String transactionID) {
		TransactionID = transactionID;
	}

	public String getTransactionAmount() {
		return TransactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		TransactionAmount = transactionAmount;
	}

	public String getMarketCode() {
		return MarketCode;
	}

	public void setMarketCode(String marketCode) {
		MarketCode = marketCode;
	}

	public String getTransactionTimestamp() {
		return TransactionTimestamp;
	}

	public void setTransactionTimestamp(String transactionTimestamp) {
		TransactionTimestamp = transactionTimestamp;
	}

	public String getClerkNumber() {
		return ClerkNumber;
	}

	public void setClerkNumber(String clerkNumber) {
		ClerkNumber = clerkNumber;
	}

	public String getCancelType() {
		return CancelType;
	}

	public void setCancelType(String cancelType) {
		CancelType = cancelType;
	}

	public String getPaymentType() {
		return PaymentType;
	}

	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}

	public String getReferenceNumber() {
		return ReferenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		ReferenceNumber = referenceNumber;
	}

	public String getDraftLocatorId() {
		return DraftLocatorId;
	}

	public void setDraftLocatorId(String draftLocatorId) {
		DraftLocatorId = draftLocatorId;
	}

	public String getAuthorizationCode() {
		return AuthorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		AuthorizationCode = authorizationCode;
	}

	public String getOriginalAuthorizedAmount() {
		return OriginalAuthorizedAmount;
	}

	public void setOriginalAuthorizedAmount(String originalAmount) {
		OriginalAuthorizedAmount = originalAmount;
	}

	public String getCaptureAmount() {
		return CaptureAmount;
	}

	public void setCaptureAmount(String captureAmount) {
		CaptureAmount = captureAmount;
	}

	public String getCashBackAmount() {
		return CashBackAmount;
	}

	public void setCashBackAmount(String cashBackAmount) {
		CashBackAmount = cashBackAmount;
	}

	public String getOriginalTransactionTimestamp() {
		return OriginalTransactionTimestamp;
	}

	public void setOriginalTransactionTimestamp(
			String originalTransactionTimestamp) {
		OriginalTransactionTimestamp = originalTransactionTimestamp;
	}

	public String getOriginalSystemTraceId() {
		return OriginalSystemTraceId;
	}

	public void setOriginalSystemTraceId(String originalSystemTraceId) {
		OriginalSystemTraceId = originalSystemTraceId;
	}

	public String getOriginalSequenceNumber() {
		return OriginalSequenceNumber;
	}

	public void setOriginalSequenceNumber(String originalSequenceNumber) {
		OriginalSequenceNumber = originalSequenceNumber;
	}

	public String getOrignalAuthCode() {
		return OriginalAuthCode;
	}

	public void setOriginalAuthCode(String originalAuthCode) {
		OriginalAuthCode = originalAuthCode;
	}

	public String getNetworkResponseCode() {
		return NetworkResponseCode;
	}

	public void setNetworkResponseCode(String networkResponseCode) {
		NetworkResponseCode = networkResponseCode;
	}

	public String getReversalReason() {
		return ReversalReason;
	}

	public void setReversalReason(String reversalReason) {
		ReversalReason = reversalReason;
	}

	public String getReplacementAmount() {
		return ReplacementAmount;
	}

	public void setReplacementAmount(String replacementAmount) {
		ReplacementAmount = replacementAmount;
	}

	public String getOriginalReferenceNumber() {
		return OriginalReferenceNumber;
	}

	public void setOriginalReferenceNumber(String originalReferenceNumber) {
		OriginalReferenceNumber = originalReferenceNumber;
	}

	public String getTipAmount() {
		return TipAmount;
	}

	public void setTipAmount(String tipAmount) {
		TipAmount = tipAmount;
	}

	public String getConvenienceFee() {
		return ConvenienceFee;
	}

	public void setConvenienceFee(String convenienceFee) {
		ConvenienceFee = convenienceFee;
	}

	public String getTaxExempt() {
		return TaxExempt;
	}

	public void setTaxExempt(String taxExempt) {
		TaxExempt = taxExempt;
	}

	public String getTaxable() {
		return Taxable;
	}

	public void setTaxable(String taxable) {
		Taxable = taxable;
	}

	public String getTaxAmount() {
		return TaxAmount;
	}

	public void setTaxAmount(String taxAmount) {
		TaxAmount = taxAmount;
	}

	public String getPurchaseOrder() {
		return PurchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		PurchaseOrder = purchaseOrder;
	}

	public String getTokenRequested() {
		return TokenRequested;
	}

	public void setTokenRequested(String tokenRequested) {
		TokenRequested = tokenRequested;
	}

}
