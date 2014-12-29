
package com.vantiv.types.common.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Postal Address
 * 
 * <p>Java class for AddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddressLine" type="{urn:com:vantiv:types:common:v6}String20" minOccurs="0"/>
 *         &lt;element name="City" type="{urn:com:vantiv:types:common:v6}String128" minOccurs="0"/>
 *         &lt;element name="State" type="{urn:com:vantiv:types:common:v6}StateCodeType" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{urn:com:vantiv:types:common:v6}ZipCodeType"/>
 *         &lt;element name="CountryCode" type="{urn:com:vantiv:types:common:v6}ISO3166CountryCodeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = {
    "addressLine",
    "city",
    "state",
    "postalCode",
    "countryCode"
})
public class AddressType {

    @XmlElement(name = "AddressLine")
    protected String addressLine;
    @XmlElement(name = "City")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String city;
    @XmlElement(name = "State")
    @XmlSchemaType(name = "string")
    protected StateCodeType state;
    @XmlElement(name = "PostalCode", required = true)
    protected String postalCode;
    @XmlElement(name = "CountryCode")
    @XmlSchemaType(name = "string")
    protected ISO3166CountryCodeType countryCode;

    /**
     * Gets the value of the addressLine property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressLine() {
        return addressLine;
    }

    /**
     * Sets the value of the addressLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressLine(String value) {
        this.addressLine = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link StateCodeType }
     *     
     */
    public StateCodeType getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link StateCodeType }
     *     
     */
    public void setState(StateCodeType value) {
        this.state = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link ISO3166CountryCodeType }
     *     
     */
    public ISO3166CountryCodeType getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ISO3166CountryCodeType }
     *     
     */
    public void setCountryCode(ISO3166CountryCodeType value) {
        this.countryCode = value;
    }

}
