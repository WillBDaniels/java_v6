
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Data Elements required for Gift Card Not Present transactions
 * 
 * <p>Java class for GiftCardKeyedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GiftCardKeyedType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:instruments:v6}CardKeyedType">
 *       &lt;sequence>
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
@XmlType(name = "GiftCardKeyedType", propOrder = {
    "giftCardPin"
})
public class GiftCardKeyedType
    extends CardKeyedType
{

    @XmlElement(name = "GiftCardPin")
    protected String giftCardPin;

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
