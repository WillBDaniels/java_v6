/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.apigee.objects;

import org.joda.time.DateTime;

import com.vantiv.pws.resources.DataStore;
import com.vantiv.pws.resources.Utils;
import com.vantiv.types.common.v6.ISO3166CountryCodeType;

/**
 * This is the base class that creates an object(ApigeeObject) that conforms to
 * the data contract of Apigee PWS portal. The values that are used to populate
 * these fields are found in the DataStore class. Each function creates an
 * ApigeeObject which can then be serialized into a JSON object to be sent to
 * Apigee by using RESTFUL services.
 */
public class CreateJsonRequest {
	private DataStore globals;
	private Utils utils = new Utils();


	public CreateJsonRequest(DataStore ds) {
		globals = ds;
	}

	public ApigeeObject createAuthorize() {
		Address address = new Address();
		Card card = new Card();
		Credentials cred = new Credentials();
		Merchant merchant = new Merchant();
		Terminal terminal = new Terminal();
		Transaction transaction = new Transaction();
		String timestamp = DateTime.now().toString();

		cred.setAccountID(globals.getUsername());
		cred.setPassword(globals.getPassword());

		// merchant
		merchant.setNetworkRouting(globals.getNetworkRouting());
		merchant.setCashierNumber("" + globals.getCashierNumber());
		merchant.setLaneNumber(globals.getLaneNumber());
		merchant.setDivisionNumber(globals.getDivisionNumber());
		merchant.setChainCode(globals.getChainCode());
		merchant.setStoreNumber(globals.getStoreNumber());
		merchant.setMerchantId(globals.getMerchantId());

		// Terminal
		terminal.setTerminalID("" + globals.getTerminalID());
		terminal.setEntryMode(globals.getEntryMode());
		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalCapabilityCode(globals.getEntryMode());

		terminal.setPinEntry(globals.getPinEntry());
		terminal.setBalanceInquiry("" + globals.isBalanceEnquiry());
		terminal.setHostAdjustment("" + globals.isHostAdjustment());

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType("Terminal");
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType("Software");
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType("Mobile");

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode("MagstripeRead");
		else
			terminal.setCardInputCode("ManualKeyed");

		// Transaction values
		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(globals.getPaymentType());
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(globals.getTransactionType());
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested("" + globals.isTokenRequested());

		transaction.setTransactionAmount(globals.getTransactionAmount());

		// Address
		address.setBillingAddress1(globals.getAddressline());
		address.setCity(globals.getCity());
		address.setState(globals.getState());
		address.setBillingZipcode(globals.getPostalCode());
		address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
				.getCountryCode()));

		// card - credit
		card.setCardType(globals.getCardType());
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);
			card.setCVV(globals.getCardSecurityCode());
			if (globals.isCardToken()) {
				card.setTokenID(globals.getTokenId());
				card.setTokenValue(globals.getTokenValue());
			}
		} else if (globals.isCardSwiped()) {
			if (globals.getTrack1Data() != null) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getTrack2Data() != null) {
				card.setTrack2Data(globals.getTrack2Data());
			}
		}

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

	public ApigeeObject createCapture() {
		Address address = new Address();
		Card card = new Card();
		Credentials cred = new Credentials();
		Merchant merchant = new Merchant();
		Terminal terminal = new Terminal();
		Transaction transaction = new Transaction();
		String timestamp = DateTime.now().toString();

		cred.setAccountID(globals.getUsername());
		cred.setPassword(globals.getPassword());

		// merchant
		merchant.setNetworkRouting(globals.getNetworkRouting());
		merchant.setCashierNumber("" + globals.getCashierNumber());
		merchant.setLaneNumber(globals.getLaneNumber());
		merchant.setDivisionNumber(globals.getDivisionNumber());
		merchant.setChainCode(globals.getChainCode());
		merchant.setStoreNumber(globals.getStoreNumber());
		merchant.setMerchantId(globals.getMerchantId());

		// Terminal
		terminal.setTerminalID("" + globals.getTerminalID());
		terminal.setEntryMode(globals.getEntryMode());
		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalCapabilityCode(globals.getEntryMode());

		terminal.setPinEntry(globals.getPinEntry());
		terminal.setBalanceInquiry("" + globals.isBalanceEnquiry());
		terminal.setHostAdjustment("" + globals.isHostAdjustment());

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType("Terminal");
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType("Software");
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType("Mobile");

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode("MagstripeRead");
		else
			terminal.setCardInputCode("ManualKeyed");

		// Transaction values
		transaction.setAuthorizationCode(globals.getAuthorizationCode());
		transaction.setOriginalAuthorizedAmount(globals.getTransactionAmount());
		transaction.setCaptureAmount(globals.getSettlementAmount());
		transaction.setOriginalReferenceNumber(globals.getOriginalRefNum());
		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(globals.getPaymentType());
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(globals.getTransactionType());
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested("" + globals.isTokenRequested());
		if (globals.getTipAmount() != null)
			transaction.setTipAmount(globals.getTipAmount());



		// Address
		address.setBillingAddress1(globals.getAddressline());
		address.setCity(globals.getCity());
		address.setState(globals.getState());
		address.setBillingZipcode(globals.getPostalCode());
		address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
				.getCountryCode()));

		// card - credit
		card.setCardType(globals.getCardType());
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);
			card.setCVV(globals.getCardSecurityCode());
			if (globals.isCardToken()) {
				card.setTokenID(globals.getTokenId());
				card.setTokenValue(globals.getTokenValue());
			}
		} else if (globals.isCardSwiped()) {
			if (globals.getTrack1Data() != null) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getTrack2Data() != null) {
				card.setTrack2Data(globals.getTrack2Data());
			}
		}

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

	public ApigeeObject createPurchase() {
		Address address = new Address();
		Card card = new Card();
		Credentials cred = new Credentials();
		Merchant merchant = new Merchant();
		Terminal terminal = new Terminal();
		Transaction transaction = new Transaction();

		String timestamp = DateTime.now().toString();

		cred.setAccountID(globals.getUsername());
		cred.setPassword(globals.getPassword());

		// merchant
		merchant.setNetworkRouting(globals.getNetworkRouting());
		merchant.setCashierNumber("" + globals.getCashierNumber());
		merchant.setLaneNumber(globals.getLaneNumber());
		merchant.setDivisionNumber(globals.getDivisionNumber());
		merchant.setChainCode(globals.getChainCode());
		merchant.setStoreNumber(globals.getStoreNumber());
		merchant.setMerchantId(globals.getMerchantId());

		// Terminal
		terminal.setTerminalID("" + globals.getTerminalID());
		terminal.setEntryMode(globals.getEntryMode());
		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalCapabilityCode(globals.getEntryMode());

		terminal.setPinEntry(globals.getPinEntry());
		terminal.setBalanceInquiry("" + globals.isBalanceEnquiry());
		terminal.setHostAdjustment("" + globals.isHostAdjustment());

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType("Terminal");
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType("Software");
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType("Mobile");

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode("MagstripeRead");
		else
			terminal.setCardInputCode("ManualKeyed");

		// Transaction values
		transaction.setCaptureAmount(globals.getTransactionAmount());

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(globals.getPaymentType());
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(globals.getTransactionType());
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested("" + globals.isTokenRequested());
		if (globals.getTipAmount() != null)
			transaction.setTipAmount(globals.getTipAmount());



		// Address
		address.setBillingAddress1(globals.getAddressline());
		address.setCity(globals.getCity());
		address.setState(globals.getState());
		address.setBillingZipcode(globals.getPostalCode());
		address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
				.getCountryCode()));

		// card - credit
		card.setCardType(globals.getCardType());
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);
			card.setCVV(globals.getCardSecurityCode());
			if (globals.isCardToken()) {
				card.setTokenID(globals.getTokenId());
				card.setTokenValue(globals.getTokenValue());
			}
		} else if (globals.isCardSwiped()) {
			if (globals.getTrack1Data() != null) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getTrack2Data() != null) {
				card.setTrack2Data(globals.getTrack2Data());
			}
		}

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

	public ApigeeObject createCancel() {
		Address address = new Address();
		Card card = new Card();
		Credentials cred = new Credentials();
		Merchant merchant = new Merchant();
		Terminal terminal = new Terminal();
		Transaction transaction = new Transaction();
		String timestamp = DateTime.now().toString();

		cred.setAccountID(globals.getUsername());
		cred.setPassword(globals.getPassword());

		// merchant
		merchant.setNetworkRouting(globals.getNetworkRouting());
		merchant.setCashierNumber("" + globals.getCashierNumber());
		merchant.setLaneNumber(globals.getLaneNumber());
		merchant.setDivisionNumber(globals.getDivisionNumber());
		merchant.setChainCode(globals.getChainCode());
		merchant.setStoreNumber(globals.getStoreNumber());
		merchant.setMerchantId(globals.getMerchantId());

		// Terminal
		terminal.setTerminalID("" + globals.getTerminalID());
		terminal.setEntryMode(globals.getEntryMode());
		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalCapabilityCode(globals.getEntryMode());

		terminal.setPinEntry(globals.getPinEntry());
		terminal.setBalanceInquiry("" + globals.isBalanceEnquiry());
		terminal.setHostAdjustment("" + globals.isHostAdjustment());

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType("Terminal");
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType("Software");
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType("Mobile");

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode("MagstripeRead");
		else
			terminal.setCardInputCode("ManualKeyed");

		// Transaction values
		transaction.setCancelType(globals.getCancelTransactionType());
		transaction.setOriginalAuthCode(globals.getAuthorizationCode());
		transaction.setOriginalReferenceNumber(globals.getOriginalRefNum());
		transaction.setOriginalAuthorizedAmount(globals.getTransactionAmount());
		transaction.setOriginalSequenceNumber(globals.getSequenceNumber());
		transaction.setOriginalSystemTraceId(""
				+ globals.getOriginalSystemTraceId());
		transaction.setReplacementAmount(globals.getReplacementAmount());
		transaction.setReversalReason(globals.getReversalReason());
		transaction.setOriginalTransactionTimestamp(timestamp);

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(globals.getPaymentType());
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(globals.getTransactionType());
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested("" + globals.isTokenRequested());




		// Address
		address.setBillingAddress1(globals.getAddressline());
		address.setCity(globals.getCity());
		address.setState(globals.getState());
		address.setBillingZipcode(globals.getPostalCode());
		address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
				.getCountryCode()));

		// card - credit
		card.setCardType(globals.getCardType());
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);
			card.setCVV(globals.getCardSecurityCode());
			if (globals.isCardToken()) {
				card.setTokenID(globals.getTokenId());
				card.setTokenValue(globals.getTokenValue());
			}
		} else if (globals.isCardSwiped()) {
			if (globals.getTrack1Data() != null) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getTrack2Data() != null) {
				card.setTrack2Data(globals.getTrack2Data());
			}
		}

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

	public ApigeeObject createRefund() {
		Address address = new Address();
		Card card = new Card();
		Credentials cred = new Credentials();
		Merchant merchant = new Merchant();
		Terminal terminal = new Terminal();
		Transaction transaction = new Transaction();
		String timestamp = DateTime.now().toString();

		cred.setAccountID(globals.getUsername());
		cred.setPassword(globals.getPassword());

		// merchant
		merchant.setNetworkRouting(globals.getNetworkRouting());
		merchant.setCashierNumber("" + globals.getCashierNumber());
		merchant.setLaneNumber(globals.getLaneNumber());
		merchant.setDivisionNumber(globals.getDivisionNumber());
		merchant.setChainCode(globals.getChainCode());
		merchant.setStoreNumber(globals.getStoreNumber());
		merchant.setMerchantId(globals.getMerchantId());

		// Terminal
		terminal.setTerminalID("" + globals.getTerminalID());
		terminal.setEntryMode(globals.getEntryMode());
		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalCapabilityCode(globals.getEntryMode());

		terminal.setPinEntry(globals.getPinEntry());
		terminal.setBalanceInquiry("" + globals.isBalanceEnquiry());
		terminal.setHostAdjustment("" + globals.isHostAdjustment());

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType("Terminal");
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType("Software");
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType("Mobile");

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode("MagstripeRead");
		else
			terminal.setCardInputCode("ManualKeyed");

		// Transaction values
		transaction.setTransactionAmount(globals.getTransactionAmount());

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(globals.getPaymentType());
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(globals.getTransactionType());
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested("" + globals.isTokenRequested());




		// Address
		address.setBillingAddress1(globals.getAddressline());
		address.setCity(globals.getCity());
		address.setState(globals.getState());
		address.setBillingZipcode(globals.getPostalCode());
		address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
				.getCountryCode()));

		// card - credit
		card.setCardType(globals.getCardType());
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);
			card.setCVV(globals.getCardSecurityCode());
			if (globals.isCardToken()) {
				card.setTokenID(globals.getTokenId());
				card.setTokenValue(globals.getTokenValue());
			}
		} else if (globals.isCardSwiped()) {
			if (globals.getTrack1Data() != null) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getTrack2Data() != null) {
				card.setTrack2Data(globals.getTrack2Data());
			}
		}

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

	public ApigeeObject createTokenize() {
		Address address = new Address();
		Card card = new Card();
		Credentials cred = new Credentials();
		Merchant merchant = new Merchant();
		Terminal terminal = new Terminal();
		Transaction transaction = new Transaction();
		String timestamp = DateTime.now().toString();

		cred.setAccountID(globals.getUsername());
		cred.setPassword(globals.getPassword());

		// merchant
		merchant.setNetworkRouting(globals.getNetworkRouting());
		merchant.setCashierNumber("" + globals.getCashierNumber());
		merchant.setLaneNumber(globals.getLaneNumber());
		merchant.setDivisionNumber(globals.getDivisionNumber());
		merchant.setChainCode(globals.getChainCode());
		merchant.setStoreNumber(globals.getStoreNumber());
		merchant.setMerchantId(globals.getMerchantId());

		// Terminal
		terminal.setTerminalID("" + globals.getTerminalID());
		terminal.setEntryMode(globals.getEntryMode());
		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalCapabilityCode(globals.getEntryMode());

		terminal.setPinEntry(globals.getPinEntry());
		terminal.setBalanceInquiry("" + globals.isBalanceEnquiry());
		terminal.setHostAdjustment("" + globals.isHostAdjustment());

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType("Terminal");
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType("Software");
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType("Mobile");

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode("MagstripeRead");
		else
			terminal.setCardInputCode("ManualKeyed");

		// Transaction values
		transaction.setTransactionAmount("0.00");

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(globals.getPaymentType());
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(globals.getTransactionType());
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested("true");


		// Address
		address.setBillingAddress1(globals.getAddressline());
		address.setCity(globals.getCity());
		address.setState(globals.getState());
		address.setBillingZipcode(globals.getPostalCode());
		address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
				.getCountryCode()));

		// card - credit
		card.setCardType(globals.getCardType());
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);
			card.setCVV(globals.getCardSecurityCode());

		} else if (globals.isCardSwiped()) {
			if (globals.getTrack1Data() != null) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getTrack2Data() != null) {
				card.setTrack2Data(globals.getTrack2Data());
			}
		}

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

	public ApigeeObject createBatchClose() {
		Address address = new Address();
		Card card = new Card();
		Credentials cred = new Credentials();
		Merchant merchant = new Merchant();
		Terminal terminal = new Terminal();
		Transaction transaction = new Transaction();
		String timestamp = DateTime.now().toString();

		cred.setAccountID(globals.getUsername());
		cred.setPassword(globals.getPassword());

		// merchant
		merchant.setNetworkRouting(globals.getNetworkRouting());
		merchant.setCashierNumber("" + globals.getCashierNumber());
		merchant.setLaneNumber(globals.getLaneNumber());
		merchant.setDivisionNumber(globals.getDivisionNumber());
		merchant.setChainCode(globals.getChainCode());
		merchant.setStoreNumber(globals.getStoreNumber());
		merchant.setMerchantId(globals.getMerchantId());

		// Terminal
		terminal.setTerminalID("" + globals.getTerminalID());
		terminal.setEntryMode(globals.getEntryMode());
		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalCapabilityCode(globals.getEntryMode());

		terminal.setPinEntry(globals.getPinEntry());
		terminal.setBalanceInquiry("" + globals.isBalanceEnquiry());
		terminal.setHostAdjustment("" + globals.isHostAdjustment());

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType("Terminal");
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType("Software");
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType("Mobile");

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(globals.getPaymentType());
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(globals.getTransactionType());
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

	public ApigeeObject createBatchBalance() {
		Address address = new Address();
		Card card = new Card();
		Credentials cred = new Credentials();
		Merchant merchant = new Merchant();
		Terminal terminal = new Terminal();
		Transaction transaction = new Transaction();
		String timestamp = DateTime.now().toString();

		cred.setAccountID(globals.getUsername());
		cred.setPassword(globals.getPassword());

		// merchant
		merchant.setNetworkRouting(globals.getNetworkRouting());
		merchant.setCashierNumber("" + globals.getCashierNumber());
		merchant.setLaneNumber(globals.getLaneNumber());
		merchant.setDivisionNumber(globals.getDivisionNumber());
		merchant.setChainCode(globals.getChainCode());
		merchant.setStoreNumber(globals.getStoreNumber());
		merchant.setMerchantId(globals.getMerchantId());

		// Terminal
		terminal.setTerminalID("" + globals.getTerminalID());
		terminal.setEntryMode(globals.getEntryMode());
		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalCapabilityCode(globals.getEntryMode());

		terminal.setPinEntry(globals.getPinEntry());
		terminal.setBalanceInquiry("" + globals.isBalanceEnquiry());
		terminal.setHostAdjustment("" + globals.isHostAdjustment());

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType("Terminal");
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType("Software");
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType("Mobile");

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(globals.getPaymentType());
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(globals.getTransactionType());
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());


		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

	// NOT READY
	// TODO
	public ApigeeObject createAdjust() {
		Address address = new Address();
		Card card = new Card();
		Credentials cred = new Credentials();
		Merchant merchant = new Merchant();
		Terminal terminal = new Terminal();
		Transaction transaction = new Transaction();
		String timestamp = DateTime.now().toString();

		cred.setAccountID(globals.getUsername());
		cred.setPassword(globals.getPassword());

		// merchant
		merchant.setNetworkRouting(globals.getNetworkRouting());
		merchant.setCashierNumber("" + globals.getCashierNumber());
		merchant.setLaneNumber(globals.getLaneNumber());
		merchant.setDivisionNumber(globals.getDivisionNumber());
		merchant.setChainCode(globals.getChainCode());
		merchant.setStoreNumber(globals.getStoreNumber());
		merchant.setMerchantId(globals.getMerchantId());

		// Terminal
		terminal.setTerminalID("" + globals.getTerminalID());
		terminal.setEntryMode(globals.getEntryMode());
		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalCapabilityCode(globals.getEntryMode());

		terminal.setPinEntry(globals.getPinEntry());
		terminal.setBalanceInquiry("" + globals.isBalanceEnquiry());
		terminal.setHostAdjustment("" + globals.isHostAdjustment());

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType("Terminal");
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType("Software");
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType("Mobile");

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode("MagstripeRead");
		else
			terminal.setCardInputCode("ManualKeyed");

		// Transaction values
		transaction.setCancelType(globals.getCancelTransactionType());
		transaction.setOriginalAuthCode(globals.getAuthorizationCode());
		transaction.setOriginalReferenceNumber(globals.getOriginalRefNum());
		transaction.setOriginalAuthorizedAmount(globals.getTransactionAmount());
		transaction.setOriginalSequenceNumber(globals.getSequenceNumber());
		transaction.setOriginalSystemTraceId(""
				+ globals.getOriginalSystemTraceId());
		transaction.setReplacementAmount(globals.getReplacementAmount());
		transaction.setReversalReason(globals.getReversalReason());
		transaction.setOriginalTransactionTimestamp(timestamp);

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(globals.getPaymentType());
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(globals.getTransactionType());
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested("" + globals.isTokenRequested());

		// Address
		address.setBillingAddress1(globals.getAddressline());
		address.setCity(globals.getCity());
		address.setState(globals.getState());
		address.setBillingZipcode(globals.getPostalCode());
		address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
				.getCountryCode()));

		// card - credit
		card.setCardType(globals.getCardType());
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);
			card.setCVV(globals.getCardSecurityCode());
			if (globals.isCardToken()) {
				card.setTokenID(globals.getTokenId());
				card.setTokenValue(globals.getTokenValue());
			}
		} else if (globals.isCardSwiped()) {
			if (globals.getTrack1Data() != null) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getTrack2Data() != null) {
				card.setTrack2Data(globals.getTrack2Data());
			}
		}

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}


}
