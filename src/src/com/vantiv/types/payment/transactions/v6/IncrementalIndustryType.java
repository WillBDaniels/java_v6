
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IncrementalIndustryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IncrementalIndustryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Hotel"/>
 *     &lt;enumeration value="Auto"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IncrementalIndustryType")
@XmlEnum
public enum IncrementalIndustryType {

    @XmlEnumValue("Hotel")
    HOTEL("Hotel"),
    @XmlEnumValue("Auto")
    AUTO("Auto");
    private final String value;

    IncrementalIndustryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IncrementalIndustryType fromValue(String v) {
        for (IncrementalIndustryType c: IncrementalIndustryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
