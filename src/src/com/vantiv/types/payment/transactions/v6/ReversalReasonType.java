
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReversalReasonType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReversalReasonType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INCOMPLETE_TRANSACTION"/>
 *     &lt;enumeration value="TIME_OUT"/>
 *     &lt;enumeration value="INVALID_RESPONSE"/>
 *     &lt;enumeration value="DESTINATION_NOT_AVAILABLE"/>
 *     &lt;enumeration value="CLERK_CANCELED_TRANSACTION"/>
 *     &lt;enumeration value="CUSTOMER_CANCELED_TRANSACTION"/>
 *     &lt;enumeration value="MISDISPENSE"/>
 *     &lt;enumeration value="HARDWARE_FAILURE"/>
 *     &lt;enumeration value="SUSPECTED_FRAUDE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReversalReasonType")
@XmlEnum
public enum ReversalReasonType {


    /**
     * Incomplete Transaction
     * 
     */
    INCOMPLETE_TRANSACTION,

    /**
     * Time Out
     * 
     */
    TIME_OUT,

    /**
     * Invalid Response
     * 
     */
    INVALID_RESPONSE,

    /**
     * Destination Not Available
     * 
     */
    DESTINATION_NOT_AVAILABLE,

    /**
     * Clerk Canceled Transaction
     * 
     */
    CLERK_CANCELED_TRANSACTION,

    /**
     * Customer Canceled Transaction
     * 
     */
    CUSTOMER_CANCELED_TRANSACTION,

    /**
     * Misdispense
     * 
     */
    MISDISPENSE,

    /**
     * Hardware Failure
     * 
     */
    HARDWARE_FAILURE,

    /**
     * Suspected Fraude
     * 
     */
    SUSPECTED_FRAUDE;

    public String value() {
        return name();
    }

    public static ReversalReasonType fromValue(String v) {
        return valueOf(v);
    }

}
