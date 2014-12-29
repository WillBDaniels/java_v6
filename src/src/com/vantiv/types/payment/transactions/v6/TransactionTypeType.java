
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionTypeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="present"/>
 *     &lt;enumeration value="ecommerce"/>
 *     &lt;enumeration value="moto"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionTypeType")
@XmlEnum
public enum TransactionTypeType {


    /**
     * Customer Present Transaction
     * 
     */
    @XmlEnumValue("present")
    PRESENT("present"),

    /**
     * eCommerce Transaction
     * 
     */
    @XmlEnumValue("ecommerce")
    ECOMMERCE("ecommerce"),

    /**
     * Mail Order / Telephone Order Transaction
     * 
     */
    @XmlEnumValue("moto")
    MOTO("moto");
    private final String value;

    TransactionTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransactionTypeType fromValue(String v) {
        for (TransactionTypeType c: TransactionTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
