
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Base Type for Batch Transaction Response
 * 
 * <p>Java class for BatchResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}PaymentResponse">
 *       &lt;sequence>
 *         &lt;element name="TransactionStatus" type="{urn:com:vantiv:types:payment:transactions:v6}TransactionStatusType"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="AuthorizationCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="DeclineCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *             &lt;element name="DeclineMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="WorkingKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Summary" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchResponseType", propOrder = {
    "transactionStatus",
    "authorizationCode",
    "declineCode",
    "declineMessage",
    "workingKey",
    "summary"
})
@XmlSeeAlso({
    CloseBatchResponse.class,
    BatchBalanceResponse.class
})
public abstract class BatchResponseType
    extends PaymentResponse
{

    @XmlElement(name = "TransactionStatus", required = true)
    @XmlSchemaType(name = "string")
    protected TransactionStatusType transactionStatus;
    @XmlElement(name = "AuthorizationCode")
    protected String authorizationCode;
    @XmlElement(name = "DeclineCode")
    protected String declineCode;
    @XmlElement(name = "DeclineMessage")
    protected String declineMessage;
    @XmlElement(name = "WorkingKey")
    protected String workingKey;
    @XmlElement(name = "Summary")
    protected BalanceEntry summary;

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
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceEntry }
     *     
     */
    public BalanceEntry getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceEntry }
     *     
     */
    public void setSummary(BalanceEntry value) {
        this.summary = value;
    }

}
