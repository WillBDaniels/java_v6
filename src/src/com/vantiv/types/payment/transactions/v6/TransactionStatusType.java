
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="authorized"/>
 *     &lt;enumeration value="not_approved"/>
 *     &lt;enumeration value="settled"/>
 *     &lt;enumeration value="refunded"/>
 *     &lt;enumeration value="canceled"/>
 *     &lt;enumeration value="partially_canceled"/>
 *     &lt;enumeration value="batch_closed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionStatusType")
@XmlEnum
public enum TransactionStatusType {


    /**
     * The Transaction has been Authorized for payment, pending
     *                         Settlement
     *                     
     * 
     */
    @XmlEnumValue("authorized")
    AUTHORIZED("authorized"),

    /**
     * The Transaction has been Declined for payment
     *                     
     * 
     */
    @XmlEnumValue("not_approved")
    NOT_APPROVED("not_approved"),

    /**
     * The Transaction has been completed and the funds have Settled
     *                     
     * 
     */
    @XmlEnumValue("settled")
    SETTLED("settled"),

    /**
     * The entire Transaction amount has been refunded
     *                     
     * 
     */
    @XmlEnumValue("refunded")
    REFUNDED("refunded"),

    /**
     * The previous Authorization for this Transaction has been
     *                         Canceled
     *                     
     * 
     */
    @XmlEnumValue("canceled")
    CANCELED("canceled"),

    /**
     * The Transaction has been Partially canceled
     * 
     */
    @XmlEnumValue("partially_canceled")
    PARTIALLY_CANCELED("partially_canceled"),

    /**
     * The batch has been closed
     * 
     */
    @XmlEnumValue("batch_closed")
    BATCH_CLOSED("batch_closed");
    private final String value;

    TransactionStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransactionStatusType fromValue(String v) {
        for (TransactionStatusType c: TransactionStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
