
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Data Elements required for Gift Card Not Present transactions
 * 
 * <p>Java class for CreditOrDebitCardKeyedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditOrDebitCardKeyedType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:instruments:v6}CardKeyedType">
 *       &lt;sequence>
 *         &lt;element name="CardholderName" type="{urn:com:vantiv:types:common:v6}String20" minOccurs="0"/>
 *         &lt;element name="ThreeDSecure" type="{urn:com:vantiv:types:payment:instruments:v6}ThreeDSecureType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditOrDebitCardKeyedType", propOrder = {
    "cardholderName",
    "threeDSecure"
})
public class CreditOrDebitCardKeyedType
    extends CardKeyedType
{

    @XmlElement(name = "CardholderName")
    protected String cardholderName;
    @XmlElement(name = "ThreeDSecure")
    protected ThreeDSecureType threeDSecure;

    /**
     * Gets the value of the cardholderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardholderName() {
        return cardholderName;
    }

    /**
     * Sets the value of the cardholderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardholderName(String value) {
        this.cardholderName = value;
    }

    /**
     * Gets the value of the threeDSecure property.
     * 
     * @return
     *     possible object is
     *     {@link ThreeDSecureType }
     *     
     */
    public ThreeDSecureType getThreeDSecure() {
        return threeDSecure;
    }

    /**
     * Sets the value of the threeDSecure property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThreeDSecureType }
     *     
     */
    public void setThreeDSecure(ThreeDSecureType value) {
        this.threeDSecure = value;
    }

}
