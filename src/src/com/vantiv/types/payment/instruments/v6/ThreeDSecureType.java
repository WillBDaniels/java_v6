
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 *  3D Secure Protocol
 * 
 * <p>Java class for ThreeDSecureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ThreeDSecureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransactionID" type="{urn:com:vantiv:types:common:v6}String40" minOccurs="0"/>
 *         &lt;element name="eCommerceIndicator" type="{urn:com:vantiv:types:common:v6}String1"/>
 *         &lt;element name="AuthenticationValue" type="{urn:com:vantiv:types:common:v6}String40" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ThreeDSecureType", propOrder = {
    "transactionID",
    "eCommerceIndicator",
    "authenticationValue"
})
public class ThreeDSecureType {

    @XmlElement(name = "TransactionID")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String transactionID;
    @XmlElement(required = true)
    protected String eCommerceIndicator;
    @XmlElement(name = "AuthenticationValue")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String authenticationValue;

    /**
     * Gets the value of the transactionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionID(String value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the eCommerceIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECommerceIndicator() {
        return eCommerceIndicator;
    }

    /**
     * Sets the value of the eCommerceIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECommerceIndicator(String value) {
        this.eCommerceIndicator = value;
    }

    /**
     * Gets the value of the authenticationValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthenticationValue() {
        return authenticationValue;
    }

    /**
     * Sets the value of the authenticationValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthenticationValue(String value) {
        this.authenticationValue = value;
    }

}
