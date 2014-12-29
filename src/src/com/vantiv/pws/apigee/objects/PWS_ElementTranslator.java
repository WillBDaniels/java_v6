/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.apigee.objects;

import com.vantiv.pws.apigee.objects.Enums.CancelTypeEnum;
import com.vantiv.pws.apigee.objects.Enums.CardInputCodeType;
import com.vantiv.pws.apigee.objects.Enums.CreditCardNetworkType;
import com.vantiv.pws.apigee.objects.Enums.DeviceTypeCode;
import com.vantiv.pws.apigee.objects.Enums.MarketCodeType;
import com.vantiv.pws.apigee.objects.Enums.PaymentTypeEnum;
import com.vantiv.pws.apigee.objects.Enums.PinEntryType;
import com.vantiv.pws.apigee.objects.Enums.ReversalReasonType;
import com.vantiv.pws.apigee.objects.Enums.TerminalEnvironmentType;
import com.vantiv.types.common.v6.AddressType;
import com.vantiv.types.payment.instruments.v6.CreditInstrumentType;
import com.vantiv.types.payment.systems.v6.PaymentDeviceType;
import com.vantiv.types.payment.transactions.v6.AuthorizeRequest;
import com.vantiv.types.payment.transactions.v6.BatchBalanceRequest;
import com.vantiv.types.payment.transactions.v6.BatchRequestType;
import com.vantiv.types.payment.transactions.v6.CancelRequest;
import com.vantiv.types.payment.transactions.v6.CaptureRequest;
import com.vantiv.types.payment.transactions.v6.CloseBatchRequest;
import com.vantiv.types.payment.transactions.v6.MerchantType;
import com.vantiv.types.payment.transactions.v6.PurchaseRequest;
import com.vantiv.types.payment.transactions.v6.RefundRequest;
import com.vantiv.types.payment.transactions.v6.TokenizeRequest;
import com.vantiv.types.payment.transactions.v6.TransactionRequestType;

/**
 * This class is used to translate a SOAP request to a Json Request (REST). It
 * is useful if you have consumed the WSDL and have created the java proxy
 * classes as it will convert the Request Object to a JSON object, which can
 * then be sent to Apigee through an HTTP post.
 */
public class PWS_ElementTranslator {

	private Credentials credentials;

	private Merchant merchant;
	private Terminal terminal;
	private Transaction transaction;
	private Address address;
	private Card card;

	public PWS_ElementTranslator() {
		credentials = new Credentials();
		merchant = new Merchant();
		terminal = new Terminal();
		transaction = new Transaction();
		address = new Address();
		card = new Card();
	}

	/**
	 * Translates a Transaction SOAP Request to an Element Object which can be
	 * converted to a JSON object and can be sent to Apigee.
	 */
	public ApigeeObject translateFieldstoElement(TransactionRequestType request, BatchRequestType batchRequest) {

		credentials.setAccountID("s.MID5.PAY.WS.NP");
		credentials.setPassword("Tu2u2AHU");

		AuthorizeRequest authRequest = null;
		CaptureRequest captRequest = null;
		CancelRequest cancelRequest = null;
		PurchaseRequest purchRequest = null;
		RefundRequest refundRequest = null;
		TokenizeRequest tokenRequest = null;
		CloseBatchRequest cbr = null;
		BatchBalanceRequest bbr = null;

		if(request != null){
			if (request.getClass() == AuthorizeRequest.class) {
				authRequest = (AuthorizeRequest) request;
			} else if (request.getClass() == CaptureRequest.class) {
				captRequest = (CaptureRequest) request;
			} else if (request.getClass() == CancelRequest.class) {
				cancelRequest = (CancelRequest) request;
			} else if (request.getClass() == PurchaseRequest.class) {
				purchRequest = (PurchaseRequest) request;
			} else if (request.getClass() == RefundRequest.class) {
				refundRequest = (RefundRequest) request;
			} else if (request.getClass() == TokenizeRequest.class) {
				tokenRequest = (TokenizeRequest) request;
			}
		}else if(batchRequest != null){
			if (batchRequest.getClass() == CloseBatchRequest.class) {
				cbr = (CloseBatchRequest) batchRequest;
			} else if (batchRequest.getClass() == BatchBalanceRequest.class) {
				bbr = (BatchBalanceRequest) batchRequest;
			}
		}

		AddressType addr = null;

		// application.setApplicationID(request.getMerchant().getMerchantId());
		// application.setApplicationName(request.getMerchant().getMerchantName());

		// Merchant values - for BatchRequests and TransactionRequests
		MerchantType requestMerchant = null;
		if(request != null)
			requestMerchant = request.getMerchant();
		else
			requestMerchant = batchRequest.getMerchant();
		merchant.setNetworkRouting(requestMerchant.getNetworkRouting());
		merchant.setCashierNumber(requestMerchant.getCashierNumber().toString());
		merchant.setLaneNumber(requestMerchant.getLaneNumber());
		merchant.setDivisionNumber(requestMerchant.getDivisionNumber());
		merchant.setChainCode(requestMerchant.getChainCode());
		merchant.setStoreNumber(requestMerchant.getStoreNumber());
		merchant.setMerchantId(requestMerchant.getMerchantId());

		
		PaymentDeviceType requestTerminal = null;
		// The rest for only TransactionRequests
		if (request != null) {

			// Terminal values
			if (request.getMerchant().getSoftware() != null)
				requestTerminal = request.getMerchant().getSoftware();
			else if (request.getMerchant().getTerminal() != null)
				requestTerminal = request.getMerchant().getTerminal();
			else
				requestTerminal = request.getMerchant().getMobile();

			terminal.setTerminalID("" + requestTerminal.getTerminalID());

			terminal.setIPv4Address(requestTerminal.getIPv4Address());
			terminal.setIPv6Address(requestTerminal.getIPv6Address());
			terminal.setTerminalEnvironmentalCode(TerminalEnvironmentType
					.valueOf(requestTerminal.getEntryMode().value()));

			terminal.setPinEntry(PinEntryType.valueOf(requestTerminal
					.getPinEntry().value()));
			terminal.setBalanceInquiry(requestTerminal.isBalanceInquiry());
			terminal.setHostAdjustment(requestTerminal.isHostAdjustment());
			terminal.setDeviceType(DeviceTypeCode.Software);
			if (requestTerminal.getCardReader().value().equals("magstripe"))
				terminal.setCardInputCode(CardInputCodeType.MagstripeRead);
			else
				terminal.setCardInputCode(CardInputCodeType.ManualKeyed);
			// Transaction values
			transaction.setTransactionID(requestTerminal.getSequenceNumber());
			transaction.setPaymentType(PaymentTypeEnum.fromValue(request
					.getPaymentType().value()));
			transaction.setReferenceNumber(request.getReferenceNumber());
			transaction.setDraftLocatorId(request.getDraftLocatorId());
			transaction.setClerkNumber(request.getMerchant().getClerkNumber()
					.toString());
			transaction.setMarketCode(MarketCodeType.fromValue(request
					.getTransactionType().value()));
			transaction.setTransactionTimestamp(request
					.getTransactionTimestamp().toString());
			transaction.setSystemTraceId("" + request.getSystemTraceId());
			transaction.setTokenRequested(request.isTokenRequested());

			if (request.isTokenRequested() != null)
				transaction.setTokenRequested(request.isTokenRequested());

			// *********************AUTHORIZE
			// REQUEST***************************//
			if (authRequest != null) {
				// Transaction values
				transaction.setTransactionAmount(authRequest
						.getTransactionAmount().getValue().toString());
				// Address
				addr = authRequest.getCredit().getCardholderAddress();
				address.setBillingAddress1(addr.getAddressLine());
				address.setCity(addr.getCity());
				address.setState(addr.getState().value());
				address.setBillingZipcode(addr.getPostalCode());
				address.setCountryCode(addr.getCountryCode());

				// card - credit
				CreditInstrumentType credit = authRequest.getCredit();
				card.setCardType(CreditCardNetworkType.valueOf(credit
						.getCardType().value()));
				if (credit.getCardKeyed() != null) {
					card.setCardNumber(credit.getCardKeyed()
							.getPrimaryAccountNumber());
					card.setExpirationMonth(Integer.toString(credit
							.getCardKeyed().getExpirationDate().getMonth()));
					card.setExpirationYear(Integer.toString(credit
							.getCardKeyed().getExpirationDate().getYear()));
					card.setCVV(credit.getCardKeyed().getCardSecurityCode());
					if (credit.getCardKeyed().getToken() != null) {
						System.out.println("HEREERE");
						card.setTokenId(credit.getCardKeyed().getToken()
								.getTokenId());
						card.setTokenValue(credit.getCardKeyed().getToken()
								.getTokenValue());
					}
				}

				else if (credit.getCardSwiped() != null) {

					if (credit.getCardSwiped().getTrack1() != null) {
						card.setTrack1Data(credit.getCardSwiped().getTrack1()
								.getTrackData());
						// card.setEncryptedTrack1Data(credit.getCardSwiped()
						// .getTrack1().getEncryptedTrackData().getValue());
						// card.setEncryptedFormat(credit.getCardSwiped().getTrack1()
						// .getEncryptedTrackData().getEncryptionType()
						// .value());
						// card.setCardDataKeySerialNumber(credit.getCardSwiped()
						// .getTrack1().getEncryptedTrackData().getKey());
					} else if (credit.getCardSwiped().getTrack2() != null) {
						card.setTrack2Data(credit.getCardSwiped().getTrack2()
								.getTrackData());
						// card.setEncryptedTrack2Data(credit.getCardSwiped()
						// .getTrack2().getEncryptedTrackData().getValue());
						// card.setEncryptedFormat(credit.getCardSwiped().getTrack2()
						// .getEncryptedTrackData().getEncryptionType()
						// .value());
						// card.setCardDataKeySerialNumber(credit.getCardSwiped()
						// .getTrack2().getEncryptedTrackData().getKey());
					}
				}
				// ******************CANCEL REQUEST*************************//
			} else if (cancelRequest != null) {
				// Transaction values
				transaction.setCancelType(CancelTypeEnum
						.fromValue(cancelRequest.getCancelType().value()));
				transaction.setAuthorizationCode(cancelRequest
						.getOriginalAuthCode());
				transaction.setOriginalAuthCode(cancelRequest
						.getOriginalAuthCode());
				transaction.setOriginalAuthorizedAmount(cancelRequest
						.getOriginalAmount().getValue().toString());
				transaction.setOriginalTransactionTimestamp(cancelRequest
						.getOriginalTransactionTimestamp().toString());
				transaction.setOriginalSystemTraceId(cancelRequest
						.getOriginalSystemTraceId().toString());
				transaction.setOriginalSequenceNumber(cancelRequest
						.getOriginalSequenceNumber());
				transaction.setNetworkResponseCode(cancelRequest
						.getNetworkResponseCode());
				transaction.setReversalReason(ReversalReasonType
						.fromValue(cancelRequest.getReversalReason().value()));
				transaction.setReplacementAmount(cancelRequest
						.getReplacementAmount().getValue().toString());
				transaction.setOriginalReferenceNumber(cancelRequest
						.getOriginalReferenceNumber());
				// Address
				addr = cancelRequest.getCredit().getCardholderAddress();
				address.setBillingAddress1(addr.getAddressLine());
				address.setCity(addr.getCity());
				address.setState(addr.getState().value());
				address.setBillingZipcode(addr.getPostalCode());
				address.setCountryCode(addr.getCountryCode());

				// card - credit
				CreditInstrumentType credit = cancelRequest.getCredit();
				card.setCardType(CreditCardNetworkType.valueOf(credit
						.getCardType().value()));

				if (credit.getCardKeyed() != null) {
					card.setCardNumber(credit.getCardKeyed()
							.getPrimaryAccountNumber());
					card.setExpirationMonth(Integer.toString(credit
							.getCardKeyed().getExpirationDate().getMonth()));
					card.setExpirationYear(Integer.toString(credit
							.getCardKeyed().getExpirationDate().getYear()));
					card.setCVV(credit.getCardKeyed().getCardSecurityCode());
					if (credit.getCardKeyed().getToken() != null) {
						System.out.println("HEREERE");
						card.setTokenId(credit.getCardKeyed().getToken()
								.getTokenId());
						card.setTokenValue(credit.getCardKeyed().getToken()
								.getTokenValue());
					}
				} else if (credit.getCardSwiped() != null) {
					if (credit.getCardSwiped().getTrack1() != null) {
						card.setTrack1Data(credit.getCardSwiped().getTrack1()
								.getTrackData());
						// card.setEncryptedTrack1Data(credit.getCardSwiped()
						// .getTrack1().getEncryptedTrackData().getValue());
						// card.setEncryptedFormat(credit.getCardSwiped().getTrack1()
						// .getEncryptedTrackData().getEncryptionType()
						// .value());
						// card.setCardDataKeySerialNumber(credit.getCardSwiped()
						// .getTrack1().getEncryptedTrackData().getKey());
					} else if (credit.getCardSwiped().getTrack2() != null) {
						card.setTrack2Data(credit.getCardSwiped().getTrack2()
								.getTrackData());
						// card.setEncryptedTrack2Data(credit.getCardSwiped()
						// .getTrack2().getEncryptedTrackData().getValue());
						// card.setEncryptedFormat(credit.getCardSwiped().getTrack2()
						// .getEncryptedTrackData().getEncryptionType()
						// .value());
						// card.setCardDataKeySerialNumber(credit.getCardSwiped()
						// .getTrack2().getEncryptedTrackData().getKey());
					}
				}
			}

			// *********************CAPTURE REQUEST***************************//
			else if (captRequest != null) {
				// Transaction values
				transaction.setAuthorizationCode(captRequest
						.getAuthorizationCode());
				transaction.setOriginalAuthorizedAmount(captRequest
						.getOriginalAmount().getValue().toString());
				transaction.setCaptureAmount(captRequest.getCaptureAmount()
						.getValue().toString());

				// address
				addr = captRequest.getCredit().getCardholderAddress();
				address.setBillingAddress1(addr.getAddressLine());
				address.setCity(addr.getCity());
				address.setState(addr.getState().value());
				address.setBillingZipcode(addr.getPostalCode());
				address.setCountryCode(addr.getCountryCode());

				// card - credit
				CreditInstrumentType credit = captRequest.getCredit();
				card.setCardType(CreditCardNetworkType.valueOf(credit
						.getCardType().value()));

				if (credit.getCardKeyed() != null) {
					card.setCardNumber(credit.getCardKeyed()
							.getPrimaryAccountNumber());
					card.setExpirationMonth(Integer.toString(credit
							.getCardKeyed().getExpirationDate().getMonth()));
					card.setExpirationYear(Integer.toString(credit
							.getCardKeyed().getExpirationDate().getYear()));
					card.setCVV(credit.getCardKeyed().getCardSecurityCode());
					if (credit.getCardKeyed().getToken() != null) {
						System.out.println("HEREERE");
						card.setTokenId(credit.getCardKeyed().getToken()
								.getTokenId());
						card.setTokenValue(credit.getCardKeyed().getToken()
								.getTokenValue());
					}
				} else if (credit.getCardSwiped() != null) {
					if (credit.getCardSwiped().getTrack1() != null) {
						card.setTrack1Data(credit.getCardSwiped().getTrack1()
								.getTrackData());
						// card.setEncryptedTrack1Data(credit.getCardSwiped()
						// .getTrack1().getEncryptedTrackData().getValue());
						// card.setEncryptedFormat(credit.getCardSwiped().getTrack1()
						// .getEncryptedTrackData().getEncryptionType()
						// .value());
						// card.setCardDataKeySerialNumber(credit.getCardSwiped()
						// .getTrack1().getEncryptedTrackData().getKey());
					} else if (credit.getCardSwiped().getTrack2() != null) {
						card.setTrack2Data(credit.getCardSwiped().getTrack2()
								.getTrackData());
						// card.setEncryptedTrack2Data(credit.getCardSwiped()
						// .getTrack2().getEncryptedTrackData().getValue());
						// card.setEncryptedFormat(credit.getCardSwiped().getTrack2()
						// .getEncryptedTrackData().getEncryptionType()
						// .value());
						// card.setCardDataKeySerialNumber(credit.getCardSwiped()
						// .getTrack2().getEncryptedTrackData().getKey());
					}
				}
				// ********************PURCHASE REQUEST*********************//
			} else if (purchRequest != null) {
				// Transaction values
				transaction.setTransactionAmount(purchRequest
						.getTransactionAmount().getValue().toString());
				if (purchRequest.getCashBackAmount() != null)
					transaction.setCashBackAmount(purchRequest
							.getCashBackAmount().getValue().toString());
				if (purchRequest.getTipAmount() != null)
					transaction.setTipAmount(purchRequest.getTipAmount()
							.getValue().toString());
				if (purchRequest.getConvenienceFee() != null)
					transaction.setConvenienceFee(purchRequest
							.getConvenienceFee().getValue().toString());
				// transaction.setTaxExempt(purchRequest.getTax().isTaxExempt()
				// .toString());
				// transaction
				// .setTaxable(purchRequest.getTax().isTaxable().toString());
				if (purchRequest.getTax() != null)
					transaction.setTaxAmount(purchRequest.getTax()
							.getTaxAmount().getValue().toString());
				transaction.setPurchaseOrder(purchRequest.getPurchaseOrder());
				// Address
				addr = purchRequest.getCredit().getCardholderAddress();
				address.setBillingAddress1(addr.getAddressLine());
				address.setCity(addr.getCity());
				address.setState(addr.getState().value());
				address.setBillingZipcode(addr.getPostalCode());
				address.setCountryCode(addr.getCountryCode());

				// card - credit
				CreditInstrumentType credit = purchRequest.getCredit();
				card.setCardType(CreditCardNetworkType.valueOf(credit
						.getCardType().value()));

				if (credit.getCardKeyed() != null) {
					card.setCardNumber(credit.getCardKeyed()
							.getPrimaryAccountNumber());
					card.setExpirationMonth(Integer.toString(credit
							.getCardKeyed().getExpirationDate().getMonth()));
					card.setExpirationYear(Integer.toString(credit
							.getCardKeyed().getExpirationDate().getYear()));
					card.setCVV(credit.getCardKeyed().getCardSecurityCode());
					if (credit.getCardKeyed().getToken() != null) {
						System.out.println("HEREERE");
						card.setTokenId(credit.getCardKeyed().getToken()
								.getTokenId());
						card.setTokenValue(credit.getCardKeyed().getToken()
								.getTokenValue());
					}
				} else if (credit.getCardSwiped() != null) {
					if (credit.getCardSwiped().getTrack1() != null) {
						card.setTrack1Data(credit.getCardSwiped().getTrack1()
								.getTrackData());
						// card.setEncryptedTrack1Data(credit.getCardSwiped()
						// .getTrack1().getEncryptedTrackData().getValue());
						// card.setEncryptedFormat(credit.getCardSwiped().getTrack1()
						// .getEncryptedTrackData().getEncryptionType()
						// .value());
						// card.setCardDataKeySerialNumber(credit.getCardSwiped()
						// .getTrack1().getEncryptedTrackData().getKey());
					} else if (credit.getCardSwiped().getTrack2() != null) {
						card.setTrack2Data(credit.getCardSwiped().getTrack2()
								.getTrackData());
						// card.setEncryptedTrack2Data(credit.getCardSwiped()
						// .getTrack2().getEncryptedTrackData().getValue());
						// card.setEncryptedFormat(credit.getCardSwiped().getTrack2()
						// .getEncryptedTrackData().getEncryptionType()
						// .value());
						// card.setCardDataKeySerialNumber(credit.getCardSwiped()
						// .getTrack2().getEncryptedTrackData().getKey());
					}
				}
				// *********************REFUND
				// REQUEST***************************//
			} else if (refundRequest != null) {
				// Transaction values
				transaction.setTransactionAmount(refundRequest
						.getRefundAmount().getValue().toString());
				// Address
				addr = refundRequest.getCredit().getCardholderAddress();
				address.setBillingAddress1(addr.getAddressLine());
				address.setCity(addr.getCity());
				address.setState(addr.getState().value());
				address.setBillingZipcode(addr.getPostalCode());
				address.setCountryCode(addr.getCountryCode());

				// card - credit
				CreditInstrumentType credit = refundRequest.getCredit();
				card.setCardType(CreditCardNetworkType.valueOf(credit
						.getCardType().value()));

				if (credit.getCardKeyed() != null) {
					card.setCardNumber(credit.getCardKeyed()
							.getPrimaryAccountNumber());
					card.setExpirationMonth(Integer.toString(credit
							.getCardKeyed().getExpirationDate().getMonth()));
					card.setExpirationYear(Integer.toString(credit
							.getCardKeyed().getExpirationDate().getYear()));
					card.setCVV(credit.getCardKeyed().getCardSecurityCode());
					if (credit.getCardKeyed().getToken() != null) {
						System.out.println("HEREERE");
						card.setTokenId(credit.getCardKeyed().getToken()
								.getTokenId());
						card.setTokenValue(credit.getCardKeyed().getToken()
								.getTokenValue());
					}
				} else if (credit.getCardSwiped() != null) {
					if (credit.getCardSwiped().getTrack1() != null) {
						card.setTrack1Data(credit.getCardSwiped().getTrack1()
								.getTrackData());
						// card.setEncryptedTrack1Data(credit.getCardSwiped()
						// .getTrack1().getEncryptedTrackData().getValue());
						// card.setEncryptedFormat(credit.getCardSwiped().getTrack1()
						// .getEncryptedTrackData().getEncryptionType()
						// .value());
						// card.setCardDataKeySerialNumber(credit.getCardSwiped()
						// .getTrack1().getEncryptedTrackData().getKey());
					} else if (credit.getCardSwiped().getTrack2() != null) {
						card.setTrack2Data(credit.getCardSwiped().getTrack2()
								.getTrackData());
						// card.setEncryptedTrack2Data(credit.getCardSwiped()
						// .getTrack2().getEncryptedTrackData().getValue());
						// card.setEncryptedFormat(credit.getCardSwiped().getTrack2()
						// .getEncryptedTrackData().getEncryptionType()
						// .value());
						// card.setCardDataKeySerialNumber(credit.getCardSwiped()
						// .getTrack2().getEncryptedTrackData().getKey());
					}
				}
				// ******************TOKENIZE REQUEST***********************//
			} else if (tokenRequest != null) {
				// Transaction values
				transaction.setTokenRequested(true);
				transaction.setTransactionAmount("0.00");
				// Address
				addr = tokenRequest.getCredit().getCardholderAddress();
				address.setBillingAddress1(addr.getAddressLine());
				address.setCity(addr.getCity());
				address.setState(addr.getState().value());
				address.setBillingZipcode(addr.getPostalCode());
				address.setCountryCode(addr.getCountryCode());

				// card - credit
				CreditInstrumentType credit = tokenRequest.getCredit();
				card.setCardType(CreditCardNetworkType.valueOf(credit
						.getCardType().value()));

				if (credit.getCardKeyed() != null) {
					card.setCardNumber(credit.getCardKeyed()
							.getPrimaryAccountNumber());
					card.setExpirationMonth(Integer.toString(credit
							.getCardKeyed().getExpirationDate().getMonth()));
					card.setExpirationYear(Integer.toString(credit
							.getCardKeyed().getExpirationDate().getYear()));
					card.setCVV(credit.getCardKeyed().getCardSecurityCode());
					if (credit.getCardKeyed().getToken() != null) {
						System.out.println("HEREERE");
						card.setTokenId(credit.getCardKeyed().getToken()
								.getTokenId());
						card.setTokenValue(credit.getCardKeyed().getToken()
								.getTokenValue());
					}
				} else if (credit.getCardSwiped() != null) {
					if (credit.getCardSwiped().getTrack1() != null) {
						card.setTrack1Data(credit.getCardSwiped().getTrack1()
								.getTrackData());
						// card.setEncryptedTrack1Data(credit.getCardSwiped()
						// .getTrack1().getEncryptedTrackData().getValue());
						// card.setEncryptedFormat(credit.getCardSwiped().getTrack1()
						// .getEncryptedTrackData().getEncryptionType()
						// .value());
						// card.setCardDataKeySerialNumber(credit.getCardSwiped()
						// .getTrack1().getEncryptedTrackData().getKey());
					} else if (credit.getCardSwiped().getTrack2() != null) {
						card.setTrack2Data(credit.getCardSwiped().getTrack2()
								.getTrackData());
						// card.setEncryptedTrack2Data(credit.getCardSwiped()
						// .getTrack2().getEncryptedTrackData().getValue());
						// card.setEncryptedFormat(credit.getCardSwiped().getTrack2()
						// .getEncryptedTrackData().getEncryptionType()
						// .value());
						// card.setCardDataKeySerialNumber(credit.getCardSwiped()
						// .getTrack2().getEncryptedTrackData().getKey());
					}
				}
			}
		} else {
			// Set values for BatchRequests
			if (batchRequest.getMerchant().getSoftware() != null)
				requestTerminal = batchRequest.getMerchant().getSoftware();
			else if (batchRequest.getMerchant().getTerminal() != null)
				requestTerminal = batchRequest.getMerchant().getTerminal();
			else
				requestTerminal = batchRequest.getMerchant().getMobile();
			transaction.setDraftLocatorId(batchRequest.getDraftLocatorId());
			transaction.setSystemTraceId("" + batchRequest.getSystemTraceId());
			transaction.setTransactionTimestamp(batchRequest
					.getTransactionTimestamp().toString());
			transaction.setTransactionID(requestTerminal.getSequenceNumber());
			terminal.setDeviceType(DeviceTypeCode.Software);
			terminal.setTerminalID("" + requestTerminal.getTerminalID());
			transaction.setClerkNumber(batchRequest.getMerchant()
					.getClerkNumber().toString());
		}

		return new ApigeeObject(credentials, merchant, terminal, transaction,
				address, card);

	}

}
