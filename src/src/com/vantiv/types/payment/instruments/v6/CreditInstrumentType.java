
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.vantiv.types.common.v6.AddressType;


/**
 * Credit Card Payment Instrument
 * 
 * <p>Java class for CreditInstrumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditInstrumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardholderAddress" type="{urn:com:vantiv:types:common:v6}AddressType" minOccurs="0"/>
 *         &lt;element name="PartialApprovalCode" type="{urn:com:vantiv:types:payment:instruments:v6}PartialIndicatorType" minOccurs="0"/>
 *         &lt;element name="CardType" type="{urn:com:vantiv:types:payment:instruments:v6}CreditCardNetworkType"/>
 *         &lt;group ref="{urn:com:vantiv:types:payment:instruments:v6}CreditOrDebitCardGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditInstrumentType", propOrder = {
    "cardholderAddress",
    "partialApprovalCode",
    "cardType",
    "cardKeyed",
    "cardSwiped"
})
public class CreditInstrumentType {

    @XmlElement(name = "CardholderAddress")
    protected AddressType cardholderAddress;
    @XmlElement(name = "PartialApprovalCode")
    @XmlSchemaType(name = "string")
    protected PartialIndicatorType partialApprovalCode;
    @XmlElement(name = "CardType", required = true)
    @XmlSchemaType(name = "string")
    protected CreditCardNetworkType cardType;
    @XmlElement(name = "CardKeyed")
    protected CreditOrDebitCardKeyedType cardKeyed;
    @XmlElement(name = "CardSwiped")
    protected CardSwipedType cardSwiped;

    /**
     * Gets the value of the cardholderAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getCardholderAddress() {
        return cardholderAddress;
    }

    /**
     * Sets the value of the cardholderAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setCardholderAddress(AddressType value) {
        this.cardholderAddress = value;
    }

    /**
     * Gets the value of the partialApprovalCode property.
     * 
     * @return
     *     possible object is
     *     {@link PartialIndicatorType }
     *     
     */
    public PartialIndicatorType getPartialApprovalCode() {
        return partialApprovalCode;
    }

    /**
     * Sets the value of the partialApprovalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartialIndicatorType }
     *     
     */
    public void setPartialApprovalCode(PartialIndicatorType value) {
        this.partialApprovalCode = value;
    }

    /**
     * Gets the value of the cardType property.
     * 
     * @return
     *     possible object is
     *     {@link CreditCardNetworkType }
     *     
     */
    public CreditCardNetworkType getCardType() {
        return cardType;
    }

    /**
     * Sets the value of the cardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCardNetworkType }
     *     
     */
    public void setCardType(CreditCardNetworkType value) {
        this.cardType = value;
    }

    /**
     * Gets the value of the cardKeyed property.
     * 
     * @return
     *     possible object is
     *     {@link CreditOrDebitCardKeyedType }
     *     
     */
    public CreditOrDebitCardKeyedType getCardKeyed() {
        return cardKeyed;
    }

    /**
     * Sets the value of the cardKeyed property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditOrDebitCardKeyedType }
     *     
     */
    public void setCardKeyed(CreditOrDebitCardKeyedType value) {
        this.cardKeyed = value;
    }

    /**
     * Gets the value of the cardSwiped property.
     * 
     * @return
     *     possible object is
     *     {@link CardSwipedType }
     *     
     */
    public CardSwipedType getCardSwiped() {
        return cardSwiped;
    }

    /**
     * Sets the value of the cardSwiped property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardSwipedType }
     *     
     */
    public void setCardSwiped(CardSwipedType value) {
        this.cardSwiped = value;
    }

}
