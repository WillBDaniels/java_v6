
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MasterCardCvcValidityType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MasterCardCvcValidityType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="valid"/>
 *     &lt;enumeration value="error"/>
 *     &lt;enumeration value="not_processed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MasterCardCvcValidityType")
@XmlEnum
public enum MasterCardCvcValidityType {


    /**
     * There was no error validating CVC
     * 
     */
    @XmlEnumValue("valid")
    VALID("valid"),

    /**
     * There was an error validating CVC
     * 
     */
    @XmlEnumValue("error")
    ERROR("error"),

    /**
     * The CVC value could not be validated
     * 
     */
    @XmlEnumValue("not_processed")
    NOT_PROCESSED("not_processed");
    private final String value;

    MasterCardCvcValidityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MasterCardCvcValidityType fromValue(String v) {
        for (MasterCardCvcValidityType c: MasterCardCvcValidityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
