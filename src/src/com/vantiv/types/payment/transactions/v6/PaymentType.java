
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="single"/>
 *     &lt;enumeration value="recurring"/>
 *     &lt;enumeration value="installment"/>
 *     &lt;enumeration value="billpay"/>
 *     &lt;enumeration value="resubmission"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentType")
@XmlEnum
public enum PaymentType {


    /**
     * Single payment
     * 
     */
    @XmlEnumValue("single")
    SINGLE("single"),

    /**
     * Recurring payment
     * 
     */
    @XmlEnumValue("recurring")
    RECURRING("recurring"),

    /**
     * Installment payment
     * 
     */
    @XmlEnumValue("installment")
    INSTALLMENT("installment"),

    /**
     * One-time bill payment
     * 
     */
    @XmlEnumValue("billpay")
    BILLPAY("billpay"),

    /**
     * Resubmission
     * 
     */
    @XmlEnumValue("resubmission")
    RESUBMISSION("resubmission");
    private final String value;

    PaymentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentType fromValue(String v) {
        for (PaymentType c: PaymentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
