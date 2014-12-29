
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardCategoryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CardCategoryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="unknown"/>
 *     &lt;enumeration value="business"/>
 *     &lt;enumeration value="corporate"/>
 *     &lt;enumeration value="purchase"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CardCategoryType")
@XmlEnum
public enum CardCategoryType {


    /**
     * Card Unknown
     * 
     */
    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),

    /**
     * Business Card
     * 
     */
    @XmlEnumValue("business")
    BUSINESS("business"),

    /**
     * Corporate Card
     * 
     */
    @XmlEnumValue("corporate")
    CORPORATE("corporate"),

    /**
     * Purchase Card
     * 
     */
    @XmlEnumValue("purchase")
    PURCHASE("purchase");
    private final String value;

    CardCategoryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CardCategoryType fromValue(String v) {
        for (CardCategoryType c: CardCategoryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
