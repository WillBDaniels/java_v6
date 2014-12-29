
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.vantiv.types.common.v6.AmountType;
import com.vantiv.types.payment.instruments.v6.GiftInstrumentType;
import com.vantiv.types.payment.instruments.v6.VirtualGiftInstrumentType;


/**
 * Activate Transaction Request
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}TransactionRequestType">
 *       &lt;sequence>
 *         &lt;element name="TransactionAmount" type="{urn:com:vantiv:types:common:v6}AmountType" minOccurs="0"/>
 *         &lt;sequence>
 *           &lt;choice>
 *             &lt;element name="Gift" type="{urn:com:vantiv:types:payment:instruments:v6}GiftInstrumentType"/>
 *             &lt;element name="VirtualGift" type="{urn:com:vantiv:types:payment:instruments:v6}VirtualGiftInstrumentType"/>
 *           &lt;/choice>
 *         &lt;/sequence>
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
    "transactionAmount",
    "gift",
    "virtualGift"
})
@XmlRootElement(name = "ActivateRequest")
public class ActivateRequest
    extends TransactionRequestType
{

    @XmlElement(name = "TransactionAmount")
    protected AmountType transactionAmount;
    @XmlElement(name = "Gift")
    protected GiftInstrumentType gift;
    @XmlElement(name = "VirtualGift")
    protected VirtualGiftInstrumentType virtualGift;

    /**
     * Gets the value of the transactionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the value of the transactionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setTransactionAmount(AmountType value) {
        this.transactionAmount = value;
    }

    /**
     * Gets the value of the gift property.
     * 
     * @return
     *     possible object is
     *     {@link GiftInstrumentType }
     *     
     */
    public GiftInstrumentType getGift() {
        return gift;
    }

    /**
     * Sets the value of the gift property.
     * 
     * @param value
     *     allowed object is
     *     {@link GiftInstrumentType }
     *     
     */
    public void setGift(GiftInstrumentType value) {
        this.gift = value;
    }

    /**
     * Gets the value of the virtualGift property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualGiftInstrumentType }
     *     
     */
    public VirtualGiftInstrumentType getVirtualGift() {
        return virtualGift;
    }

    /**
     * Sets the value of the virtualGift property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualGiftInstrumentType }
     *     
     */
    public void setVirtualGift(VirtualGiftInstrumentType value) {
        this.virtualGift = value;
    }

}
