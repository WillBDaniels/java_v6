
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MasterCardCategoryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MasterCardCategoryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="hotel"/>
 *     &lt;enumeration value="restaurant"/>
 *     &lt;enumeration value="retail"/>
 *     &lt;enumeration value="auto"/>
 *     &lt;enumeration value="direct"/>
 *     &lt;enumeration value="travel"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MasterCardCategoryType")
@XmlEnum
public enum MasterCardCategoryType {


    /**
     * hotel
     * 
     */
    @XmlEnumValue("hotel")
    HOTEL("hotel"),

    /**
     * restaurant
     * 
     */
    @XmlEnumValue("restaurant")
    RESTAURANT("restaurant"),

    /**
     * retail
     * 
     */
    @XmlEnumValue("retail")
    RETAIL("retail"),

    /**
     * auto
     * 
     */
    @XmlEnumValue("auto")
    AUTO("auto"),

    /**
     * Direct Market
     * 
     */
    @XmlEnumValue("direct")
    DIRECT("direct"),

    /**
     * travel
     * 
     */
    @XmlEnumValue("travel")
    TRAVEL("travel");
    private final String value;

    MasterCardCategoryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MasterCardCategoryType fromValue(String v) {
        for (MasterCardCategoryType c: MasterCardCategoryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
