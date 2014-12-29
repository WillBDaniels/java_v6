
package com.vantiv.types.payment.systems.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntryModeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntryModeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="unknown"/>
 *     &lt;enumeration value="manual"/>
 *     &lt;enumeration value="track1"/>
 *     &lt;enumeration value="track2"/>
 *     &lt;enumeration value="barcode"/>
 *     &lt;enumeration value="ocr"/>
 *     &lt;enumeration value="integrated_circuit"/>
 *     &lt;enumeration value="proximity_vsdc"/>
 *     &lt;enumeration value="proximity_contactless"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntryModeType")
@XmlEnum
public enum EntryModeType {


    /**
     * Unknown
     * 
     */
    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),

    /**
     * Manual Entry
     * 
     */
    @XmlEnumValue("manual")
    MANUAL("manual"),

    /**
     * Magnetic Track 1
     * 
     */
    @XmlEnumValue("track1")
    TRACK_1("track1"),

    /**
     * Magnetic Track 2
     * 
     */
    @XmlEnumValue("track2")
    TRACK_2("track2"),

    /**
     * Bar Code Read
     * 
     */
    @XmlEnumValue("barcode")
    BARCODE("barcode"),

    /**
     * OCR READ
     * 
     */
    @XmlEnumValue("ocr")
    OCR("ocr"),

    /**
     * Integrated Circuit Read
     * 
     */
    @XmlEnumValue("integrated_circuit")
    INTEGRATED_CIRCUIT("integrated_circuit"),

    /**
     * Proximity Read Using VSDC Chip
     * 
     */
    @XmlEnumValue("proximity_vsdc")
    PROXIMITY_VSDC("proximity_vsdc"),

    /**
     * Proximity Contactless Mag Stripe
     * 
     */
    @XmlEnumValue("proximity_contactless")
    PROXIMITY_CONTACTLESS("proximity_contactless");
    private final String value;

    EntryModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EntryModeType fromValue(String v) {
        for (EntryModeType c: EntryModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
