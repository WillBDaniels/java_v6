
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Virtual Prepaid Payment Instrument
 * 
 * <p>Java class for VirtualGiftInstrumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirtualGiftInstrumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrimaryAccountNumberLength" type="{urn:com:vantiv:types:common:v6}Number2"/>
 *         &lt;element name="VirtualGiftCardBIN" type="{urn:com:vantiv:types:common:v6}String10"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualGiftInstrumentType", propOrder = {
    "primaryAccountNumberLength",
    "virtualGiftCardBIN"
})
public class VirtualGiftInstrumentType {

    @XmlElement(name = "PrimaryAccountNumberLength")
    protected int primaryAccountNumberLength;
    @XmlElement(name = "VirtualGiftCardBIN", required = true)
    protected String virtualGiftCardBIN;

    /**
     * Gets the value of the primaryAccountNumberLength property.
     * 
     */
    public int getPrimaryAccountNumberLength() {
        return primaryAccountNumberLength;
    }

    /**
     * Sets the value of the primaryAccountNumberLength property.
     * 
     */
    public void setPrimaryAccountNumberLength(int value) {
        this.primaryAccountNumberLength = value;
    }

    /**
     * Gets the value of the virtualGiftCardBIN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVirtualGiftCardBIN() {
        return virtualGiftCardBIN;
    }

    /**
     * Sets the value of the virtualGiftCardBIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVirtualGiftCardBIN(String value) {
        this.virtualGiftCardBIN = value;
    }

}
