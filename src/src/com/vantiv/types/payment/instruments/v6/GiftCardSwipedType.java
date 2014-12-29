
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Data Elements required for Gift Card Present transactions
 * 
 * <p>Java class for GiftCardSwipedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GiftCardSwipedType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:instruments:v6}CardSwipedType">
 *       &lt;sequence>
 *         &lt;element name="CardSecurityCode" type="{urn:com:vantiv:types:payment:instruments:v6}CardSecurityCodeType" minOccurs="0"/>
 *         &lt;element name="GiftCardPin" type="{urn:com:vantiv:types:payment:instruments:v6}GiftCardPinType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GiftCardSwipedType", propOrder = {
    "cardSecurityCode",
    "giftCardPin"
})
public class GiftCardSwipedType
    extends CardSwipedType
{

    @XmlElement(name = "CardSecurityCode")
    protected String cardSecurityCode;
    @XmlElement(name = "GiftCardPin")
    protected String giftCardPin;

    /**
     * Gets the value of the cardSecurityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardSecurityCode() {
        return cardSecurityCode;
    }

    /**
     * Sets the value of the cardSecurityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardSecurityCode(String value) {
        this.cardSecurityCode = value;
    }

    /**
     * Gets the value of the giftCardPin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiftCardPin() {
        return giftCardPin;
    }

    /**
     * Sets the value of the giftCardPin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiftCardPin(String value) {
        this.giftCardPin = value;
    }

}
