
package com.vantiv.types.payment.systems.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TerminalClassificationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TerminalClassificationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="unspecified"/>
 *     &lt;enumeration value="limited_amount_terminal"/>
 *     &lt;enumeration value="telephone_device"/>
 *     &lt;enumeration value="unattended_atm"/>
 *     &lt;enumeration value="unattended_self_service"/>
 *     &lt;enumeration value="electronic_cash_register"/>
 *     &lt;enumeration value="mobile_contactless_transaction"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TerminalClassificationType")
@XmlEnum
public enum TerminalClassificationType {


    /**
     * Unspecified
     * 
     */
    @XmlEnumValue("unspecified")
    UNSPECIFIED("unspecified"),

    /**
     * Limited amount terminal
     * 
     */
    @XmlEnumValue("limited_amount_terminal")
    LIMITED_AMOUNT_TERMINAL("limited_amount_terminal"),

    /**
     * Telephone Device
     * 
     */
    @XmlEnumValue("telephone_device")
    TELEPHONE_DEVICE("telephone_device"),

    /**
     * Unattended Payment Terminal
     * 
     */
    @XmlEnumValue("unattended_atm")
    UNATTENDED_ATM("unattended_atm"),

    /**
     * Unattended PaymentSelf Service Terminal
     * 
     */
    @XmlEnumValue("unattended_self_service")
    UNATTENDED_SELF_SERVICE("unattended_self_service"),

    /**
     * Electronic cash register
     * 
     */
    @XmlEnumValue("electronic_cash_register")
    ELECTRONIC_CASH_REGISTER("electronic_cash_register"),

    /**
     * Mobile contactless transaction
     * 
     */
    @XmlEnumValue("mobile_contactless_transaction")
    MOBILE_CONTACTLESS_TRANSACTION("mobile_contactless_transaction");
    private final String value;

    TerminalClassificationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TerminalClassificationType fromValue(String v) {
        for (TerminalClassificationType c: TerminalClassificationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
