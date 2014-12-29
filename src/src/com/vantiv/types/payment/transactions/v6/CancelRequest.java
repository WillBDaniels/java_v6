
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.vantiv.types.common.v6.AmountType;
import com.vantiv.types.common.v6.ReplacementAmountType;
import com.vantiv.types.payment.instruments.v6.CreditInstrumentType;
import com.vantiv.types.payment.instruments.v6.DebitInstrumentType;
import com.vantiv.types.payment.instruments.v6.GiftInstrumentType;


/**
 * Cancel Transaction Request
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
 *         &lt;element name="CancelType" type="{urn:com:vantiv:types:payment:transactions:v6}CancelTransactionType"/>
 *         &lt;element name="OriginalAmount" type="{urn:com:vantiv:types:common:v6}AmountType" minOccurs="0"/>
 *         &lt;element name="OriginalTransactionTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="OriginalSystemTraceId" type="{urn:com:vantiv:types:payment:transactions:v6}SystemTraceType" minOccurs="0"/>
 *         &lt;element name="OriginalReferenceNumber" type="{urn:com:vantiv:types:payment:transactions:v6}ReferenceNumberType" minOccurs="0"/>
 *         &lt;element name="OriginalSequenceNumber" type="{urn:com:vantiv:types:payment:systems:v6}SequenceType" minOccurs="0"/>
 *         &lt;element name="OriginalAuthCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReversalReason" type="{urn:com:vantiv:types:payment:transactions:v6}ReversalReasonType" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;sequence>
 *             &lt;choice>
 *               &lt;element name="Credit" type="{urn:com:vantiv:types:payment:instruments:v6}CreditInstrumentType"/>
 *               &lt;element name="Debit" type="{urn:com:vantiv:types:payment:instruments:v6}DebitInstrumentType"/>
 *             &lt;/choice>
 *             &lt;element name="ReplacementAmount" type="{urn:com:vantiv:types:common:v6}ReplacementAmountType" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="Gift" type="{urn:com:vantiv:types:payment:instruments:v6}GiftInstrumentType"/>
 *             &lt;element name="VirtualGiftCardBIN" type="{urn:com:vantiv:types:common:v6}String10" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="IncrementalAuthorization" type="{urn:com:vantiv:types:payment:transactions:v6}IncrementalAuthorizationType" minOccurs="0"/>
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
    "cancelType",
    "originalAmount",
    "originalTransactionTimestamp",
    "originalSystemTraceId",
    "originalReferenceNumber",
    "originalSequenceNumber",
    "originalAuthCode",
    "reversalReason",
    "credit",
    "debit",
    "replacementAmount",
    "gift",
    "virtualGiftCardBIN",
    "incrementalAuthorization"
})
@XmlRootElement(name = "CancelRequest")
public class CancelRequest
    extends TransactionRequestType
{

    @XmlElement(name = "CancelType", required = true)
    @XmlSchemaType(name = "string")
    protected CancelTransactionType cancelType;
    @XmlElement(name = "OriginalAmount")
    protected AmountType originalAmount;
    @XmlElement(name = "OriginalTransactionTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar originalTransactionTimestamp;
    @XmlElement(name = "OriginalSystemTraceId")
    protected Long originalSystemTraceId;
    @XmlElement(name = "OriginalReferenceNumber")
    protected String originalReferenceNumber;
    @XmlElement(name = "OriginalSequenceNumber")
    protected String originalSequenceNumber;
    @XmlElement(name = "OriginalAuthCode")
    protected String originalAuthCode;
    @XmlElement(name = "ReversalReason")
    @XmlSchemaType(name = "string")
    protected ReversalReasonType reversalReason;
    @XmlElement(name = "Credit")
    protected CreditInstrumentType credit;
    @XmlElement(name = "Debit")
    protected DebitInstrumentType debit;
    @XmlElement(name = "ReplacementAmount")
    protected ReplacementAmountType replacementAmount;
    @XmlElement(name = "Gift")
    protected GiftInstrumentType gift;
    @XmlElement(name = "VirtualGiftCardBIN")
    protected String virtualGiftCardBIN;
    @XmlElement(name = "IncrementalAuthorization")
    protected IncrementalAuthorizationType incrementalAuthorization;

    /**
     * Gets the value of the cancelType property.
     * 
     * @return
     *     possible object is
     *     {@link CancelTransactionType }
     *     
     */
    public CancelTransactionType getCancelType() {
        return cancelType;
    }

    /**
     * Sets the value of the cancelType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelTransactionType }
     *     
     */
    public void setCancelType(CancelTransactionType value) {
        this.cancelType = value;
    }

    /**
     * Gets the value of the originalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getOriginalAmount() {
        return originalAmount;
    }

    /**
     * Sets the value of the originalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setOriginalAmount(AmountType value) {
        this.originalAmount = value;
    }

    /**
     * Gets the value of the originalTransactionTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOriginalTransactionTimestamp() {
        return originalTransactionTimestamp;
    }

    /**
     * Sets the value of the originalTransactionTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOriginalTransactionTimestamp(XMLGregorianCalendar value) {
        this.originalTransactionTimestamp = value;
    }

    /**
     * Gets the value of the originalSystemTraceId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOriginalSystemTraceId() {
        return originalSystemTraceId;
    }

    /**
     * Sets the value of the originalSystemTraceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOriginalSystemTraceId(Long value) {
        this.originalSystemTraceId = value;
    }

    /**
     * Gets the value of the originalReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalReferenceNumber() {
        return originalReferenceNumber;
    }

    /**
     * Sets the value of the originalReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalReferenceNumber(String value) {
        this.originalReferenceNumber = value;
    }

    /**
     * Gets the value of the originalSequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalSequenceNumber() {
        return originalSequenceNumber;
    }

    /**
     * Sets the value of the originalSequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalSequenceNumber(String value) {
        this.originalSequenceNumber = value;
    }

    /**
     * Gets the value of the originalAuthCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalAuthCode() {
        return originalAuthCode;
    }

    /**
     * Sets the value of the originalAuthCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalAuthCode(String value) {
        this.originalAuthCode = value;
    }

    /**
     * Gets the value of the reversalReason property.
     * 
     * @return
     *     possible object is
     *     {@link ReversalReasonType }
     *     
     */
    public ReversalReasonType getReversalReason() {
        return reversalReason;
    }

    /**
     * Sets the value of the reversalReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReversalReasonType }
     *     
     */
    public void setReversalReason(ReversalReasonType value) {
        this.reversalReason = value;
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
     * Gets the value of the replacementAmount property.
     * 
     * @return
     *     possible object is
     *     {@link ReplacementAmountType }
     *     
     */
    public ReplacementAmountType getReplacementAmount() {
        return replacementAmount;
    }

    /**
     * Sets the value of the replacementAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplacementAmountType }
     *     
     */
    public void setReplacementAmount(ReplacementAmountType value) {
        this.replacementAmount = value;
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
     * Gets the value of the virtualGiftCardBIN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVirtualGiftCardBIN() {
        return virtualGiftCardBIN;
    }

    /**
     * Sets the value of the virtualGiftCardBIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVirtualGiftCardBIN(String value) {
        this.virtualGiftCardBIN = value;
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

}
