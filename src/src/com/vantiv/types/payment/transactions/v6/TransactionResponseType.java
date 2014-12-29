
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Base Type for Transaction Responses
 * 
 * <p>Java class for TransactionResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}PaymentResponse">
 *       &lt;sequence>
 *         &lt;element name="DemoMode" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionStatus" type="{urn:com:vantiv:types:payment:transactions:v6}TransactionStatusType"/>
 *         &lt;element name="TransmissionTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TransactionTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="JulianDay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BatchNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CardCategory" type="{urn:com:vantiv:types:payment:transactions:v6}CardCategoryType"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="AuthorizationCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="DeclineCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *             &lt;element name="DeclineMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="AddressVerificationResult" type="{urn:com:vantiv:types:payment:transactions:v6}AddressVerificationResult" minOccurs="0"/>
 *         &lt;element name="CardSecurityCodeResult" type="{urn:com:vantiv:types:payment:transactions:v6}CardSecurityCodeResult" minOccurs="0"/>
 *         &lt;element name="PaymentServiceResults" type="{urn:com:vantiv:types:payment:transactions:v6}CreditNetworkResultsType" minOccurs="0"/>
 *         &lt;element name="Balance" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceType" minOccurs="0"/>
 *         &lt;element name="WorkingKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TokenizationResult" type="{urn:com:vantiv:types:payment:transactions:v6}TokenizationResultType" minOccurs="0"/>
 *         &lt;element name="NetworkResponseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionResponseType", propOrder = {
    "demoMode",
    "referenceNumber",
    "transactionStatus",
    "transmissionTimestamp",
    "transactionTimestamp",
    "julianDay",
    "batchNumber",
    "cardCategory",
    "authorizationCode",
    "declineCode",
    "declineMessage",
    "addressVerificationResult",
    "cardSecurityCodeResult",
    "paymentServiceResults",
    "balance",
    "workingKey",
    "tokenizationResult",
    "networkResponseCode"
})
@XmlSeeAlso({
    CaptureResponse.class,
    ActivateResponse.class,
    UnloadResponse.class,
    UpdateCardResponse.class,
    AuthorizeResponse.class,
    CloseResponse.class,
    RefundResponse.class,
    CancelResponse.class,
    TokenizeResponse.class,
    AdjustResponse.class,
    PurchaseResponse.class,
    BalanceInquiryResponse.class,
    ReloadResponse.class
})
public abstract class TransactionResponseType
    extends PaymentResponse
{

    @XmlElement(name = "DemoMode")
    protected boolean demoMode;
    @XmlElement(name = "ReferenceNumber")
    protected String referenceNumber;
    @XmlElement(name = "TransactionStatus", required = true)
    @XmlSchemaType(name = "string")
    protected TransactionStatusType transactionStatus;
    @XmlElement(name = "TransmissionTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transmissionTimestamp;
    @XmlElement(name = "TransactionTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transactionTimestamp;
    @XmlElement(name = "JulianDay")
    protected int julianDay;
    @XmlElement(name = "BatchNumber")
    protected int batchNumber;
    @XmlElement(name = "CardCategory", required = true)
    @XmlSchemaType(name = "string")
    protected CardCategoryType cardCategory;
    @XmlElement(name = "AuthorizationCode")
    protected String authorizationCode;
    @XmlElement(name = "DeclineCode")
    protected String declineCode;
    @XmlElement(name = "DeclineMessage")
    protected String declineMessage;
    @XmlElement(name = "AddressVerificationResult")
    protected AddressVerificationResult addressVerificationResult;
    @XmlElement(name = "CardSecurityCodeResult")
    protected CardSecurityCodeResult cardSecurityCodeResult;
    @XmlElement(name = "PaymentServiceResults")
    protected CreditNetworkResultsType paymentServiceResults;
    @XmlElement(name = "Balance")
    protected BalanceType balance;
    @XmlElement(name = "WorkingKey")
    protected String workingKey;
    @XmlElement(name = "TokenizationResult")
    protected TokenizationResultType tokenizationResult;
    @XmlElement(name = "NetworkResponseCode")
    protected String networkResponseCode;

    /**
     * Gets the value of the demoMode property.
     * 
     */
    public boolean isDemoMode() {
        return demoMode;
    }

    /**
     * Sets the value of the demoMode property.
     * 
     */
    public void setDemoMode(boolean value) {
        this.demoMode = value;
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
     * Gets the value of the transactionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionStatusType }
     *     
     */
    public TransactionStatusType getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the value of the transactionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionStatusType }
     *     
     */
    public void setTransactionStatus(TransactionStatusType value) {
        this.transactionStatus = value;
    }

    /**
     * Gets the value of the transmissionTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransmissionTimestamp() {
        return transmissionTimestamp;
    }

    /**
     * Sets the value of the transmissionTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransmissionTimestamp(XMLGregorianCalendar value) {
        this.transmissionTimestamp = value;
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
     * Gets the value of the julianDay property.
     * 
     */
    public int getJulianDay() {
        return julianDay;
    }

    /**
     * Sets the value of the julianDay property.
     * 
     */
    public void setJulianDay(int value) {
        this.julianDay = value;
    }

    /**
     * Gets the value of the batchNumber property.
     * 
     */
    public int getBatchNumber() {
        return batchNumber;
    }

    /**
     * Sets the value of the batchNumber property.
     * 
     */
    public void setBatchNumber(int value) {
        this.batchNumber = value;
    }

    /**
     * Gets the value of the cardCategory property.
     * 
     * @return
     *     possible object is
     *     {@link CardCategoryType }
     *     
     */
    public CardCategoryType getCardCategory() {
        return cardCategory;
    }

    /**
     * Sets the value of the cardCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardCategoryType }
     *     
     */
    public void setCardCategory(CardCategoryType value) {
        this.cardCategory = value;
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
     * Gets the value of the declineCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeclineCode() {
        return declineCode;
    }

    /**
     * Sets the value of the declineCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeclineCode(String value) {
        this.declineCode = value;
    }

    /**
     * Gets the value of the declineMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeclineMessage() {
        return declineMessage;
    }

    /**
     * Sets the value of the declineMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeclineMessage(String value) {
        this.declineMessage = value;
    }

    /**
     * Gets the value of the addressVerificationResult property.
     * 
     * @return
     *     possible object is
     *     {@link AddressVerificationResult }
     *     
     */
    public AddressVerificationResult getAddressVerificationResult() {
        return addressVerificationResult;
    }

    /**
     * Sets the value of the addressVerificationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressVerificationResult }
     *     
     */
    public void setAddressVerificationResult(AddressVerificationResult value) {
        this.addressVerificationResult = value;
    }

    /**
     * Gets the value of the cardSecurityCodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardSecurityCodeResult }
     *     
     */
    public CardSecurityCodeResult getCardSecurityCodeResult() {
        return cardSecurityCodeResult;
    }

    /**
     * Sets the value of the cardSecurityCodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardSecurityCodeResult }
     *     
     */
    public void setCardSecurityCodeResult(CardSecurityCodeResult value) {
        this.cardSecurityCodeResult = value;
    }

    /**
     * Gets the value of the paymentServiceResults property.
     * 
     * @return
     *     possible object is
     *     {@link CreditNetworkResultsType }
     *     
     */
    public CreditNetworkResultsType getPaymentServiceResults() {
        return paymentServiceResults;
    }

    /**
     * Sets the value of the paymentServiceResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditNetworkResultsType }
     *     
     */
    public void setPaymentServiceResults(CreditNetworkResultsType value) {
        this.paymentServiceResults = value;
    }

    /**
     * Gets the value of the balance property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceType }
     *     
     */
    public BalanceType getBalance() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceType }
     *     
     */
    public void setBalance(BalanceType value) {
        this.balance = value;
    }

    /**
     * Gets the value of the workingKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkingKey() {
        return workingKey;
    }

    /**
     * Sets the value of the workingKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkingKey(String value) {
        this.workingKey = value;
    }

    /**
     * Gets the value of the tokenizationResult property.
     * 
     * @return
     *     possible object is
     *     {@link TokenizationResultType }
     *     
     */
    public TokenizationResultType getTokenizationResult() {
        return tokenizationResult;
    }

    /**
     * Sets the value of the tokenizationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenizationResultType }
     *     
     */
    public void setTokenizationResult(TokenizationResultType value) {
        this.tokenizationResult = value;
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

}
