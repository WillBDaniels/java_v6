
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressVerificationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AddressVerificationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="match_address_no_match_zip"/>
 *     &lt;enumeration value="match_address_incompatible"/>
 *     &lt;enumeration value="not_verified_incompatible"/>
 *     &lt;enumeration value="international_match_d"/>
 *     &lt;enumeration value="error"/>
 *     &lt;enumeration value="uk_match_address_match_zip"/>
 *     &lt;enumeration value="not_verified"/>
 *     &lt;enumeration value="international_not_verified"/>
 *     &lt;enumeration value="international_match_m"/>
 *     &lt;enumeration value="no_match_address_no_match_zip"/>
 *     &lt;enumeration value="address_not_verified_match_zip"/>
 *     &lt;enumeration value="retry"/>
 *     &lt;enumeration value="not_supported"/>
 *     &lt;enumeration value="unavailable"/>
 *     &lt;enumeration value="no_match_address_match_xzip"/>
 *     &lt;enumeration value="match_address_match_xzip"/>
 *     &lt;enumeration value="match_address_match_zip"/>
 *     &lt;enumeration value="no_match_address_match_zip"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AddressVerificationType")
@XmlEnum
public enum AddressVerificationType {


    /**
     * Address Matches, Zip Does Not
     * 
     */
    @XmlEnumValue("match_address_no_match_zip")
    MATCH_ADDRESS_NO_MATCH_ZIP("match_address_no_match_zip"),

    /**
     * Street Addresses Match, Postal Code Not Verified Because Of
     *                         Incompatible
     *                         Formats
     *                     
     * 
     */
    @XmlEnumValue("match_address_incompatible")
    MATCH_ADDRESS_INCOMPATIBLE("match_address_incompatible"),

    /**
     * Street Address And Postal Code Not Verified Because Of
     *                         Incompatible
     *                         Formats
     *                     
     * 
     */
    @XmlEnumValue("not_verified_incompatible")
    NOT_VERIFIED_INCOMPATIBLE("not_verified_incompatible"),

    /**
     * Street Addresses And Postal Codes Match (International)
     *                     
     * 
     */
    @XmlEnumValue("international_match_d")
    INTERNATIONAL_MATCH_D("international_match_d"),

    /**
     * Error performing AVS verification
     * 
     */
    @XmlEnumValue("error")
    ERROR("error"),

    /**
     * Street Address And Postal Codes Match (UK Only)
     *                     
     * 
     */
    @XmlEnumValue("uk_match_address_match_zip")
    UK_MATCH_ADDRESS_MATCH_ZIP("uk_match_address_match_zip"),

    /**
     * Non-AVS Participant Outside The Us; Address Not Verified For
     *                         International Transaction
     *                     
     * 
     */
    @XmlEnumValue("not_verified")
    NOT_VERIFIED("not_verified"),

    /**
     * Address Information Not Verified For International Transaction
     *                     
     * 
     */
    @XmlEnumValue("international_not_verified")
    INTERNATIONAL_NOT_VERIFIED("international_not_verified"),

    /**
     * Street Addresses And Postal Codes Match (International)
     *                     
     * 
     */
    @XmlEnumValue("international_match_m")
    INTERNATIONAL_MATCH_M("international_match_m"),

    /**
     * Neither the Street Address nor ZIP Code match
     *                     
     * 
     */
    @XmlEnumValue("no_match_address_no_match_zip")
    NO_MATCH_ADDRESS_NO_MATCH_ZIP("no_match_address_no_match_zip"),

    /**
     * Postal Codes Match. Street Address Not Verified Because Of
     *                         Incompatible
     *                         Formats
     *                     
     * 
     */
    @XmlEnumValue("address_not_verified_match_zip")
    ADDRESS_NOT_VERIFIED_MATCH_ZIP("address_not_verified_match_zip"),

    /**
     * Retry, system unavailable or timed out
     * 
     */
    @XmlEnumValue("retry")
    RETRY("retry"),

    /**
     * AVS Currently Not Supported
     * 
     */
    @XmlEnumValue("not_supported")
    NOT_SUPPORTED("not_supported"),

    /**
     * Issuer is unavailable
     * 
     */
    @XmlEnumValue("unavailable")
    UNAVAILABLE("unavailable"),

    /**
     * For U.S. Addresses, 9 Digits Zip Code Matches, Address Does Not
     *                         Match
     *                     
     * 
     */
    @XmlEnumValue("no_match_address_match_xzip")
    NO_MATCH_ADDRESS_MATCH_XZIP("no_match_address_match_xzip"),

    /**
     * For U.S. Addresses, 9 Digits Zip Code Matches, Address Does
     *                         Match
     *                     
     * 
     */
    @XmlEnumValue("match_address_match_xzip")
    MATCH_ADDRESS_MATCH_XZIP("match_address_match_xzip"),

    /**
     * For U.S. Addresses, Zip Code Matches, Address Does Match
     *                     
     * 
     */
    @XmlEnumValue("match_address_match_zip")
    MATCH_ADDRESS_MATCH_ZIP("match_address_match_zip"),

    /**
     * For U.S. Addresses, Zip Code Matches, Address Does Not Match
     *                     
     * 
     */
    @XmlEnumValue("no_match_address_match_zip")
    NO_MATCH_ADDRESS_MATCH_ZIP("no_match_address_match_zip");
    private final String value;

    AddressVerificationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AddressVerificationType fromValue(String v) {
        for (AddressVerificationType c: AddressVerificationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
