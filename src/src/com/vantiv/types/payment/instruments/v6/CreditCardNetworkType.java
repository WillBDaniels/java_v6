
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreditCardNetworkType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CreditCardNetworkType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="visa"/>
 *     &lt;enumeration value="masterCard"/>
 *     &lt;enumeration value="discover"/>
 *     &lt;enumeration value="amex"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CreditCardNetworkType")
@XmlEnum
public enum CreditCardNetworkType {


    /**
     * Visa Card Network
     * 
     */
    @XmlEnumValue("visa")
    VISA("visa"),

    /**
     * Master Card Network
     * 
     */
    @XmlEnumValue("masterCard")
    MASTER_CARD("masterCard"),

    /**
     * Discover Card Network
     * 
     */
    @XmlEnumValue("discover")
    DISCOVER("discover"),

    /**
     * American Express Card Network
     * 
     */
    @XmlEnumValue("amex")
    AMEX("amex");
    private final String value;

    CreditCardNetworkType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CreditCardNetworkType fromValue(String v) {
        for (CreditCardNetworkType c: CreditCardNetworkType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
