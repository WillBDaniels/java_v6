/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.apigee.objects;


import org.joda.time.DateTime;

import com.vantiv.pws.apigee.objects.Enums.AccountTypeEnum;
import com.vantiv.pws.apigee.objects.Enums.CancelTypeEnum;
import com.vantiv.pws.apigee.objects.Enums.CardInputCodeType;
import com.vantiv.pws.apigee.objects.Enums.CreditCardNetworkType;
import com.vantiv.pws.apigee.objects.Enums.DeviceTypeCode;
import com.vantiv.pws.apigee.objects.Enums.EncryptionType;
import com.vantiv.pws.apigee.objects.Enums.MarketCodeType;
import com.vantiv.pws.apigee.objects.Enums.PaymentTypeEnum;
import com.vantiv.pws.apigee.objects.Enums.PinEntryType;
import com.vantiv.pws.apigee.objects.Enums.ReversalReasonType;
import com.vantiv.pws.apigee.objects.Enums.TerminalEnvironmentType;
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
		terminal.setTerminalID("" + "" + globals.getTerminalID());

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		terminal.setPinEntry(PinEntryType.valueOf(globals.getPinEntry()));
		terminal.setBalanceInquiry(globals.isBalanceEnquiry());
		terminal.setHostAdjustment(globals.isHostAdjustment());

		// Set Device Type

		String deviceType = globals.getCaptureDevice();
		terminal.setDeviceType(DeviceTypeCode.fromValue(deviceType));

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode(CardInputCodeType.MagstripeRead);
		else
			terminal.setCardInputCode(CardInputCodeType.ManualKeyed);

		// Transaction values
		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested(globals.isTokenRequested());

		transaction.setTransactionAmount(globals.getTransactionAmount());
		// tax values
		if (globals.isPurchaseLevel()) {
			if (globals.getTaxAmount() != null) {
				transaction.setTaxAmount(globals.getTaxAmount());
			} else if (!globals.isTaxable()) {
				transaction.setTaxable(false);
			} else if (globals.isTaxExempt()) {
				transaction.setTaxExempt(true);
			}
		}

		// Address
		if (globals.getPostalCode() != null) {
			address.setBillingZipcode(globals.getPostalCode());
			address.setCity(globals.getCity());
			address.setState(globals.getState());
			address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
					.getCountryCode()));
		} else
			address = null;

		// card - credit
		card.setCardType(CreditCardNetworkType.valueOf(globals.getCardType()));
		card.setPartialApprovalCode(globals.getPartialIndicator());
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());

			if (globals.getExpirationDate().contains("-")) {
				String[] expirationDate = globals.getExpirationDate()
						.split("-");
				card.setExpirationMonth(expirationDate[1]);
				card.setExpirationYear(expirationDate[0]);
			} else {
				card.setExpirationMonth("");
				card.setExpirationYear("");
			}

			if (globals.isCredit())
				card.setCVV(globals.getCardSecurityCode());
			else {
				card.setGiftCardSecurityCode(globals.getGiftCardSecurityCode());
				card.setKeySerialNumber(globals.getGiftCardPin());
			}

			if (globals.isCardToken()) {
				card.setTokenId(globals.getTokenId());
				card.setTokenValue(globals.getTokenValue());
			}
		} else if (globals.isCardSwiped()) {
			if (globals.getEntryMode().equalsIgnoreCase("track1")) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getEntryMode().equalsIgnoreCase("track2")) {
				card.setTrack2Data(globals.getTrack2Data());
			}
			if (globals.isCardToken()) {
				card.setTokenId(globals.getTokenId());
				card.setTokenValue(globals.getTokenValue());
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

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		terminal.setPinEntry(PinEntryType.valueOf(globals.getPinEntry()));
		terminal.setBalanceInquiry(globals.isBalanceEnquiry());
		terminal.setHostAdjustment(globals.isHostAdjustment());

		// Set Device Type

		String deviceType = globals.getCaptureDevice();
		terminal.setDeviceType(DeviceTypeCode.fromValue(deviceType));

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode(CardInputCodeType.MagstripeRead);
		else
			terminal.setCardInputCode(CardInputCodeType.ManualKeyed);

		// Transaction values
		transaction.setAuthorizationCode(globals.getAuthorizationCode());
		transaction.setOriginalAuthorizedAmount(globals.getTransactionAmount());
		transaction.setCaptureAmount(globals.getSettlementAmount());
		transaction.setOriginalReferenceNumber(globals.getOriginalRefNum());
		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested(globals.isTokenRequested());
		if (globals.getTipAmount() != null)
			transaction.setTipAmount(globals.getTipAmount());
		// tax values
		if (globals.isPurchaseLevel()) {
			if (globals.getTaxAmount() != null) {
				transaction.setTaxAmount(globals.getTaxAmount());
			} else if (!globals.isTaxable()) {
				transaction.setTaxable(false);
			} else if (globals.isTaxExempt()) {
				transaction.setTaxExempt(true);
			}
		}

		// Address
		if (globals.getPostalCode() != null) {
			address.setBillingZipcode(globals.getPostalCode());
			address.setCity(globals.getCity());
			address.setState(globals.getState());
			address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
					.getCountryCode()));
		} else
			address = null;

		// card - credit
		card.setCardType(CreditCardNetworkType.valueOf(globals.getCardType()));
		card.setPartialApprovalCode(globals.getPartialIndicator());
		if (globals.isCardKeyed()) {
			String masked = utils
					.getMaskedPan(globals.getPrimaryAcountNumber());
			card.setCardNumber(masked);
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);

			if (globals.isCredit())
				card.setCVV(globals.getCardSecurityCode());
			else {
				card.setGiftCardSecurityCode(globals.getGiftCardSecurityCode());
				card.setKeySerialNumber(globals.getGiftCardPin());
			}

			if (globals.isCardToken()) {
				card.setTokenId(globals.getTokenId());
				card.setTokenValue(globals.getTokenValue());
			}
		} else if (globals.isCardSwiped()) {

			String masked = utils.getMaskedPan(globals.getTrack2Data());
			if (globals.getEntryMode().equalsIgnoreCase("track1")) {

				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getEntryMode().equalsIgnoreCase("track2")) {
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

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		terminal.setPinEntry(PinEntryType.valueOf(globals.getPinEntry()));
		terminal.setBalanceInquiry(globals.isBalanceEnquiry());
		terminal.setHostAdjustment(globals.isHostAdjustment());

		// Set Device Type

		String deviceType = globals.getCaptureDevice();
		terminal.setDeviceType(DeviceTypeCode.fromValue(deviceType));

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode(CardInputCodeType.MagstripeRead);
		else
			terminal.setCardInputCode(CardInputCodeType.ManualKeyed);

		// Transaction values
		transaction.setTransactionAmount(globals.getTransactionAmount());

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested(globals.isTokenRequested());
		if (globals.getTipAmount() != null)
			transaction.setTipAmount(globals.getTipAmount());

		// tax values
		if (globals.isPurchaseLevel()) {
			if (globals.getTaxAmount() != null) {
				transaction.setTaxAmount(globals.getTaxAmount());
			} else if (!globals.isTaxable()) {
				transaction.setTaxable(false);
			} else if (globals.isTaxExempt()) {
				transaction.setTaxExempt(true);
			}
		}

		// card
		card.setCardType(CreditCardNetworkType.valueOf(globals.getCardType()));
		card.setPartialApprovalCode(globals.getPartialIndicator());
		if (globals.isGift()) {
			card.setCardDataKeySerialNumber(globals.getGiftCardPin());
			card.setGiftCardSecurityCode(globals.getGiftCardSecurityCode());
		} else if (globals.isDebit()) {
			card.setPINBlock(globals.getPinEncryptedValue());
			card.setPINBlockEncryptedFormat(globals.getPinEncryptedType());
			card.setKeySerialNumber(globals.getPinEncryptedKey());
			card.setAccountType(AccountTypeEnum.fromValue(globals
					.getAccountType()));

		} else {
			// Address
			if (globals.getPostalCode() != null) {
				address.setBillingZipcode(globals.getPostalCode());
				address.setCity(globals.getCity());
				address.setState(globals.getState());
				address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
						.getCountryCode()));
			} else
				address = null;
		}

		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);
			if (!globals.getCardSecurityCode().isEmpty())
				card.setCVV(globals.getCardSecurityCode());
			else
				card.setCVV(null);
			if (globals.isCardToken()) {
				card.setTokenId(globals.getTokenId());
				card.setTokenValue(globals.getTokenValue());
			}

		} else if (globals.isCardSwiped()) {
			if (globals.getEntryMode().equals("track1")) {
				if (globals.isTrackEncrypted()) {
					card.setEncryptedFormat(EncryptionType.fromValue(globals
							.getCardEncryptedType()));
					card.setEncryptedTrack1Data(globals.getCardEncryptedValue());
					// what about card encrypted key?
				} else
					card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getEntryMode().equals("track2")) {
				if (globals.isTrackEncrypted()) {
					card.setEncryptedFormat(EncryptionType.fromValue(globals
							.getCardEncryptedType()));
					card.setEncryptedTrack2Data(globals.getCardEncryptedValue());
					// what about card encrypted key?
				} else {
					card.setTrack2Data(globals.getTrack2Data());
				}
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

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		terminal.setPinEntry(PinEntryType.valueOf(globals.getPinEntry()));
		// terminal.setBalanceInquiry(globals.isBalanceEnquiry());
		// terminal.setHostAdjustment(globals.isHostAdjustment());

		// Set Device Type

		String deviceType = globals.getCaptureDevice();
		terminal.setDeviceType(DeviceTypeCode.fromValue(deviceType));

		// Card input code

		// if (globals.isCardKeyed())
		// terminal.setCardInputCode(CardInputCodeType.ManualKeyed);
		// else
		// terminal.setCardInputCode(CardInputCodeType.MagstripeRead);
		terminal.setCardInputCode(CardInputCodeType.ManualKeyed);

		terminal.setCardInputCode(CardInputCodeType.ManualKeyed);

		// Transaction values

		String cancType = globals.getCancelTransactionType();
		transaction.setCancelType(CancelTypeEnum.fromValue(cancType));

		transaction.setOriginalAuthCode(globals.getAuthorizationCode());
		transaction.setOriginalReferenceNumber(globals.getOriginalRefNum());
		transaction.setOriginalAuthorizedAmount(globals.getTransactionAmount());
		transaction.setOriginalSequenceNumber(globals.getSequenceNumber());
		transaction.setOriginalSystemTraceId(""
				+ globals.getOriginalSystemTraceId());

		// Gift reversals do not allow the field "replacementAmount", it must be
		// "transactionAmount"
		if (globals.isGift())
			transaction.setTransactionAmount(globals.getReplacementAmount());
		else
			transaction.setReplacementAmount(globals.getReplacementAmount());
		transaction.setReversalReason(ReversalReasonType.fromValue(globals
				.getReversalReason()));

		transaction.setOriginalTransactionTimestamp(timestamp);

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested(globals.isTokenRequested());

		// Address
		if (globals.getPostalCode() != null) {
			address.setBillingZipcode(globals.getPostalCode());
			address.setCity(globals.getCity());
			address.setState(globals.getState());
			address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
					.getCountryCode()));
		} else
			address = null;

		// card - credit
		card.setCardType(CreditCardNetworkType.valueOf(globals.getCardType()));
		card.setPartialApprovalCode(globals.getPartialIndicator());

		if (globals.isCardKeyed()) {
			String masked = utils
					.getMaskedPan(globals.getPrimaryAcountNumber());
			card.setCardNumber(masked);
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);

			if (globals.isCredit())
				card.setCVV(globals.getCardSecurityCode());
			else {
				card.setGiftCardSecurityCode(globals.getGiftCardSecurityCode());
				card.setKeySerialNumber(globals.getGiftCardPin());
			}

			if (globals.isCardToken()) {
				card.setTokenId(globals.getTokenId());
				card.setTokenValue(globals.getTokenValue());
			}
		} else if (globals.isCardSwiped()) {
			String masked = utils.getMaskedPan(globals.getTrack2Data());
			if (globals.getEntryMode().equalsIgnoreCase("track1")) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getEntryMode().equalsIgnoreCase("track2")) {
				card.setTrack2Data(globals.getTrack2Data());
			}
		}

		// }

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

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		terminal.setPinEntry(PinEntryType.valueOf(globals.getPinEntry()));
		terminal.setBalanceInquiry(globals.isBalanceEnquiry());
		terminal.setHostAdjustment(globals.isHostAdjustment());

		// Set Device Type

		String deviceType = globals.getCaptureDevice();
		terminal.setDeviceType(DeviceTypeCode.fromValue(deviceType));

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode(CardInputCodeType.MagstripeRead);
		else
			terminal.setCardInputCode(CardInputCodeType.ManualKeyed);

		// Transaction values
		transaction.setTransactionAmount(globals.getRefundAmount());

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested(globals.isTokenRequested());

		// Address
		if (globals.getPostalCode() != null) {
			address.setBillingZipcode(globals.getPostalCode());
			address.setCity(globals.getCity());
			address.setState(globals.getState());
			address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
					.getCountryCode()));
		} else
			address = null;

		// card - credit
		card.setCardType(CreditCardNetworkType.valueOf(globals.getCardType()));
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);
			if (!globals.getCardSecurityCode().isEmpty())
				card.setCVV(globals.getCardSecurityCode());
			else
				card.setCVV(null);
			if (globals.isCardToken()) {
				card.setTokenId(globals.getTokenId());
				card.setTokenValue(globals.getTokenValue());
			}
		} else if (globals.isCardSwiped()) {
			if (globals.getEntryMode().equalsIgnoreCase("track1")) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getEntryMode().equalsIgnoreCase("track2")) {
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

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		terminal.setPinEntry(PinEntryType.valueOf(globals.getPinEntry()));
		terminal.setBalanceInquiry(globals.isBalanceEnquiry());
		terminal.setHostAdjustment(globals.isHostAdjustment());

		// Set Device Type

		String deviceType = globals.getCaptureDevice();
		terminal.setDeviceType(DeviceTypeCode.fromValue(deviceType));

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode(CardInputCodeType.MagstripeRead);
		else
			terminal.setCardInputCode(CardInputCodeType.ManualKeyed);

		// Transaction values
		transaction.setTransactionAmount("0.00");

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested(true);

		// Address
		if (globals.getPostalCode() != null) {
			address.setBillingZipcode(globals.getPostalCode());
			address.setCity(globals.getCity());
			address.setState(globals.getState());
			address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
					.getCountryCode()));
		} else
			address = null;

		// card - credit
		card.setCardType(CreditCardNetworkType.valueOf(globals.getCardType()));
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);
			if (!globals.getCardSecurityCode().isEmpty())
				card.setCVV(globals.getCardSecurityCode());
			else
				card.setCVV(null);

		} else if (globals.isCardSwiped()) {
			if (globals.getEntryMode().equalsIgnoreCase("track1")) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getEntryMode().equalsIgnoreCase("track2")) {
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

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		terminal.setPinEntry(PinEntryType.valueOf(globals.getPinEntry()));
		terminal.setBalanceInquiry(globals.isBalanceEnquiry());
		terminal.setHostAdjustment(globals.isHostAdjustment());

		// Set Device Type

		String deviceType = globals.getCaptureDevice();
		terminal.setDeviceType(DeviceTypeCode.fromValue(deviceType));

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
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

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		terminal.setPinEntry(PinEntryType.valueOf(globals.getPinEntry()));
		terminal.setBalanceInquiry(globals.isBalanceEnquiry());
		terminal.setHostAdjustment(globals.isHostAdjustment());

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType(DeviceTypeCode.Terminal);
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType(DeviceTypeCode.Software);
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType(DeviceTypeCode.Mobile);

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
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

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		terminal.setPinEntry(PinEntryType.valueOf(globals.getPinEntry()));
		// terminal.setBalanceInquiry(globals.isBalanceEnquiry());
		terminal.setHostAdjustment(globals.isHostAdjustment());

		// Set Device Type

		String deviceType = globals.getCaptureDevice();
		terminal.setDeviceType(DeviceTypeCode.fromValue(deviceType));

		// Card input code

		terminal.setCardInputCode(CardInputCodeType.ManualKeyed);

		// Transaction values
		transaction.setAuthorizationCode(globals.getAuthorizationCode());
		transaction.setOriginalReferenceNumber(globals.getOriginalRefNum());
		transaction.setAdjustedTotalAmount(globals.getAdjustedAmount());

		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());

		transaction.setOriginalAuthorizedAmount(globals.getTransactionAmount());
		transaction.setTipAmount(globals.getTipAmount());

		// Address
		if (globals.getPostalCode() != null) {
			address.setBillingZipcode(globals.getPostalCode());
			address.setCity(globals.getCity());
			address.setState(globals.getState());
			address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
					.getCountryCode()));
		} else
			address = null;

		// card - credit
		card.setCardType(CreditCardNetworkType.valueOf(globals.getCardType()));

		card.setCardNumber(globals.getPrimaryAcountNumber());
		String[] expirationDate = globals.getExpirationDate().split("-");
		card.setExpirationMonth(expirationDate[1]);
		card.setExpirationYear(expirationDate[0]);
		if (!globals.getCardSecurityCode().isEmpty())
			card.setCVV(globals.getCardSecurityCode());
		else
			card.setCVV(null);
		if (globals.isCardToken()) {
			card.setTokenId(globals.getTokenId());
			card.setTokenValue(globals.getTokenValue());
		}

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

	public ApigeeObject createActivate() {
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
		terminal.setTerminalID("" + "" + globals.getTerminalID());

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType(DeviceTypeCode.Terminal);
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType(DeviceTypeCode.Software);
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType(DeviceTypeCode.Mobile);

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode(CardInputCodeType.MagstripeRead);
		else
			terminal.setCardInputCode(CardInputCodeType.ManualKeyed);

		// Transaction values
		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested(globals.isTokenRequested());

		transaction.setTransactionAmount(globals.getTransactionAmount());

		// Address
		if (globals.getPostalCode() != null) {
			address.setBillingZipcode(globals.getPostalCode());
			address.setCity(globals.getCity());
			address.setState(globals.getState());
			address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
					.getCountryCode()));
		} else
			address = null;

		card.setGiftCardSecurityCode(globals.getGiftCardSecurityCode());
		card.setCardDataKeySerialNumber(globals.getGiftCardPin());
		// card - credit
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);

		} else if (globals.isCardSwiped()) {
			if (globals.getEntryMode().equals("track1")) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getEntryMode().equals("track2")) {
				card.setTrack2Data(globals.getTrack2Data());
			}
		}

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

	public ApigeeObject createReload() {
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
		terminal.setTerminalID("" + "" + globals.getTerminalID());

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType(DeviceTypeCode.Terminal);
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType(DeviceTypeCode.Software);
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType(DeviceTypeCode.Mobile);

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode(CardInputCodeType.MagstripeRead);
		else
			terminal.setCardInputCode(CardInputCodeType.ManualKeyed);

		// Transaction values
		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested(globals.isTokenRequested());

		transaction.setTransactionAmount(globals.getTransactionAmount());

		// Address
		if (globals.getPostalCode() != null) {
			address.setBillingZipcode(globals.getPostalCode());
			address.setCity(globals.getCity());
			address.setState(globals.getState());
			address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
					.getCountryCode()));
		} else
			address = null;

		card.setGiftCardSecurityCode(globals.getGiftCardSecurityCode());
		card.setCardDataKeySerialNumber(globals.getGiftCardPin());
		// card - credit
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);

		} else if (globals.isCardSwiped()) {
			if (globals.getEntryMode().equals("track1")) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getEntryMode().equals("track2")) {
				card.setTrack2Data(globals.getTrack2Data());
			}
		}

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

	public ApigeeObject createUnload() {
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
		terminal.setTerminalID("" + "" + globals.getTerminalID());

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType(DeviceTypeCode.Terminal);
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType(DeviceTypeCode.Software);
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType(DeviceTypeCode.Mobile);

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode(CardInputCodeType.MagstripeRead);
		else
			terminal.setCardInputCode(CardInputCodeType.ManualKeyed);

		// Transaction values
		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested(globals.isTokenRequested());

		transaction.setTransactionAmount(globals.getTransactionAmount());

		// Address
		if (globals.getPostalCode() != null) {
			address.setBillingZipcode(globals.getPostalCode());
			address.setCity(globals.getCity());
			address.setState(globals.getState());
			address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
					.getCountryCode()));
		} else
			address = null;

		card.setGiftCardSecurityCode(globals.getGiftCardSecurityCode());
		card.setCardDataKeySerialNumber(globals.getGiftCardPin());
		// card - credit
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);

		} else if (globals.isCardSwiped()) {
			if (globals.getEntryMode().equals("track1")) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getEntryMode().equals("track2")) {
				card.setTrack2Data(globals.getTrack2Data());
			}
		}

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

	public ApigeeObject createClose() {
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
		terminal.setTerminalID("" + "" + globals.getTerminalID());

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType(DeviceTypeCode.Terminal);
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType(DeviceTypeCode.Software);
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType(DeviceTypeCode.Mobile);

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode(CardInputCodeType.MagstripeRead);
		else
			terminal.setCardInputCode(CardInputCodeType.ManualKeyed);

		// Transaction values
		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested(globals.isTokenRequested());

		transaction.setTransactionAmount(globals.getTransactionAmount());

		// Address
		if (globals.getPostalCode() != null) {
			address.setBillingZipcode(globals.getPostalCode());
			address.setCity(globals.getCity());
			address.setState(globals.getState());
			address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
					.getCountryCode()));
		} else
			address = null;

		card.setGiftCardSecurityCode(globals.getGiftCardSecurityCode());
		card.setCardDataKeySerialNumber(globals.getGiftCardPin());
		// card - credit
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);

		} else if (globals.isCardSwiped()) {
			if (globals.getEntryMode().equals("track1")) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getEntryMode().equals("track2")) {
				card.setTrack2Data(globals.getTrack2Data());
			}
		}

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

	public ApigeeObject createBalanceInquiry() {
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
		terminal.setTerminalID("" + "" + globals.getTerminalID());

		terminal.setIPv4Address(globals.getiPv4Address());
		terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
				.valueOf(globals.getClassification()));

		// Set Device Type
		String transactionType = globals.getTransactionType();
		if (transactionType.equalsIgnoreCase("present"))
			terminal.setDeviceType(DeviceTypeCode.Terminal);
		else if (transactionType.equalsIgnoreCase("ecommerce"))
			terminal.setDeviceType(DeviceTypeCode.Software);
		else if (transactionType.equalsIgnoreCase("moto"))
			terminal.setDeviceType(DeviceTypeCode.Mobile);

		// Card input code
		if (globals.getCardReader().equals("magstripe"))
			terminal.setCardInputCode(CardInputCodeType.MagstripeRead);
		else
			terminal.setCardInputCode(CardInputCodeType.ManualKeyed);

		// Transaction values
		transaction.setTransactionID(globals.getSequenceNumber());
		transaction.setPaymentType(PaymentTypeEnum.fromValue(globals
				.getPaymentType()));
		transaction.setReferenceNumber(globals.getReferenceNumber());
		transaction.setDraftLocatorId(globals.getDraftLocatorId());
		transaction.setClerkNumber("" + globals.getMerchant().getClerkNumber());
		transaction.setMarketCode(MarketCodeType.fromValue(globals
				.getTransactionType()));
		transaction.setTransactionTimestamp(timestamp);
		transaction.setSystemTraceId("" + globals.getSystemTraceId());
		transaction.setTokenRequested(globals.isTokenRequested());

		transaction.setTransactionAmount(globals.getTransactionAmount());

		// Address
		if (globals.getPostalCode() != null) {
			address.setBillingZipcode(globals.getPostalCode());
			address.setCity(globals.getCity());
			address.setState(globals.getState());
			address.setCountryCode(ISO3166CountryCodeType.fromValue(globals
					.getCountryCode()));
		} else
			address = null;

		card.setGiftCardSecurityCode(globals.getGiftCardSecurityCode());
		card.setCardDataKeySerialNumber(globals.getGiftCardPin());
		// card - credit
		if (globals.isCardKeyed()) {
			card.setCardNumber(globals.getPrimaryAcountNumber());
			String[] expirationDate = globals.getExpirationDate().split("-");
			card.setExpirationMonth(expirationDate[1]);
			card.setExpirationYear(expirationDate[0]);

		} else if (globals.isCardSwiped()) {
			if (globals.getEntryMode().equals("track1")) {
				card.setTrack1Data(globals.getTrack1Data());
			} else if (globals.getEntryMode().equals("track2")) {
				card.setTrack2Data(globals.getTrack2Data());
			}
		}

		ApigeeObject ao = new ApigeeObject(cred, merchant, terminal,
				transaction, address, card);
		return ao;
	}

}
