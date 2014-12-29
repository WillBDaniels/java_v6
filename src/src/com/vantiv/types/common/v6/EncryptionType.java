
package com.vantiv.types.common.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EncryptionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EncryptionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DUKPT"/>
 *     &lt;enumeration value="VOLTAGE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EncryptionType")
@XmlEnum
public enum EncryptionType {

    DUKPT,
    VOLTAGE;

    public String value() {
        return name();
    }

    public static EncryptionType fromValue(String v) {
        return valueOf(v);
    }

}
