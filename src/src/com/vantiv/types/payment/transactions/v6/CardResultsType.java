
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardResultsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardResultsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValidationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthorizationCharacteristicsIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardResultsType", propOrder = {
    "transactionId",
    "validationCode",
    "authorizationCharacteristicsIndicator"
})
@XmlSeeAlso({
    VisaResultsType.class,
    MasterCardResultsType.class,
    AmericanExpressResultsType.class,
    DiscoverCardResultsType.class
})
public class CardResultsType {

    @XmlElement(name = "TransactionId")
    protected String transactionId;
    @XmlElement(name = "ValidationCode")
    protected String validationCode;
    @XmlElement(name = "AuthorizationCharacteristicsIndicator")
    protected String authorizationCharacteristicsIndicator;

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

    /**
     * Gets the value of the validationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidationCode() {
        return validationCode;
    }

    /**
     * Sets the value of the validationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidationCode(String value) {
        this.validationCode = value;
    }

    /**
     * Gets the value of the authorizationCharacteristicsIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationCharacteristicsIndicator() {
        return authorizationCharacteristicsIndicator;
    }

    /**
     * Sets the value of the authorizationCharacteristicsIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationCharacteristicsIndicator(String value) {
        this.authorizationCharacteristicsIndicator = value;
    }

}
