
package com.vantiv.types.payment.systems.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PinEntryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PinEntryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="supported"/>
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="inoperative"/>
 *     &lt;enumeration value="terminal_verified"/>
 *     &lt;enumeration value="unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PinEntryType")
@XmlEnum
public enum PinEntryType {


    /**
     * Device accepts PIN entry
     * 
     */
    @XmlEnumValue("supported")
    SUPPORTED("supported"),

    /**
     * Device does not accept PIN entry
     * 
     */
    @XmlEnumValue("none")
    NONE("none"),

    /**
     * PIN entry device is inoperative
     * 
     */
    @XmlEnumValue("inoperative")
    INOPERATIVE("inoperative"),

    /**
     * PIN entry verified by terminal
     * 
     */
    @XmlEnumValue("terminal_verified")
    TERMINAL_VERIFIED("terminal_verified"),

    /**
     * Unknown
     * 
     */
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    PinEntryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PinEntryType fromValue(String v) {
        for (PinEntryType c: PinEntryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
