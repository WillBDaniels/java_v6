
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Base type for Batch Transaction Request
 * 
 * <p>Java class for BatchRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}PaymentRequest">
 *       &lt;sequence>
 *         &lt;element name="Merchant" type="{urn:com:vantiv:types:payment:transactions:v6}MerchantType"/>
 *         &lt;element name="TransactionTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DraftLocatorId" type="{urn:com:vantiv:types:common:v6}String11" minOccurs="0"/>
 *         &lt;element name="Balances" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchRequestType", propOrder = {
    "merchant",
    "transactionTimestamp",
    "draftLocatorId",
    "balances"
})
@XmlSeeAlso({
    CloseBatchRequest.class,
    BatchBalanceRequest.class
})
public abstract class BatchRequestType
    extends PaymentRequest
{

    @XmlElement(name = "Merchant", required = true)
    protected MerchantType merchant;
    @XmlElement(name = "TransactionTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transactionTimestamp;
    @XmlElement(name = "DraftLocatorId")
    protected String draftLocatorId;
    @XmlElement(name = "Balances")
    protected BalanceEntry balances;

    /**
     * Gets the value of the merchant property.
     * 
     * @return
     *     possible object is
     *     {@link MerchantType }
     *     
     */
    public MerchantType getMerchant() {
        return merchant;
    }

    /**
     * Sets the value of the merchant property.
     * 
     * @param value
     *     allowed object is
     *     {@link MerchantType }
     *     
     */
    public void setMerchant(MerchantType value) {
        this.merchant = value;
    }

    /**
     * Gets the value of the transactionTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransactionTimestamp() {
        return transactionTimestamp;
    }

    /**
     * Sets the value of the transactionTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransactionTimestamp(XMLGregorianCalendar value) {
        this.transactionTimestamp = value;
    }

    /**
     * Gets the value of the draftLocatorId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDraftLocatorId() {
        return draftLocatorId;
    }

    /**
     * Sets the value of the draftLocatorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDraftLocatorId(String value) {
        this.draftLocatorId = value;
    }

    /**
     * Gets the value of the balances property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceEntry }
     *     
     */
    public BalanceEntry getBalances() {
        return balances;
    }

    /**
     * Sets the value of the balances property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceEntry }
     *     
     */
    public void setBalances(BalanceEntry value) {
        this.balances = value;
    }

}
