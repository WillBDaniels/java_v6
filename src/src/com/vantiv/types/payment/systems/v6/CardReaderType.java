
package com.vantiv.types.payment.systems.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardReaderType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CardReaderType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="unknown"/>
 *     &lt;enumeration value="magstripe"/>
 *     &lt;enumeration value="barcode"/>
 *     &lt;enumeration value="ocr"/>
 *     &lt;enumeration value="chip"/>
 *     &lt;enumeration value="micr"/>
 *     &lt;enumeration value="micr_image"/>
 *     &lt;enumeration value="proximity"/>
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="not_specified"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CardReaderType")
@XmlEnum
public enum CardReaderType {


    /**
     * Unknown
     * 
     */
    @XmlEnumValue("unknown")
    UNKNOWN("unknown"),

    /**
     * Magnetic strip read capable
     * 
     */
    @XmlEnumValue("magstripe")
    MAGSTRIPE("magstripe"),

    /**
     * Bar code read capable
     * 
     */
    @XmlEnumValue("barcode")
    BARCODE("barcode"),

    /**
     * OCR read capable
     * 
     */
    @XmlEnumValue("ocr")
    OCR("ocr"),

    /**
     * Chip read capable
     * 
     */
    @XmlEnumValue("chip")
    CHIP("chip"),

    /**
     * Magnetic Ink Character Recognition (MICR) read capable
     * 
     */
    @XmlEnumValue("micr")
    MICR("micr"),

    /**
     * Magnetic Ink Character Recognition (MICR) read and image capable
     * 
     */
    @XmlEnumValue("micr_image")
    MICR_IMAGE("micr_image"),

    /**
     * Proximity read capable
     * 
     */
    @XmlEnumValue("proximity")
    PROXIMITY("proximity"),

    /**
     * Does not have card read capability
     * 
     */
    @XmlEnumValue("none")
    NONE("none"),

    /**
     * card reader capability not specified
     * 
     */
    @XmlEnumValue("not_specified")
    NOT_SPECIFIED("not_specified");
    private final String value;

    CardReaderType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CardReaderType fromValue(String v) {
        for (CardReaderType c: CardReaderType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
