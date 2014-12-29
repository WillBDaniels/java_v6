
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentInstrumentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentInstrumentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREDIT"/>
 *     &lt;enumeration value="GIFT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentInstrumentType")
@XmlEnum
public enum PaymentInstrumentType {


    /**
     * Credit Card
     * 
     */
    CREDIT,

    /**
     * Gift Card
     * 
     */
    GIFT;

    public String value() {
        return name();
    }

    public static PaymentInstrumentType fromValue(String v) {
        return valueOf(v);
    }

}
