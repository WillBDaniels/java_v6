/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.apigee.objects;

import com.vantiv.pws.apigee.objects.Enums.CardInputCodeType;
import com.vantiv.pws.apigee.objects.Enums.DeviceTypeCode;
import com.vantiv.pws.apigee.objects.Enums.PinEntryType;
import com.vantiv.pws.apigee.objects.Enums.TerminalEnvironmentType;

public class Terminal {
	/*
	 * Documentation for Terminal:
	 * http://dev-vantiv.devportal.apigee.com/docs/payment
	 * -web-services/api-element-dictionary/rest-terminal-definition
	 */

	// Required
	private String TerminalID;

	private TerminalEnvironmentType TerminalEnvironmentCode;
	private CardInputCodeType CardInputCode;
	private PinEntryType PinEntry;


	// Optional
	private String IPv4Address;
	private String IPv6Address;
	private boolean BalanceInquiry;
	// ENUM for DeviceType: 'Terminal' 'Software' 'Mobile'
	private DeviceTypeCode DeviceType;
	private boolean HostAdjustment;
	private String Latitude;
	private String Longitude;

	// Getters and setters
	public String getTerminalID() {
		return TerminalID;
	}

	public void setTerminalID(String terminalID) {
		TerminalID = terminalID;
	}


	public TerminalEnvironmentType getTerminalEnvironmentalCode() {
		return TerminalEnvironmentCode;

	}


	public void setTerminalEnvironmentalCode(
			TerminalEnvironmentType terminalEnvironmentalCode) {
		TerminalEnvironmentCode = terminalEnvironmentalCode;

	}

	public CardInputCodeType getCardInputCode() {
		return CardInputCode;
	}

	public void setCardInputCode(CardInputCodeType cardInputCode) {
		CardInputCode = cardInputCode;
	}

	public PinEntryType getPinEntry() {
		return PinEntry;
	}

	public void setPinEntry(PinEntryType pinEntry) {
		PinEntry = pinEntry;
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

	public boolean isBalanceInquiry() {
		return BalanceInquiry;
	}

	public void setBalanceInquiry(boolean balanceInquiry) {
		BalanceInquiry = balanceInquiry;
	}

	public DeviceTypeCode getDeviceType() {
		return DeviceType;
	}

	public void setDeviceType(DeviceTypeCode deviceType) {
		DeviceType = deviceType;
	}

	public boolean isHostAdjustment() {
		return HostAdjustment;
	}

	public void setHostAdjustment(boolean hostAdjustment) {
		HostAdjustment = hostAdjustment;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}




}
