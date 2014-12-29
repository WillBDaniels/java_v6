
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelTransactionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CancelTransactionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="authorize"/>
 *     &lt;enumeration value="purchase"/>
 *     &lt;enumeration value="purchase_cashback"/>
 *     &lt;enumeration value="refund"/>
 *     &lt;enumeration value="adjust"/>
 *     &lt;enumeration value="capture"/>
 *     &lt;enumeration value="activate"/>
 *     &lt;enumeration value="reload"/>
 *     &lt;enumeration value="unload"/>
 *     &lt;enumeration value="close"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CancelTransactionType")
@XmlEnum
public enum CancelTransactionType {


    /**
     * Cancel Authorize Transaction
     * 
     */
    @XmlEnumValue("authorize")
    AUTHORIZE("authorize"),

    /**
     * Cancel Purchase Transaction
     * 
     */
    @XmlEnumValue("purchase")
    PURCHASE("purchase"),

    /**
     * Cancel Purchase with Cash Back Transaction
     * 
     */
    @XmlEnumValue("purchase_cashback")
    PURCHASE_CASHBACK("purchase_cashback"),

    /**
     * Cancel Refund Transaction
     * 
     */
    @XmlEnumValue("refund")
    REFUND("refund"),

    /**
     * Cancel Adjust Transaction
     * 
     */
    @XmlEnumValue("adjust")
    ADJUST("adjust"),

    /**
     * Cancel Capture Transaction
     * 
     */
    @XmlEnumValue("capture")
    CAPTURE("capture"),

    /**
     * Cancel Activate Transaction
     * 
     */
    @XmlEnumValue("activate")
    ACTIVATE("activate"),

    /**
     * Cancel Reload Transaction
     * 
     */
    @XmlEnumValue("reload")
    RELOAD("reload"),

    /**
     * Cancel Unload Transaction
     * 
     */
    @XmlEnumValue("unload")
    UNLOAD("unload"),

    /**
     * Cancel Close Transaction
     * 
     */
    @XmlEnumValue("close")
    CLOSE("close");
    private final String value;

    CancelTransactionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CancelTransactionType fromValue(String v) {
        for (CancelTransactionType c: CancelTransactionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
