
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Prepaid Payment Instrument
 * 
 * <p>Java class for GiftInstrumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GiftInstrumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:com:vantiv:types:payment:instruments:v6}GiftCardGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GiftInstrumentType", propOrder = {
    "cardKeyed",
    "cardSwiped"
})
public class GiftInstrumentType {

    @XmlElement(name = "CardKeyed")
    protected GiftCardKeyedType cardKeyed;
    @XmlElement(name = "CardSwiped")
    protected GiftCardSwipedType cardSwiped;

    /**
     * Gets the value of the cardKeyed property.
     * 
     * @return
     *     possible object is
     *     {@link GiftCardKeyedType }
     *     
     */
    public GiftCardKeyedType getCardKeyed() {
        return cardKeyed;
    }

    /**
     * Sets the value of the cardKeyed property.
     * 
     * @param value
     *     allowed object is
     *     {@link GiftCardKeyedType }
     *     
     */
    public void setCardKeyed(GiftCardKeyedType value) {
        this.cardKeyed = value;
    }

    /**
     * Gets the value of the cardSwiped property.
     * 
     * @return
     *     possible object is
     *     {@link GiftCardSwipedType }
     *     
     */
    public GiftCardSwipedType getCardSwiped() {
        return cardSwiped;
    }

    /**
     * Sets the value of the cardSwiped property.
     * 
     * @param value
     *     allowed object is
     *     {@link GiftCardSwipedType }
     *     
     */
    public void setCardSwiped(GiftCardSwipedType value) {
        this.cardSwiped = value;
    }

}
