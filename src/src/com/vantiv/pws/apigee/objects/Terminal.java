/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.apigee.objects;

public class Terminal {

	// Required
	private String TerminalID;
	private String EntryMode;
	// Optional
	private String IPv4Address;
	private String IPv6Address;
	private String TerminalEnvironmentalCode;
	private String CardInputCode;
	private String CardReader;
	private String PinEntry;
	private String BalanceInquiry;
	private String HostAdjustment;
	// ENUM for DeviceType: 'Terminal' 'Software' 'Mobile'
	private String DeviceType;


	public String getCardInputCode() {
		return CardInputCode;
	}

	public void setCardInputCode(String cardInputCode) {
		CardInputCode = cardInputCode;
	}

	public String getTerminalEnvironmentalCode() {
		return TerminalEnvironmentalCode;
	}

	public void setTerminalEnvironmentalCode(String terminalEnvironmentalCode) {
		TerminalEnvironmentalCode = terminalEnvironmentalCode;
	}

	public String getDeviceType() {
		return DeviceType;
	}

	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}

	public String getTerminalID() {
		return TerminalID;
	}

	public void setTerminalID(String terminalID) {
		TerminalID = terminalID;
	}

	public String getEntryMode() {
		return EntryMode;
	}

	public void setEntryMode(String entryMode) {
		EntryMode = entryMode;
	}

	public String getIPv4Address() {
		return IPv4Address;
	}

	public void setIPv4Address(String iPv4Address) {
		IPv4Address = iPv4Address;
	}

	public String getIPv6Address() {
		return IPv6Address;
	}

	public void setIPv6Address(String iPv6Address) {
		IPv6Address = iPv6Address;
	}

	public String getTerminalCapabilityCode() {
		return TerminalEnvironmentalCode;
	}

	public void setTerminalCapabilityCode(String terminalCapabilityCode) {
		TerminalEnvironmentalCode = terminalCapabilityCode;
	}

	public String getCardInput() {
		return CardInputCode;
	}

	public void setCardInput(String cardInputCode) {
		CardInputCode = cardInputCode;
	}

	public String getCardReader() {
		return CardReader;
	}

	public void setCardReader(String cardReader) {
		CardReader = cardReader;
	}

	public String getPinEntry() {
		return PinEntry;
	}

	public void setPinEntry(String pinEntry) {
		PinEntry = pinEntry;
	}

	public String getBalanceInquiry() {
		return BalanceInquiry;
	}

	public void setBalanceInquiry(String balanceInquiry) {
		BalanceInquiry = balanceInquiry;
	}

	public String getHostAdjustment() {
		return HostAdjustment;
	}

	public void setHostAdjustment(String hostAdjustment) {
		HostAdjustment = hostAdjustment;
	}

}
