
package com.vantiv.types.common.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ISO4217CurrencyCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ISO4217CurrencyCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="USD"/>
 *     &lt;enumeration value="CAD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ISO4217CurrencyCodeType")
@XmlEnum
public enum ISO4217CurrencyCodeType {

    USD,
    CAD;

    public String value() {
        return name();
    }

    public static ISO4217CurrencyCodeType fromValue(String v) {
        return valueOf(v);
    }

}
