
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 *                 Data element that holds information on incremental authorization transactions.
 *                 Transaction value is the amount to add to the original authorization or the initial amount in the
 *                 original authorization.
 *             
 * 
 * <p>Java class for IncrementalAuthorizationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IncrementalAuthorizationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="OriginalTransactionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;sequence>
 *             &lt;element name="BankNetReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *             &lt;element name="BankNetSettlementDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element name="Industry" type="{urn:com:vantiv:types:payment:transactions:v6}IncrementalIndustryType"/>
 *         &lt;element name="NumberOfDays">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[0-9]+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IncrementalAuthorizationType", propOrder = {
    "originalTransactionId",
    "bankNetReferenceNumber",
    "bankNetSettlementDate",
    "industry",
    "numberOfDays"
})
public class IncrementalAuthorizationType {

    @XmlElement(name = "OriginalTransactionId")
    protected String originalTransactionId;
    @XmlElement(name = "BankNetReferenceNumber")
    protected String bankNetReferenceNumber;
    @XmlElement(name = "BankNetSettlementDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar bankNetSettlementDate;
    @XmlElement(name = "Industry", required = true)
    @XmlSchemaType(name = "string")
    protected IncrementalIndustryType industry;
    @XmlElement(name = "NumberOfDays", required = true)
    protected String numberOfDays;

    /**
     * Gets the value of the originalTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalTransactionId() {
        return originalTransactionId;
    }

    /**
     * Sets the value of the originalTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalTransactionId(String value) {
        this.originalTransactionId = value;
    }

    /**
     * Gets the value of the bankNetReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankNetReferenceNumber() {
        return bankNetReferenceNumber;
    }

    /**
     * Sets the value of the bankNetReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankNetReferenceNumber(String value) {
        this.bankNetReferenceNumber = value;
    }

    /**
     * Gets the value of the bankNetSettlementDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBankNetSettlementDate() {
        return bankNetSettlementDate;
    }

    /**
     * Sets the value of the bankNetSettlementDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBankNetSettlementDate(XMLGregorianCalendar value) {
        this.bankNetSettlementDate = value;
    }

    /**
     * Gets the value of the industry property.
     * 
     * @return
     *     possible object is
     *     {@link IncrementalIndustryType }
     *     
     */
    public IncrementalIndustryType getIndustry() {
        return industry;
    }

    /**
     * Sets the value of the industry property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncrementalIndustryType }
     *     
     */
    public void setIndustry(IncrementalIndustryType value) {
        this.industry = value;
    }

    /**
     * Gets the value of the numberOfDays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * Sets the value of the numberOfDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfDays(String value) {
        this.numberOfDays = value;
    }

}
