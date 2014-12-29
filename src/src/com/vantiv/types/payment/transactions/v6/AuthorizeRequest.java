
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.vantiv.types.common.v6.AmountType;
import com.vantiv.types.payment.instruments.v6.CreditInstrumentType;
import com.vantiv.types.payment.instruments.v6.GiftInstrumentType;


/**
 * Authorization Transaction Request
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
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="Credit" type="{urn:com:vantiv:types:payment:instruments:v6}CreditInstrumentType"/>
 *             &lt;element name="Tax" type="{urn:com:vantiv:types:payment:transactions:v6}TaxAmountType" minOccurs="0"/>
 *             &lt;element name="PurchaseOrder" type="{urn:com:vantiv:types:payment:transactions:v6}PurchaseOrderType" minOccurs="0"/>
 *             &lt;element name="IncrementalAuthorization" type="{urn:com:vantiv:types:payment:transactions:v6}IncrementalAuthorizationType" minOccurs="0"/>
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
    "credit",
    "tax",
    "purchaseOrder",
    "incrementalAuthorization",
    "gift"
})
@XmlRootElement(name = "AuthorizeRequest")
public class AuthorizeRequest
    extends TransactionRequestType
{

    @XmlElement(name = "TransactionAmount", required = true)
    protected AmountType transactionAmount;
    @XmlElement(name = "Credit")
    protected CreditInstrumentType credit;
    @XmlElement(name = "Tax")
    protected TaxAmountType tax;
    @XmlElement(name = "PurchaseOrder")
    protected String purchaseOrder;
    @XmlElement(name = "IncrementalAuthorization")
    protected IncrementalAuthorizationType incrementalAuthorization;
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
     * Gets the value of the incrementalAuthorization property.
     * 
     * @return
     *     possible object is
     *     {@link IncrementalAuthorizationType }
     *     
     */
    public IncrementalAuthorizationType getIncrementalAuthorization() {
        return incrementalAuthorization;
    }

    /**
     * Sets the value of the incrementalAuthorization property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncrementalAuthorizationType }
     *     
     */
    public void setIncrementalAuthorization(IncrementalAuthorizationType value) {
        this.incrementalAuthorization = value;
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
