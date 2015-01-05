/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.resources;

import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

import com.vantiv.types.common.v6.AddressType;
import com.vantiv.types.common.v6.AmountType;
import com.vantiv.types.common.v6.EncryptedData;
import com.vantiv.types.common.v6.EncryptionType;
import com.vantiv.types.common.v6.GeolocationType;
import com.vantiv.types.common.v6.ISO3166CountryCodeType;
import com.vantiv.types.common.v6.ISO4217CurrencyCodeType;
import com.vantiv.types.common.v6.ReplacementAmountType;
import com.vantiv.types.common.v6.StateCodeType;
import com.vantiv.types.payment.instruments.v6.AccountType;
import com.vantiv.types.payment.instruments.v6.CardSwipedType;
import com.vantiv.types.payment.instruments.v6.CreditCardNetworkType;
import com.vantiv.types.payment.instruments.v6.CreditInstrumentType;
import com.vantiv.types.payment.instruments.v6.CreditOrDebitCardKeyedType;
import com.vantiv.types.payment.instruments.v6.DebitInstrumentType;
import com.vantiv.types.payment.instruments.v6.GiftCardKeyedType;
import com.vantiv.types.payment.instruments.v6.GiftCardSwipedType;
import com.vantiv.types.payment.instruments.v6.GiftInstrumentType;
import com.vantiv.types.payment.instruments.v6.PartialIndicatorType;
import com.vantiv.types.payment.instruments.v6.ThreeDSecureType;
import com.vantiv.types.payment.instruments.v6.TokenType;
import com.vantiv.types.payment.instruments.v6.TrackDataType;
import com.vantiv.types.payment.systems.v6.CardReaderType;
import com.vantiv.types.payment.systems.v6.EntryModeType;
import com.vantiv.types.payment.systems.v6.MobileDeviceType;
import com.vantiv.types.payment.systems.v6.PaymentDeviceType;
import com.vantiv.types.payment.systems.v6.PinEntryType;
import com.vantiv.types.payment.systems.v6.TerminalClassificationType;
import com.vantiv.types.payment.transactions.v6.BillPaymentPayeeType;
import com.vantiv.types.payment.transactions.v6.CancelTransactionType;
import com.vantiv.types.payment.transactions.v6.MerchantType;
import com.vantiv.types.payment.transactions.v6.ReversalReasonType;
import com.vantiv.types.payment.transactions.v6.TaxAmountType;

/**
 * This class stores all values that can be sent to PWS. This class is used as a
 * lookup when creating SOAP/JSON objects and sending SOAP/JSON messages.
 * 
 */
public class DataStore {
	private Utils util = new Utils();
	// ************FLAGS*****************//
	private boolean isCardKeyed = true;
	private boolean isCardSwiped = false;
	private boolean isDebit = false;
	private boolean isGift = false;
	private boolean isCredit = true;

	private boolean isTaxPresent = false;
	private boolean isCardToken = false;
	private boolean isTrackEncrypted = false;
	private boolean isThreeDSecure = false;
	private String captureDevice = "Terminal";
	// *************************************//

	// *****************************************//
	// Global variables and their default values//
	// *****************************************//
	private String apigeeEndpt = "https://apis.cert.vantiv.com/v1/";
	private String licenseID = "572d606c967f412cb8d840e38fb48010$$#$$MphfoMed030iGRXOd6pBhDzGQnzEMmz7$$#$$2015-11-26$$#$$dev_key$$#$$SHA512withRSA$$#$$RSA$$#$$1$$#$$52BC72E18D55CC77AE2DE3C27C0AFE6C0FCE3E3E6C1638EE824E5DB7775ADBBB616D82127D46DF9272D6A39ABC6BA8AD6797000A52F769C982B5360C06CED1FFA8FABA0DEA70E1CD77DC4DAF912E81319538857CAABE16DB6C412AF478BC059B29232337AE09020069B96E741982FB5E6BC053E98FE7C33789288CAA6A9883C0D2380DD1812FCF2681A8B31545B97DD0736EB3ECBD9329F144CDB93C35780559DB6219604ADB3F5A8DC57E06CFD715FFCECD3CB65DE7BFDA065D4DB3BDC84B7E0FD66116C71AC41E0B875BA18C742A8ECE9E690AC37457DD43845F5C64EA00BF7B585A6FCF75A0F398026CD79C74C3C946C11BAFD1404997917C5592B91E8415";

	// *************Transaction data***************//

	private String username = "s.MID5.PAY.WS.NP";
	private String password = "Tu2u2AHU";
	private long systemTraceId = 100000;
	private long originalSystemTraceId = 100000;
	private String merchantRefId = "654321";
	private String referenceNumber = "100001";
	// present, moto, or ecommerce
	private String transactionType = "present";
	private String transactionTimestamp = "";
	private String transmissionTimestamp = "";
	// optional
	private String paymentType = "single";
	private String draftLocatorId = "100000001";
	private boolean tokenRequested = true;
	private String payeeAccountNumber = null;
	private String payeeName = null;
	private String payeePhoneNumber = null;
	private String networkResponseCode = "00";
	private String reportGroup = null;
	private String purchaseOrder = null;
	private boolean isTaxable = false;
	private boolean isTaxExempt = false;
	private boolean isPurchaseLevel = false;
	private String taxAmount = null;
	private String taxCurrency = "USD";
	private String forceApprovalCode = null;
	// captures
	private String authorizationCode = null;
	private String convenienceFee = "1.00";
	private String settlementAmount = null;
	private String tipAmount = null;
	// Cancels
	private String cancelTransactionType = "authorize";
	private String reversalReason = null;
	private String replacementAmount = null;
	private String originalTimestamp = null;
	private String originalRefNum = null;
	// adjust
	private String adjustedAmount = null;
	// refund
	private String refundAmount = null;
	// *****************************************//

	// *************Amount data***************//
	private String transactionAmount = "2.05";
	private String cashBackAmount = null;
	private String currency = "USD";
	// ***************************************//

	// *************merchant data***************//
	private String merchantId = "4445012916098";
	private String merchantName = "ABCDEF";// used for pin-less debit
	private String networkRouting = "2J";
	// optional
	private int clerkNumber = 1234;
	private int cashierNumber = 12345678;
	private String divisionNumber = "000";
	private String laneNumber = "123";
	private String storeNumber = "00000001";
	private String chainCode = "70110";
	// ***************************************//

	// ***************Capture Device Data**************//
	private int terminalID = 001;
	private String sequenceNumber = "123456";
	private String entryMode = "manual";
	// conditional
	private String pinEntry = "none";
	// optional
	private String iPv4Address = "192.0.2.235";
	private String classification = "electronic_cash_register";// "unspecified";
	private String cardReader = "none";
	private boolean balanceEnquiry = true;
	private boolean hostAdjustment = false;
	private String longitude = "84.327909";
	private String latitude = "39.270895";
	// ***************************************//

	// *************Address data***************//
	private String addressline = "1234 Main Street";
	private String city = "Cincinnati";
	private String countryCode = "US";
	private String postalCode = "45209";
	private String state = "OH";
	// ***************************************//

	// *************Card data***************//
	private String primaryAcountNumber = "4445222299990007";
	private String encryptedPAN = null;
	private String expirationDate = "2014-12";
	private String cardType = "visa";
	private String partialIndicator = "not_supported";
	private String track1Data = null;
	private String track2Data = null;
	private String cardSecurityCode = "382";
	private String cardHolderName = null;
	private String giftCardPin = "";
	private String giftCardSecurityCode = "";
	private String accountType = null;
	private String pinData = "";
	// threeDSecure

	private String authenticationValue = null;
	private String eCommerceIndicator = null;
	private String transactionId = null;
	// token
	private String tokenId = null;
	private String tokenValue = null;
	// encrypted data
	private String cardEncryptedValue = "";
	private String cardEncryptedKey = "";
	private String cardEncryptedType = "";

	private String pinEncryptedValue = "";
	private String pinEncryptedKey = "";
	private String pinEncryptedType = "";

	// testing variables
	private String testName = null;

	// ******************End of Variables*********************//

	// ********************Logic Functions**********************//

	/**
	 * Constructs the BillPaymentPayeeType object and returns it.
	 */
	public BillPaymentPayeeType getBillPaymentPayeeType() {
		if (payeeAccountNumber != null && payeeName != null
				&& payeePhoneNumber != null) {
			BillPaymentPayeeType billPaymentPayee = new BillPaymentPayeeType();
			billPaymentPayee.setPayeeAccountNumber(payeeAccountNumber);
			billPaymentPayee.setPayeeName(payeeName);
			billPaymentPayee.setPayeePhoneNumber(payeePhoneNumber);
			return billPaymentPayee;
		} else
			return null;
	}

	/**
	 * Constructs the CreditInstrumentType and returns it. Adds the CardKeyed,
	 * or CardSwiped object to the Credit InstrumentType depending on the flags.
	 */
	public CreditInstrumentType getCreditInstument() {
		CreditInstrumentType creditInstrument = new CreditInstrumentType();

		if (addressline != null && postalCode != null)
			creditInstrument.setCardholderAddress(getAddress());

		if (isCardKeyed) {
			creditInstrument.setCardKeyed(getCardKeyed());
		} else if (isCardSwiped) {
			creditInstrument.setCardSwiped(getCardSwiped());
		}

		creditInstrument.setCardType(CreditCardNetworkType.fromValue(cardType));
		creditInstrument.setPartialApprovalCode(PartialIndicatorType
				.fromValue(partialIndicator));

		return creditInstrument;
	}

	/**
	 * Constructs the CreditInstrumentType and returns it. Adds the CardKeyed,
	 * or CardSwiped object to the Credit InstrumentType depending on the flags.
	 */
	public CreditInstrumentType getMaskedCreditInstument() {
		CreditInstrumentType creditInstrument = new CreditInstrumentType();

		if (addressline != null && postalCode != null)
			creditInstrument.setCardholderAddress(getAddress());

		creditInstrument.setCardKeyed(getMaskedCardKeyed());

		creditInstrument.setCardType(CreditCardNetworkType.fromValue(cardType));
		creditInstrument.setPartialApprovalCode(PartialIndicatorType
				.fromValue(partialIndicator));

		return creditInstrument;
	}

	/**
	 * Constructs the DebitInstrumentType and returns it. Adds the CardKeyed, or
	 * CardSwiped object to the Credit InstrumentType depending on the flags.
	 */
	public DebitInstrumentType getDebitInstument() {
		System.out.println("Getting debit...");
		DebitInstrumentType debitInstrument = new DebitInstrumentType();

		if (isCardKeyed) {
			debitInstrument.setCardKeyed(getCardKeyed());
		} else if (isCardSwiped) {
			debitInstrument.setCardSwiped(getCardSwiped());
		}
		EncryptedData eData = new EncryptedData();
		eData.setEncryptionType(EncryptionType.fromValue(pinEncryptedType));
		eData.setKey(pinEncryptedKey);
		eData.setValue(pinEncryptedValue);

		debitInstrument.setPinData(eData);
		debitInstrument.setPartialApprovalCode(PartialIndicatorType
				.fromValue(partialIndicator));
		debitInstrument.setAccountType(AccountType.CHECKING);

		return debitInstrument;
	}

	/**
	 * Constructs the CreditInstrumentType and returns it. Adds the CardKeyed,
	 * or CardSwiped object to the Credit InstrumentType depending on the flags.
	 */
	public GiftInstrumentType getGiftCard() {

		GiftInstrumentType gift = new GiftInstrumentType();

		if (isCardKeyed) {
			gift.setCardKeyed(getGiftCardKeyed());
		} else if (isCardSwiped) {
			gift.setCardSwiped(getGiftCardSwiped());
		}

		return gift;
	}

	/**
	 * Sets all values related to the merchant, then returns the merchantType
	 */
	public MerchantType getMerchant() {
		MerchantType merchantType = new MerchantType();
		merchantType.setCashierNumber(cashierNumber);
		merchantType.setChainCode(chainCode);
		merchantType.setClerkNumber(clerkNumber);
		merchantType.setDivisionNumber(divisionNumber);
		merchantType.setLaneNumber(laneNumber);
		merchantType.setMerchantId(merchantId);
		merchantType.setMerchantName(merchantName);
		merchantType.setStoreNumber(storeNumber);
		merchantType.setNetworkRouting(networkRouting);

		if (captureDevice.equalsIgnoreCase("software"))
			merchantType.setSoftware(getPaymentDevice(captureDevice));
		else if (captureDevice.equalsIgnoreCase("terminal"))
			merchantType.setTerminal(getPaymentDevice(captureDevice));
		else if (captureDevice.equalsIgnoreCase("mobile"))
			merchantType.setMobile(getMobileDevice());

		return merchantType;

	}

	/**
	 * If the capture device is "Software" or "Terminal", this will construct
	 * the PaymentDeviceType and return it.
	 */
	public PaymentDeviceType getPaymentDevice(String captureDevice) {
		PaymentDeviceType paymentDevice = new PaymentDeviceType();
		if (captureDevice.equalsIgnoreCase("software")
				|| captureDevice.equalsIgnoreCase("terminal")) {
			paymentDevice.setBalanceInquiry(balanceEnquiry);
			paymentDevice.setCardReader(CardReaderType.fromValue(cardReader));
			paymentDevice.setClassification(TerminalClassificationType
					.fromValue(classification));
			paymentDevice.setEntryMode(EntryModeType.fromValue(entryMode));
			paymentDevice.setHostAdjustment(hostAdjustment);
			paymentDevice.setIPv4Address(iPv4Address);
			paymentDevice.setPinEntry(PinEntryType.fromValue(pinEntry));
			paymentDevice.setSequenceNumber(sequenceNumber);
			paymentDevice.setTerminalID(terminalID);
		}
		return paymentDevice;
	}

	/**
	 * If the capture device is "Mobile", this will construct the
	 * MobileDeviceType and return it.
	 */
	public MobileDeviceType getMobileDevice() {
		MobileDeviceType mobile = new MobileDeviceType();
		mobile.setBalanceInquiry(balanceEnquiry);
		mobile.setCardReader(CardReaderType.fromValue(cardReader));
		mobile.setClassification(TerminalClassificationType
				.fromValue(classification));
		mobile.setEntryMode(EntryModeType.fromValue(entryMode));
		mobile.setHostAdjustment(hostAdjustment);
		mobile.setIPv4Address(iPv4Address);
		mobile.setPinEntry(PinEntryType.fromValue(pinEntry));
		mobile.setSequenceNumber(sequenceNumber);
		mobile.setTerminalID(terminalID);
		GeolocationType loc = new GeolocationType();
		loc.setLatitude(new BigDecimal(latitude));
		loc.setLongitude(new BigDecimal(longitude));
		mobile.setLocation(loc);
		return mobile;
	}

	/**
	 * Constructs an AddressType object and returns it.
	 */
	public AddressType getAddress() {
		AddressType address = new AddressType();
		address.setAddressLine(addressline);
		address.setCity(city);
		address.setPostalCode(postalCode);
		address.setState(StateCodeType.fromValue(state));
		address.setCountryCode(ISO3166CountryCodeType.fromValue(countryCode));

		return address;
	}

	/**
	 * Constructs a CardSwipedType object and returns it.
	 */
	public CardSwipedType getCardSwiped() {
		CardSwipedType cardSwiped = new CardSwipedType();

		TrackDataType track1 = new TrackDataType();
		TrackDataType track2 = new TrackDataType();
		EncryptedData eData = new EncryptedData();

		if (entryMode.equals("track1")) {

			if (isTrackEncrypted) {
				eData.setEncryptionType(EncryptionType
						.fromValue(cardEncryptedType));
				eData.setKey(cardEncryptedKey);
				eData.setValue(cardEncryptedValue);
				track1.setEncryptedTrackData(eData);
				cardSwiped.setTrack1(track1);
			} else {
				track1.setTrackData(track1Data);
				cardSwiped.setTrack1(track1);
			}
		} else if (entryMode.equals("track2")) {

			if (isTrackEncrypted) {
				eData.setEncryptionType(EncryptionType
						.fromValue(cardEncryptedType));
				eData.setKey(cardEncryptedKey);
				System.out.println("Setting card encryption: "
						+ cardEncryptedValue);
				eData.setValue(cardEncryptedValue);
				track2.setEncryptedTrackData(eData);
				cardSwiped.setTrack2(track2);
			} else {
				track2.setTrackData(track2Data);
				cardSwiped.setTrack2(track2);
			}
		}
		return cardSwiped;
	}

	/**
	 * Constructs a CardKeyedType object and returns it.
	 */
	public CreditOrDebitCardKeyedType getCardKeyed() {
		CreditOrDebitCardKeyedType cardKeyed = new CreditOrDebitCardKeyedType();
		cardKeyed.setCardholderName(cardHolderName);
		cardKeyed.setCardSecurityCode(cardSecurityCode);
		cardKeyed.setExpirationDate(util.stringToXMLGregorian(expirationDate));

		if (isThreeDSecure) {
			ThreeDSecureType threeD = new ThreeDSecureType();
			threeD.setAuthenticationValue(authenticationValue);
			threeD.setECommerceIndicator(eCommerceIndicator);
			threeD.setTransactionID(transactionId);
			cardKeyed.setThreeDSecure(threeD);
		} else if (isTrackEncrypted) {
			EncryptedData eData = new EncryptedData();
			eData.setEncryptionType(EncryptionType.fromValue(cardEncryptedType));
			eData.setKey(cardEncryptedValue);
			eData.setValue(cardEncryptedKey);
			cardKeyed.setEncryptedPrimaryAccountNumber(eData);
		} else if (isCardToken) {
			System.out.println("USING A TOKEN...Id:" + this.tokenId
					+ " Value: " + this.tokenValue);
			TokenType token = new TokenType();
			token.setTokenId(tokenId);
			token.setTokenValue(tokenValue);
			cardKeyed.setToken(token);
		} else {
			cardKeyed.setPrimaryAccountNumber(primaryAcountNumber);
		}

		return cardKeyed;
	}

	/**
	 * Constructs a CardKeyedType object and returns it.
	 */
	public CreditOrDebitCardKeyedType getMaskedCardKeyed() {
		CreditOrDebitCardKeyedType cardKeyed = new CreditOrDebitCardKeyedType();
		cardKeyed.setCardholderName(cardHolderName);

		if (isThreeDSecure) {
			ThreeDSecureType threeD = new ThreeDSecureType();
			threeD.setAuthenticationValue(authenticationValue);
			threeD.setECommerceIndicator(eCommerceIndicator);
			threeD.setTransactionID(transactionId);
			cardKeyed.setThreeDSecure(threeD);
		} else if (isTrackEncrypted) {
			EncryptedData eData = new EncryptedData();
			eData.setEncryptionType(EncryptionType.fromValue(cardEncryptedType));
			eData.setKey(cardEncryptedValue);
			eData.setValue(cardEncryptedKey);
			cardKeyed.setEncryptedPrimaryAccountNumber(eData);
		} else if (isCardToken) {
			System.out.println("USING A TOKEN...Id:" + this.tokenId
					+ " Value: " + this.tokenValue);
			TokenType token = new TokenType();
			token.setTokenId(tokenId);
			token.setTokenValue(tokenValue);
			cardKeyed.setToken(token);
		} else {
			cardKeyed.setPrimaryAccountNumber(util
					.getMaskedPan(primaryAcountNumber));
		}

		return cardKeyed;
	}

	// GiftCard keyed information
	public GiftCardKeyedType getGiftCardKeyed() {
		GiftCardKeyedType giftCard = new GiftCardKeyedType();
		giftCard.setCardSecurityCode(this.giftCardSecurityCode);
		giftCard.setPrimaryAccountNumber(this.primaryAcountNumber);
		giftCard.setGiftCardPin(this.giftCardPin);
		giftCard.setExpirationDate(util
				.stringToXMLGregorian(this.expirationDate));

		return giftCard;
	}

	public XMLGregorianCalendar getOriginalTimestampXML() {
		return util.stringToXMLGregorian(originalTimestamp);
	}

	public GiftCardSwipedType getGiftCardSwiped() {
		GiftCardSwipedType giftCard = new GiftCardSwipedType();
		giftCard.setCardSecurityCode(this.giftCardSecurityCode);
		giftCard.setGiftCardPin(this.giftCardPin);
		TrackDataType track1 = new TrackDataType();
		TrackDataType track2 = new TrackDataType();
		if (entryMode.equals("track1")) {
			track1.setTrackData(track1Data);
			giftCard.setTrack1(track1);
		}
		if (entryMode.equals("track2")) {
			track2.setTrackData(track2Data);
			giftCard.setTrack2(track2);
		}

		return giftCard;
	}

	/**
	 * Constructs an AmountType and returns it.
	 */
	public AmountType getTransactionAmountType() {
		AmountType amt = new AmountType();

		amt.setValue(new BigDecimal(transactionAmount));
		amt.setCurrency(ISO4217CurrencyCodeType.fromValue(currency));
		return amt;
	}

	/**
	 * Constructs an AmountType and returns it.
	 */
	public AmountType getCashBackAmountType() {
		AmountType amt = new AmountType();
		amt.setValue(new BigDecimal(cashBackAmount));
		amt.setCurrency(ISO4217CurrencyCodeType.fromValue(currency));
		return amt;
	}

	public AmountType getConvenienceFeeType() {
		if (convenienceFee != null) {
			AmountType amt = new AmountType();
			amt.setValue(new BigDecimal(convenienceFee));
			amt.setCurrency(ISO4217CurrencyCodeType.fromValue(currency));
			return amt;
		} else
			return null;
	}

	public AmountType getSettlementAmountType() {
		if (settlementAmount != null) {
			AmountType amt = new AmountType();
			amt.setValue(new BigDecimal(settlementAmount));
			amt.setCurrency(ISO4217CurrencyCodeType.fromValue(currency));
			return amt;
		} else
			return null;
	}

	public AmountType getTipAmountType() {
		if (tipAmount != null) {
			AmountType amt = new AmountType();
			amt.setValue(new BigDecimal(tipAmount));
			amt.setCurrency(ISO4217CurrencyCodeType.fromValue(currency));
			return amt;
		} else
			return null;
	}

	public AmountType getRefundAmountType() {
		if (refundAmount != null) {
			AmountType amt = new AmountType();
			amt.setValue(new BigDecimal(refundAmount));
			amt.setCurrency(ISO4217CurrencyCodeType.fromValue(currency));
			return amt;
		} else
			return null;
	}

	public ReplacementAmountType getReplacementAmountType() {
		if (replacementAmount != null) {
			ReplacementAmountType amt = new ReplacementAmountType();
			amt.setValue(new BigDecimal(replacementAmount));
			amt.setCurrency(ISO4217CurrencyCodeType.fromValue(currency));
			return amt;
		} else
			return null;
	}

	public AmountType getAdjustedAmountType() {
		if (adjustedAmount != null) {
			AmountType amt = new AmountType();
			amt.setValue(new BigDecimal(adjustedAmount));
			amt.setCurrency(ISO4217CurrencyCodeType.fromValue(currency));
			return amt;
		} else
			return null;
	}

	public TaxAmountType getTax() {
		TaxAmountType tax = new TaxAmountType();
		tax.setTaxable(isTaxable);
		tax.setTaxExempt(isTaxExempt);

		AmountType taxAmt = new AmountType();
		BigDecimal temp = new BigDecimal(taxAmount);
		taxAmt.setValue(temp);

		taxAmt.setCurrency(ISO4217CurrencyCodeType.fromValue(taxCurrency));

		tax.setTaxAmount(taxAmt);
		return tax;
	}

	public ReversalReasonType getReversalReasonType() {
		return ReversalReasonType.fromValue(reversalReason);
	}

	public CancelTransactionType getCancelType() {
		return CancelTransactionType.fromValue(cancelTransactionType);
	}

	// ********************End of Logic Functions**********************//

	// ******************Getters and setters***********************//
	public long getSystemTraceId() {
		return systemTraceId++;
	}

	public void setSystemTraceId(long systemTraceId) {
		this.systemTraceId = systemTraceId;
	}

	public String getMerchantRefId() {
		return merchantRefId;
	}

	public void setMerchantRefId(String merchantRefId) {
		this.merchantRefId = merchantRefId;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionTimestamp() {
		return transactionTimestamp;
	}

	public void setTransactionTimestamp(String transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDraftLocatorId() {
		return draftLocatorId;
	}

	public void setDraftLocatorId(String draftLocatorId) {
		this.draftLocatorId = draftLocatorId;
	}

	public boolean isTokenRequested() {
		return tokenRequested;
	}

	public void setTokenRequested(boolean tokenRequested) {
		this.tokenRequested = tokenRequested;
	}

	public String getNetworkResponseCode() {
		return networkResponseCode;
	}

	public void setNetworkResponseCode(String networkResponseCode) {
		this.networkResponseCode = networkResponseCode;
	}

	public String getReportGroup() {
		return reportGroup;
	}

	public void setReportGroup(String reportGroup) {
		this.reportGroup = reportGroup;
	}

	public String getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(String purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getNetworkRouting() {
		return networkRouting;
	}

	public void setNetworkRouting(String networkRouting) {
		this.networkRouting = networkRouting;
	}

	public int getClerkNumber() {
		return clerkNumber;
	}

	public void setClerkNumber(int clerkNumber) {
		this.clerkNumber = clerkNumber;
	}

	public int getCashierNumber() {
		return cashierNumber;
	}

	public void setCashierNumber(int cashierNumber) {
		this.cashierNumber = cashierNumber;
	}

	public String getDivisionNumber() {
		return divisionNumber;
	}

	public void setDivisionNumber(String divisionNumber) {
		this.divisionNumber = divisionNumber;
	}

	public String getLaneNumber() {
		return laneNumber;
	}

	public void setLaneNumber(String laneNumber) {
		this.laneNumber = laneNumber;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getChainCode() {
		return chainCode;
	}

	public void setChainCode(String chainCode) {
		this.chainCode = chainCode;
	}

	public String getAddressline() {
		return addressline;
	}

	public void setAddressline(String addressline) {
		this.addressline = addressline;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPrimaryAcountNumber() {
		return primaryAcountNumber;
	}

	public void setPrimaryAcountNumber(String primaryAcountNumber) {
		this.primaryAcountNumber = primaryAcountNumber;
	}

	public String getEncryptedPAN() {
		return encryptedPAN;
	}

	public void setEncryptedPAN(String encryptedPAN) {
		this.encryptedPAN = encryptedPAN;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getPartialIndicator() {
		return partialIndicator;
	}

	public void setPartialIndicator(String partialIndicator) {
		this.partialIndicator = partialIndicator;
	}

	public String getTrack1Data() {
		return track1Data;
	}

	public void setTrack1Data(String track1Data) {
		this.track1Data = track1Data;
	}

	public String getTrack2Data() {
		return track2Data;
	}

	public void setTrack2Data(String track2Data) {
		this.track2Data = track2Data;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getGiftCardPin() {
		return giftCardPin;
	}

	public void setGiftCardPin(String giftCardPin) {
		this.giftCardPin = giftCardPin;
	}

	public String getGiftCardSecurityCode() {
		return giftCardSecurityCode;
	}

	public void setGiftCardSecurityCode(String giftCardSecurityCode) {
		this.giftCardSecurityCode = giftCardSecurityCode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public boolean isCardKeyed() {
		return isCardKeyed;
	}

	public void setCardKeyed(boolean isCardKeyed) {
		this.isCardKeyed = isCardKeyed;
	}

	public boolean isCardSwiped() {
		return isCardSwiped;
	}

	public void setCardSwiped(boolean isCardSwiped) {
		this.isCardSwiped = isCardSwiped;
	}

	public String getPayeeAccountNumber() {
		return payeeAccountNumber;
	}

	public void setPayeeAccountNumber(String payeeAccountNumber) {
		this.payeeAccountNumber = payeeAccountNumber;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getPayeePhoneNumber() {
		return payeePhoneNumber;
	}

	public void setPayeePhoneNumber(String payeePhoneNumber) {
		this.payeePhoneNumber = payeePhoneNumber;
	}

	public String getCardSecurityCode() {
		return cardSecurityCode;
	}

	public void setCardSecurityCode(String cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}

	public String getAuthenticationValue() {
		return authenticationValue;
	}

	public void setAuthenticationValue(String authenticationValue) {
		this.authenticationValue = authenticationValue;
	}

	public String geteCommerceIndicator() {
		return eCommerceIndicator;
	}

	public void seteCommerceIndicator(String eCommerceIndicator) {
		this.eCommerceIndicator = eCommerceIndicator;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}

	public String getAppDevice() {
		return captureDevice;
	}

	public void setAppDevice(String appDevice) {
		this.captureDevice = appDevice;
	}

	public String getCaptureDevice() {
		return captureDevice;
	}

	public void setCaptureDevice(String captureDevice) {
		this.captureDevice = captureDevice;
	}

	public boolean isTaxable() {
		return isTaxable;
	}

	public void setTaxable(boolean isTaxable) {
		this.isTaxable = isTaxable;
	}

	public boolean isTaxExempt() {
		return isTaxExempt;
	}

	public void setTaxExempt(boolean isTaxExempt) {
		this.isTaxExempt = isTaxExempt;
	}

	public String getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getTaxCurrency() {
		return taxCurrency;
	}

	public void setTaxCurrency(String taxCurrency) {
		this.taxCurrency = taxCurrency;
	}

	public int getTerminalID() {
		return terminalID;
	}

	public void setTerminalID(int terminalID) {
		this.terminalID = terminalID;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getEntryMode() {
		return entryMode;
	}

	public void setEntryMode(String entryMode) {
		this.entryMode = entryMode;
	}

	public String getPinEntry() {
		return pinEntry;
	}

	public void setPinEntry(String pinEntry) {
		this.pinEntry = pinEntry;
	}

	public String getiPv4Address() {
		return iPv4Address;
	}

	public void setiPv4Address(String iPv4Address) {
		this.iPv4Address = iPv4Address;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getCardReader() {
		return cardReader;
	}

	public void setCardReader(String cardReader) {
		this.cardReader = cardReader;
	}

	public boolean isBalanceEnquiry() {
		return balanceEnquiry;
	}

	public void setBalanceEnquiry(boolean balanceEnquiry) {
		this.balanceEnquiry = balanceEnquiry;
	}

	public boolean isHostAdjustment() {
		return hostAdjustment;
	}

	public void setHostAdjustment(boolean hostAdjustment) {
		this.hostAdjustment = hostAdjustment;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public boolean isTaxPresent() {
		return isTaxPresent;
	}

	public void setTaxPresent(boolean isTaxPresent) {
		this.isTaxPresent = isTaxPresent;
	}

	public boolean isCardToken() {
		return isCardToken;
	}

	public void setCardToken(boolean isCardToken) {
		this.isCardToken = isCardToken;
	}

	public boolean isTrackEncrypted() {
		return isTrackEncrypted;
	}

	public void setTrackEncrypted(boolean isTrackEncrypted) {
		this.isTrackEncrypted = isTrackEncrypted;
	}

	public boolean isThreeDSecure() {
		return isThreeDSecure;
	}

	public void setThreeDSecure(boolean isThreeDSecure) {
		this.isThreeDSecure = isThreeDSecure;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public String getConvenienceFee() {
		return convenienceFee;
	}

	public void setConvenienceFee(String convenienceFee) {
		this.convenienceFee = convenienceFee;
	}

	public String getSettlementAmount() {
		return settlementAmount;
	}

	public void setSettlementAmount(String settlementAmount) {
		this.settlementAmount = settlementAmount;
	}

	public String getTipAmount() {
		return tipAmount;
	}

	public void setTipAmount(String tipAmount) {
		this.tipAmount = tipAmount;
	}

	public String getCancelTransactionType() {
		return cancelTransactionType;
	}

	public void setCancelTransactionType(String cancelTransactionType) {
		this.cancelTransactionType = cancelTransactionType;
	}

	public String getReversalReason() {
		return reversalReason;
	}

	public void setReversalReason(String reversalReason) {
		this.reversalReason = reversalReason;
	}

	public String getReplacementAmount() {
		return replacementAmount;
	}

	public void setReplacementAmount(String replacementAmount) {
		this.replacementAmount = replacementAmount;
	}

	public String getTransmissionTimestamp() {
		return transmissionTimestamp;
	}

	public void setTransmissionTimestamp(String transmissionTimestamp) {
		this.transmissionTimestamp = transmissionTimestamp;
	}

	public String getOriginalTimestamp() {
		return originalTimestamp;
	}

	public void setOriginalTimestamp(String originalTimestamp) {
		this.originalTimestamp = originalTimestamp;
	}

	public String getAdjustedAmount() {
		return adjustedAmount;
	}

	public void setAdjustedAmount(String adjustedAmount) {
		this.adjustedAmount = adjustedAmount;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getPinData() {
		return pinData;
	}

	public void setPinData(String pinData) {
		this.pinData = pinData;
	}

	public String getOriginalRefNum() {
		return originalRefNum;
	}

	public void setOriginalRefNum(String originalRefNum) {
		this.originalRefNum = originalRefNum;
	}

	public boolean isPurchaseLevel() {
		return isPurchaseLevel;
	}

	public void setPurchaseLevel(boolean isPurchaseLevel) {
		this.isPurchaseLevel = isPurchaseLevel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getOriginalSystemTraceId() {
		return originalSystemTraceId;
	}

	public void setOriginalSystemTraceId(long originalSystemTraceId) {
		this.originalSystemTraceId = originalSystemTraceId;
	}

	public String getForceApprovalCode() {
		return forceApprovalCode;
	}

	public void setForceApprovalCode(String forceApprovalCode) {
		this.forceApprovalCode = forceApprovalCode;
	}

	public String getCashBackAmount() {
		return cashBackAmount;
	}

	public void setCashBackAmount(String cashBackAmount) {
		this.cashBackAmount = cashBackAmount;
	}

	public String getCardEncryptedValue() {
		return cardEncryptedValue;
	}

	public void setCardEncryptedValue(String cardEncryptedValue) {
		this.cardEncryptedValue = cardEncryptedValue;
	}

	public String getCardEncryptedKey() {
		return cardEncryptedKey;
	}

	public void setCardEncryptedKey(String cardEncryptedKey) {
		this.cardEncryptedKey = cardEncryptedKey;
	}

	public String getCardEncryptedType() {
		return cardEncryptedType;
	}

	public void setCardEncryptedType(String cardEncryptedType) {
		this.cardEncryptedType = cardEncryptedType;
	}

	public String getPinEncryptedValue() {
		return pinEncryptedValue;
	}

	public void setPinEncryptedValue(String pinEncryptedValue) {
		this.pinEncryptedValue = pinEncryptedValue;
	}

	public String getPinEncryptedKey() {
		return pinEncryptedKey;
	}

	public void setPinEncryptedKey(String pinEncryptedKey) {
		this.pinEncryptedKey = pinEncryptedKey;
	}

	public String getPinEncryptedType() {
		return pinEncryptedType;
	}

	public void setPinEncryptedType(String pinEncryptedType) {
		this.pinEncryptedType = pinEncryptedType;
	}

	public boolean isDebit() {
		return isDebit;
	}

	public void setDebit(boolean isDebit) {
		this.isDebit = isDebit;
	}

	public boolean isGift() {
		return isGift;
	}

	public void setGift(boolean isGift) {
		this.isGift = isGift;
	}

	public boolean isCredit() {
		return isCredit;
	}

	public void setCredit(boolean isCredit) {
		this.isCredit = isCredit;
	}

	public String getApigeeEndpt() {
		return apigeeEndpt;
	}

	public void setApigeeEndpt(String apigeeEndpt) {
		this.apigeeEndpt = apigeeEndpt;
	}

	public String getLicenseID() {
		return licenseID;
	}

	public void setLicenseID(String licenseID) {
		this.licenseID = licenseID;
	}

}
