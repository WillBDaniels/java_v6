
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.vantiv.types.payment.instruments.v6.CreditInstrumentType;
import com.vantiv.types.payment.instruments.v6.DebitInstrumentType;
import com.vantiv.types.payment.instruments.v6.GiftInstrumentType;


/**
 * Balance Inquiry Transaction Request
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}TransactionRequestType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="Gift" type="{urn:com:vantiv:types:payment:instruments:v6}GiftInstrumentType"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="Credit" type="{urn:com:vantiv:types:payment:instruments:v6}CreditInstrumentType"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="Debit" type="{urn:com:vantiv:types:payment:instruments:v6}DebitInstrumentType"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "gift",
    "credit",
    "debit"
})
@XmlRootElement(name = "BalanceInquiryRequest")
public class BalanceInquiryRequest
    extends TransactionRequestType
{

    @XmlElement(name = "Gift")
    protected GiftInstrumentType gift;
    @XmlElement(name = "Credit")
    protected CreditInstrumentType credit;
    @XmlElement(name = "Debit")
    protected DebitInstrumentType debit;

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
     * Gets the value of the credit property.
     * 
     * @return
     *     possible object is
     *     {@link CreditInstrumentType }
     *     
     */
    public CreditInstrumentType getCredit() {
        return credit;
    }

    /**
     * Sets the value of the credit property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditInstrumentType }
     *     
     */
    public void setCredit(CreditInstrumentType value) {
        this.credit = value;
    }

    /**
     * Gets the value of the debit property.
     * 
     * @return
     *     possible object is
     *     {@link DebitInstrumentType }
     *     
     */
    public DebitInstrumentType getDebit() {
        return debit;
    }

    /**
     * Sets the value of the debit property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitInstrumentType }
     *     
     */
    public void setDebit(DebitInstrumentType value) {
        this.debit = value;
    }

}
