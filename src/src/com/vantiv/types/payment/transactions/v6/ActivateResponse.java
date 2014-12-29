
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Activate Transaction Response
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}TransactionResponseType">
 *       &lt;sequence>
 *         &lt;element name="VirtualGiftCardSecurityCode" type="{urn:com:vantiv:types:common:v6}NumericStringRange4-12Inclusive" minOccurs="0"/>
 *         &lt;element name="VirtualGiftCardPrimaryAccountNumber" type="{urn:com:vantiv:types:payment:instruments:v6}PrimaryAccountNumberType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "virtualGiftCardSecurityCode",
    "virtualGiftCardPrimaryAccountNumber"
})
@XmlRootElement(name = "ActivateResponse")
public class ActivateResponse
    extends TransactionResponseType
{

    @XmlElement(name = "VirtualGiftCardSecurityCode")
    protected String virtualGiftCardSecurityCode;
    @XmlElement(name = "VirtualGiftCardPrimaryAccountNumber")
    protected String virtualGiftCardPrimaryAccountNumber;

    /**
     * Gets the value of the virtualGiftCardSecurityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVirtualGiftCardSecurityCode() {
        return virtualGiftCardSecurityCode;
    }

    /**
     * Sets the value of the virtualGiftCardSecurityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVirtualGiftCardSecurityCode(String value) {
        this.virtualGiftCardSecurityCode = value;
    }

    /**
     * Gets the value of the virtualGiftCardPrimaryAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVirtualGiftCardPrimaryAccountNumber() {
        return virtualGiftCardPrimaryAccountNumber;
    }

    /**
     * Sets the value of the virtualGiftCardPrimaryAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVirtualGiftCardPrimaryAccountNumber(String value) {
        this.virtualGiftCardPrimaryAccountNumber = value;
    }

}
