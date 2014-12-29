/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/
package com.vantiv.pws.resources;

import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.vantiv.types.common.v6.AmountType;
import com.vantiv.types.common.v6.ISO4217CurrencyCodeType;

public class Utils {

	private static ISO4217CurrencyCodeType curType;

	public XMLGregorianCalendar stringToXMLGregorian(String s) {
		XMLGregorianCalendar xmlGreg = null;
		if (s == null || s.isEmpty()) {
			Date d = new Date();
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(d);
			try {
				xmlGreg = DatatypeFactory.newInstance()
						.newXMLGregorianCalendar(c);
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
		} else {

			DatatypeFactory f = null;

			try {
				f = DatatypeFactory.newInstance();
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
			String year = s.split("-")[0];
			String month = s.split("-")[1];
			xmlGreg = f.newXMLGregorianCalendar();
			xmlGreg.setYear(Integer.parseInt(year));
			xmlGreg.setMonth(Integer.parseInt(month));

		}
		return xmlGreg;
	}

	public AmountType getTransactionAmount(String bigDecimal, String currency) {
		AmountType at = new AmountType();
		BigDecimal bd = new BigDecimal(bigDecimal);

		curType = ISO4217CurrencyCodeType.fromValue(currency);

		at.setValue(bd);
		at.setCurrency(curType);

		return at;
	}

	public String prettyFormat(String input, int indent) {
		String out = "XML: ";
		try {
			Source xmlInput = new StreamSource(new StringReader(input));
			StringWriter stringWriter = new StringWriter();
			StreamResult xmlOutput = new StreamResult(stringWriter);
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			transformerFactory.setAttribute("indent-number", indent);
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(xmlInput, xmlOutput);
			out += xmlOutput.getWriter().toString();
		} catch (Exception e) {
			// throw new RuntimeException(e); // simple exception handling,
			// please
											// review it
		}
		return out;
	}

	/**
	 * Verify the primary account number is in the correct format, if it is,
	 * determine which card network it belongs to and return it. (Visa,
	 * mastercard, etc...)
	 */
	public String verifyCardNumberFormat(String pan) {
		String visaPat = "^4[0-9]{12}(?:[0-9]{3})?$";
		String mcPat = "^5[1-5][0-9]{14}$";
		String amexPat = "^3[47][0-9]{13}$";
		String discPat = "^6(?:011|5[0-9]{2})[0-9]{12}$";
		String dinersClubPat = "^3(?:0[0-5]|[68][0-9])[0-9]{11}$";

		if (pan.matches(visaPat))
			return "visa";
		else if (pan.matches(mcPat))
			return "masterCard";
		else if (pan.matches(amexPat))
			return "amex";
		else if (pan.matches(discPat))
			return "discover";
		else if (pan.matches(dinersClubPat))
			return "discover";
		else
			return "visa";

	}

	public String getMaskedPan(String panData) {
		String masked = "XX";
		if (panData.contains("=")) {
			masked += panData.substring(panData.indexOf('=') - 4);
		} else {
			masked += panData.substring(panData.length() - 4);
		}
		// System.out.println(masked);
		return masked;
	}

	public boolean verifyCurrencyFormat(String amount) {
		Number transactionAmount = null;
		try {
			transactionAmount = NumberFormat.getCurrencyInstance(Locale.US)
					.parse(amount);
		} catch (ParseException e1) {
		}
		if (transactionAmount != null) {
			return true;
		} else {
			return false;
		}
	}

	public String prettyFormat(String input) {
		return prettyFormat(input, 2);
	}
}
