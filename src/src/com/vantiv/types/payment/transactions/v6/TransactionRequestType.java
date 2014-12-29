
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Base Type for Transaction Requests
 * 
 * <p>Java class for TransactionRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}PaymentRequest">
 *       &lt;sequence>
 *         &lt;element name="Merchant" type="{urn:com:vantiv:types:payment:transactions:v6}MerchantType"/>
 *         &lt;element name="TransactionType" type="{urn:com:vantiv:types:payment:transactions:v6}TransactionTypeType"/>
 *         &lt;element name="TransactionTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PaymentType" type="{urn:com:vantiv:types:payment:transactions:v6}PaymentType" minOccurs="0"/>
 *         &lt;element name="DraftLocatorId" type="{urn:com:vantiv:types:common:v6}String11" minOccurs="0"/>
 *         &lt;element name="ReferenceNumber" type="{urn:com:vantiv:types:payment:transactions:v6}ReferenceNumberType" minOccurs="0"/>
 *         &lt;element name="TokenRequested" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BillPaymentPayee" type="{urn:com:vantiv:types:payment:transactions:v6}BillPaymentPayeeType" minOccurs="0"/>
 *         &lt;element name="NetworkResponseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="report-group" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionRequestType", propOrder = {
    "merchant",
    "transactionType",
    "transactionTimestamp",
    "paymentType",
    "draftLocatorId",
    "referenceNumber",
    "tokenRequested",
    "billPaymentPayee",
    "networkResponseCode"
})
@XmlSeeAlso({
    TokenizeRequest.class,
    ActivateRequest.class,
    BalanceInquiryRequest.class,
    UnloadRequest.class,
    UpdateCardRequest.class,
    CloseRequest.class,
    AdjustRequest.class,
    CaptureRequest.class,
    RefundRequest.class,
    PurchaseRequest.class,
    ReloadRequest.class,
    AuthorizeRequest.class,
    CancelRequest.class
})
public abstract class TransactionRequestType
    extends PaymentRequest
{

    @XmlElement(name = "Merchant", required = true)
    protected MerchantType merchant;
    @XmlElement(name = "TransactionType", required = true)
    @XmlSchemaType(name = "string")
    protected TransactionTypeType transactionType;
    @XmlElement(name = "TransactionTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transactionTimestamp;
    @XmlElement(name = "PaymentType")
    @XmlSchemaType(name = "string")
    protected PaymentType paymentType;
    @XmlElement(name = "DraftLocatorId")
    protected String draftLocatorId;
    @XmlElement(name = "ReferenceNumber")
    protected String referenceNumber;
    @XmlElement(name = "TokenRequested")
    protected Boolean tokenRequested;
    @XmlElement(name = "BillPaymentPayee")
    protected BillPaymentPayeeType billPaymentPayee;
    @XmlElement(name = "NetworkResponseCode")
    protected String networkResponseCode;
    @XmlAttribute(name = "report-group")
    protected String reportGroup;

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
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionTypeType }
     *     
     */
    public TransactionTypeType getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionTypeType }
     *     
     */
    public void setTransactionType(TransactionTypeType value) {
        this.transactionType = value;
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
     * Gets the value of the paymentType property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentType }
     *     
     */
    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the value of the paymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentType }
     *     
     */
    public void setPaymentType(PaymentType value) {
        this.paymentType = value;
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
     * Gets the value of the referenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Sets the value of the referenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceNumber(String value) {
        this.referenceNumber = value;
    }

    /**
     * Gets the value of the tokenRequested property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTokenRequested() {
        return tokenRequested;
    }

    /**
     * Sets the value of the tokenRequested property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTokenRequested(Boolean value) {
        this.tokenRequested = value;
    }

    /**
     * Gets the value of the billPaymentPayee property.
     * 
     * @return
     *     possible object is
     *     {@link BillPaymentPayeeType }
     *     
     */
    public BillPaymentPayeeType getBillPaymentPayee() {
        return billPaymentPayee;
    }

    /**
     * Sets the value of the billPaymentPayee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillPaymentPayeeType }
     *     
     */
    public void setBillPaymentPayee(BillPaymentPayeeType value) {
        this.billPaymentPayee = value;
    }

    /**
     * Gets the value of the networkResponseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetworkResponseCode() {
        return networkResponseCode;
    }

    /**
     * Sets the value of the networkResponseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetworkResponseCode(String value) {
        this.networkResponseCode = value;
    }

    /**
     * Gets the value of the reportGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportGroup() {
        return reportGroup;
    }

    /**
     * Sets the value of the reportGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportGroup(String value) {
        this.reportGroup = value;
    }

}
