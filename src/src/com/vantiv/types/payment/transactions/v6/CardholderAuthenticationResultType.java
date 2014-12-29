
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardholderAuthenticationResultType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CardholderAuthenticationResultType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="match"/>
 *     &lt;enumeration value="mismatch"/>
 *     &lt;enumeration value="not_processed"/>
 *     &lt;enumeration value="missing"/>
 *     &lt;enumeration value="unavailable"/>
 *     &lt;enumeration value="error"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CardholderAuthenticationResultType")
@XmlEnum
public enum CardholderAuthenticationResultType {


    /**
     * Validation success
     * 
     */
    @XmlEnumValue("match")
    MATCH("match"),

    /**
     * Validation failure
     * 
     */
    @XmlEnumValue("mismatch")
    MISMATCH("mismatch"),

    /**
     * Validation could not be performed: Issuer system error
     *                     
     * 
     */
    @XmlEnumValue("not_processed")
    NOT_PROCESSED("not_processed"),

    /**
     * Validation failure: Invalid data
     * 
     */
    @XmlEnumValue("missing")
    MISSING("missing"),

    /**
     * Validation could not be performed: Issuer attempt incomplete
     *                     
     * 
     */
    @XmlEnumValue("unavailable")
    UNAVAILABLE("unavailable"),

    /**
     * Validation could not be performed: length error
     *                     
     * 
     */
    @XmlEnumValue("error")
    ERROR("error");
    private final String value;

    CardholderAuthenticationResultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CardholderAuthenticationResultType fromValue(String v) {
        for (CardholderAuthenticationResultType c: CardholderAuthenticationResultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
