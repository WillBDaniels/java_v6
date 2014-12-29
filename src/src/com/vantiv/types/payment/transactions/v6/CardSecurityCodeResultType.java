
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardSecurityCodeResultType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CardSecurityCodeResultType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="error"/>
 *     &lt;enumeration value="match"/>
 *     &lt;enumeration value="no_match"/>
 *     &lt;enumeration value="not_processed"/>
 *     &lt;enumeration value="not_processed_blank"/>
 *     &lt;enumeration value="missing"/>
 *     &lt;enumeration value="unavailable"/>
 *     &lt;enumeration value="unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CardSecurityCodeResultType")
@XmlEnum
public enum CardSecurityCodeResultType {


    /**
     * There was an error either in the length or calculated value
     *                     
     * 
     */
    @XmlEnumValue("error")
    ERROR("error"),

    /**
     * Match
     * 
     */
    @XmlEnumValue("match")
    MATCH("match"),

    /**
     * No Match
     * 
     */
    @XmlEnumValue("no_match")
    NO_MATCH("no_match"),

    /**
     * Not Processed
     * 
     */
    @XmlEnumValue("not_processed")
    NOT_PROCESSED("not_processed"),

    /**
     * Not Processed Blank
     * 
     */
    @XmlEnumValue("not_processed_blank")
    NOT_PROCESSED_BLANK("not_processed_blank"),

    /**
     * Issuer indicates that CVV2 data should be present on the card,
     *                         but the
     *                         Merchant has indicated data is not present on the card
     *                     
     * 
     */
    @XmlEnumValue("missing")
    MISSING("missing"),

    /**
     * Issuer has not certified for CVV2 or Issuer has not provided
     *                         Visa with
     *                         the CVV2 encryption keys
     *                     
     * 
     */
    @XmlEnumValue("unavailable")
    UNAVAILABLE("unavailable"),

    /**
     * Unknown
     * 
     */
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    CardSecurityCodeResultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CardSecurityCodeResultType fromValue(String v) {
        for (CardSecurityCodeResultType c: CardSecurityCodeResultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
