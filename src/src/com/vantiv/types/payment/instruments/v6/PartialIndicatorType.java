
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PartialIndicatorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PartialIndicatorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="not_supported"/>
 *     &lt;enumeration value="supported"/>
 *     &lt;enumeration value="return_balance"/>
 *     &lt;enumeration value="partial_cash"/>
 *     &lt;enumeration value="full_cash"/>
 *     &lt;enumeration value="partial_merch"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PartialIndicatorType")
@XmlEnum
public enum PartialIndicatorType {


    /**
     * (Visa/MC, Dicover, AMEX) Partial approval is not supported
     * 
     */
    @XmlEnumValue("not_supported")
    NOT_SUPPORTED("not_supported"),

    /**
     * (Discover) Partial approval supported for partial Merchandise and partial Cash over
     * 
     */
    @XmlEnumValue("supported")
    SUPPORTED("supported"),

    /**
     * (AMEX) No partial approval, but return available balance in response
     * 
     */
    @XmlEnumValue("return_balance")
    RETURN_BALANCE("return_balance"),

    /**
     * (Discover) Partial approval supported for full Merchandise and partial Cash over
     * 
     */
    @XmlEnumValue("partial_cash")
    PARTIAL_CASH("partial_cash"),

    /**
     * (Discover) Partial approval supported for full Merchandise and full Cash over
     * 
     */
    @XmlEnumValue("full_cash")
    FULL_CASH("full_cash"),

    /**
     * Partial approval supported for partial Merchandise
     * 
     */
    @XmlEnumValue("partial_merch")
    PARTIAL_MERCH("partial_merch");
    private final String value;

    PartialIndicatorType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PartialIndicatorType fromValue(String v) {
        for (PartialIndicatorType c: PartialIndicatorType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
