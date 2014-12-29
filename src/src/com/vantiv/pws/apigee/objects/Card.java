/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.apigee.objects;

import com.vantiv.pws.apigee.objects.Enums.AccountTypeEnum;
import com.vantiv.pws.apigee.objects.Enums.CreditCardNetworkType;
import com.vantiv.pws.apigee.objects.Enums.EncryptionType;


public class Card {

	private CreditCardNetworkType CardType;
	private String CardNumber;
	private String GiftCardSecurityCode;
	private String ExpirationMonth;
	private String ExpirationYear;
	private String Track1Data;
	private String EncryptedTrack1Data;
	private String Track2Data;
	private String EncryptedTrack2Data;
	private String CardDataKeySerialNumber;
	private EncryptionType EncryptedFormat;
	private String PINBlock;
	private String PINBlockEncryptedFormat;
	private String TokenId;
	private String TokenValue;
	private String CVV;
	private String CardholderName;
	private AccountTypeEnum AccountType;
	private String KeySerialNumber;
	private String PartialApprovalCode;

	

	public String getTransType() {
		if (this.GiftCardSecurityCode != null
				&& this.CardDataKeySerialNumber != null)
			return "gift";
		else if (this.PINBlock != null && this.KeySerialNumber != null)
			return "debit";
		else
			return "credit";
	}

	public CreditCardNetworkType getCardType() {
		return CardType;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	public String getGiftCardSecurityCode() {
		return GiftCardSecurityCode;
	}

	public void setGiftCardSecurityCode(String giftCardSecurityCode) {
		GiftCardSecurityCode = giftCardSecurityCode;
	}

	public String getExpirationMonth() {
		return ExpirationMonth;
	}

	public void setExpirationMonth(String expirationMonth) {
		ExpirationMonth = expirationMonth;
	}

	public String getExpirationYear() {
		return ExpirationYear;
	}

	public void setExpirationYear(String expirationYear) {
		ExpirationYear = expirationYear;
	}

	public String getTrack1Data() {
		return Track1Data;
	}

	public void setTrack1Data(String track1Data) {
		Track1Data = track1Data;
	}

	public String getEncryptedTrack1Data() {
		return EncryptedTrack1Data;
	}

	public void setEncryptedTrack1Data(String encryptedTrack1Data) {
		EncryptedTrack1Data = encryptedTrack1Data;
	}

	public String getTrack2Data() {
		return Track2Data;
	}

	public void setTrack2Data(String track2Data) {
		Track2Data = track2Data;
	}

	public String getEncryptedTrack2Data() {
		return EncryptedTrack2Data;
	}

	public void setEncryptedTrack2Data(String encryptedTrack2Data) {
		EncryptedTrack2Data = encryptedTrack2Data;
	}

	public String getCardDataKeySerialNumber() {
		return CardDataKeySerialNumber;
	}

	public void setCardDataKeySerialNumber(String cardDataKeySerialNumber) {
		CardDataKeySerialNumber = cardDataKeySerialNumber;
	}

	public EncryptionType getEncryptedFormat() {
		return EncryptedFormat;
	}

	public void setEncryptedFormat(EncryptionType encryptedFormat) {
		EncryptedFormat = encryptedFormat;
	}

	public String getPINBlock() {
		return PINBlock;
	}

	public void setPINBlock(String pINBlock) {
		PINBlock = pINBlock;
	}

	public String getPINBlockEncryptedFormat() {
		return PINBlockEncryptedFormat;
	}

	public void setPINBlockEncryptedFormat(String pINBlockEncryptedFormat) {
		PINBlockEncryptedFormat = pINBlockEncryptedFormat;
	}

	public String getTokenId() {
		return TokenId;
	}

	public void setTokenId(String tokenId) {
		TokenId = tokenId;
	}

	public String getTokenValue() {
		return TokenValue;
	}

	public void setTokenValue(String tokenValue) {
		TokenValue = tokenValue;
	}

	public String getCVV() {
		return CVV;
	}

	public void setCVV(String cVV) {
		CVV = cVV;
	}

	public String getCardholderName() {
		return CardholderName;
	}

	public void setCardholderName(String cardholderName) {
		CardholderName = cardholderName;
	}

	public AccountTypeEnum getAccountType() {
		return AccountType;
	}

	public void setAccountType(AccountTypeEnum accountType) {
		AccountType = accountType;
	}

	public void setCardType(CreditCardNetworkType cardType) {
		CardType = cardType;
	}

	public String getKeySerialNumber() {
		return KeySerialNumber;
	}

	public void setKeySerialNumber(String keySerialNumber) {
		KeySerialNumber = keySerialNumber;
	}

	public String getPartialApprovalCode() {
		return PartialApprovalCode;
	}

	public void setPartialApprovalCode(String partialApprovalCode) {
		PartialApprovalCode = partialApprovalCode;
	}

}
