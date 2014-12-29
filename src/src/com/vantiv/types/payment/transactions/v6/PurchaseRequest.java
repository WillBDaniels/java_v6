
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.vantiv.types.common.v6.AmountType;
import com.vantiv.types.payment.instruments.v6.CreditInstrumentType;
import com.vantiv.types.payment.instruments.v6.DebitInstrumentType;
import com.vantiv.types.payment.instruments.v6.GiftInstrumentType;


/**
 * Purchase Transaction Request
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
 *         &lt;element name="TransactionAmount" type="{urn:com:vantiv:types:common:v6}AmountType"/>
 *         &lt;element name="AuthorizationCode" type="{urn:com:vantiv:types:payment:transactions:v6}AuthorizationCodeType" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;choice>
 *               &lt;element name="Credit" type="{urn:com:vantiv:types:payment:instruments:v6}CreditInstrumentType"/>
 *               &lt;element name="Debit" type="{urn:com:vantiv:types:payment:instruments:v6}DebitInstrumentType"/>
 *             &lt;/choice>
 *             &lt;element name="TipAmount" type="{urn:com:vantiv:types:common:v6}AmountType" minOccurs="0"/>
 *             &lt;element name="ConvenienceFee" type="{urn:com:vantiv:types:common:v6}AmountType" minOccurs="0"/>
 *             &lt;element name="Tax" type="{urn:com:vantiv:types:payment:transactions:v6}TaxAmountType" minOccurs="0"/>
 *             &lt;element name="PurchaseOrder" type="{urn:com:vantiv:types:payment:transactions:v6}PurchaseOrderType" minOccurs="0"/>
 *             &lt;element name="CashBackAmount" type="{urn:com:vantiv:types:common:v6}AmountType" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="Gift" type="{urn:com:vantiv:types:payment:instruments:v6}GiftInstrumentType"/>
 *           &lt;/sequence>
 *         &lt;/choice>
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
    "authorizationCode",
    "credit",
    "debit",
    "tipAmount",
    "convenienceFee",
    "tax",
    "purchaseOrder",
    "cashBackAmount",
    "gift"
})
@XmlRootElement(name = "PurchaseRequest")
public class PurchaseRequest
    extends TransactionRequestType
{

    @XmlElement(name = "TransactionAmount", required = true)
    protected AmountType transactionAmount;
    @XmlElement(name = "AuthorizationCode")
    protected String authorizationCode;
    @XmlElement(name = "Credit")
    protected CreditInstrumentType credit;
    @XmlElement(name = "Debit")
    protected DebitInstrumentType debit;
    @XmlElement(name = "TipAmount")
    protected AmountType tipAmount;
    @XmlElement(name = "ConvenienceFee")
    protected AmountType convenienceFee;
    @XmlElement(name = "Tax")
    protected TaxAmountType tax;
    @XmlElement(name = "PurchaseOrder")
    protected String purchaseOrder;
    @XmlElement(name = "CashBackAmount")
    protected AmountType cashBackAmount;
    @XmlElement(name = "Gift")
    protected GiftInstrumentType gift;

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
     * Gets the value of the authorizationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationCode() {
        return authorizationCode;
    }

    /**
     * Sets the value of the authorizationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationCode(String value) {
        this.authorizationCode = value;
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

    /**
     * Gets the value of the tipAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getTipAmount() {
        return tipAmount;
    }

    /**
     * Sets the value of the tipAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setTipAmount(AmountType value) {
        this.tipAmount = value;
    }

    /**
     * Gets the value of the convenienceFee property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getConvenienceFee() {
        return convenienceFee;
    }

    /**
     * Sets the value of the convenienceFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setConvenienceFee(AmountType value) {
        this.convenienceFee = value;
    }

    /**
     * Gets the value of the tax property.
     * 
     * @return
     *     possible object is
     *     {@link TaxAmountType }
     *     
     */
    public TaxAmountType getTax() {
        return tax;
    }

    /**
     * Sets the value of the tax property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxAmountType }
     *     
     */
    public void setTax(TaxAmountType value) {
        this.tax = value;
    }

    /**
     * Gets the value of the purchaseOrder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    /**
     * Sets the value of the purchaseOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseOrder(String value) {
        this.purchaseOrder = value;
    }

    /**
     * Gets the value of the cashBackAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getCashBackAmount() {
        return cashBackAmount;
    }

    /**
     * Sets the value of the cashBackAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setCashBackAmount(AmountType value) {
        this.cashBackAmount = value;
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

}
