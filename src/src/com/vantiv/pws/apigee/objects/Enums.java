/* Copyright (C) 2014 Vantiv. All Rights Reserved.*/
package com.vantiv.pws.apigee.objects;




public class Enums {
	public enum CreditCardNetworkType {
		visa, masterCard, discover, amex, dinersclub;

		public String value() {
			return name();
		}

		public static CreditCardNetworkType fromValue(String v) {
			return valueOf(v);
		}

	}

	public enum EncryptionType {

		DUKPT, VOLTAGE;

		public String value() {
			return name();
		}

		public static EncryptionType fromValue(String v) {
			return valueOf(v);
		}

	}

	public enum AccountTypeEnum {

		CHECKING, SAVINGS;

		public String value() {
			return name();
		}

		public static AccountTypeEnum fromValue(String v) {
			return valueOf(v);
		}

	}
	
	public enum TerminalEnvironmentType{
		// (default)
		unspecified,
		limited_amount_terminal,
		telephone_device,
		unattended_atm,
		unattended_self_service,
		// For all ecommerce trans:
		electronic_cash_register,

		// For all mobile trans:
		mobile_contactless_transaction;

		public String value() {
			return name();
		}

		public static TerminalEnvironmentType fromValue(String v) {
			return valueOf(v);
		}
	}

	public enum CardInputCodeType {
		ManualKeyed, MagstripeRead, ManualKeyedMagstripeFailure, ContactlessMagstripeRead, Barcode, OCR, Chip;

		public String value() {
			return name();
		}

		public static CardInputCodeType fromValue(String v) {
			return valueOf(v);
		}
	}

	public enum DeviceTypeCode {
		Terminal, Software, Mobile;

		public String value() {
			return name();
		}

		public static DeviceTypeCode fromValue(String v) {
			return valueOf(v);
		}
	}

	public enum PinEntryType {
		supported, none, inoperative, terminal_verified, unknown;

		public String value() {
			return name();
		}

		public static PinEntryType fromValue(String v) {
			return valueOf(v);
		}
	}

	public enum MarketCodeType {
		present, moto, ecommerce;

		public String value() {
			return name();
		}

		public static MarketCodeType fromValue(String v) {
			return valueOf(v);
		}
	}

	public enum CancelTypeEnum {
		authorize, purchase, purchase_cashback, refund, adjust, capture, activate, reload, unload, close;
		public String value() {
			return name();
		}

		public static CancelTypeEnum fromValue(String v) {
			return valueOf(v);
		}

	}

	public enum PaymentTypeEnum {
		single, recurring, installment, billpay, resubmission;
		public String value() {
			return name();
		}

		public static PaymentTypeEnum fromValue(String v) {
			return valueOf(v);
		}
	}

	public enum ReversalReasonType {
		INCOMPLETE_TRANSACTION, TIME_OUT, INVALID_RESPONSE, DESTINATION_NOT_AVAILABLE, CLERK_CANCELED_TRANSACTION, CUSTOMER_CANCELED_TRANSACTION, MISDISPENSE, HARDWARE_FAILURE, SUSPECTED_FRAUDE;

		public String value() {
			return name();
		}

		public static ReversalReasonType fromValue(String v) {
			return valueOf(v);
		}
	}
	
	public enum PartialApprovalType{
		
		not_supported, supported, return_balance, partial_cash, full_cash, partial_merch;

		public String value() {
			return name();
		}

		public static PartialApprovalType fromValue(String v) {
			return valueOf(v);
		}
	}
}
