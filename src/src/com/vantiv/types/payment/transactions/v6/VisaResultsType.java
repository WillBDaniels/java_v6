
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VisaResultsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VisaResultsType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}CardResultsType">
 *       &lt;sequence>
 *         &lt;element name="Ps2000Qualification" type="{urn:com:vantiv:types:common:v6}String1" minOccurs="0"/>
 *         &lt;element name="CardLevelResultsCode" type="{urn:com:vantiv:types:common:v6}String2" minOccurs="0"/>
 *         &lt;element name="VisaMultipleClearingSequenceNumber" type="{urn:com:vantiv:types:common:v6}Number2" minOccurs="0"/>
 *         &lt;element name="VisaMultipleClearingSequenceCount" type="{urn:com:vantiv:types:common:v6}Number2" minOccurs="0"/>
 *         &lt;element name="RequestedPaymentServices" type="{urn:com:vantiv:types:common:v6}String1" minOccurs="0"/>
 *         &lt;element name="CAVVCode" type="{urn:com:vantiv:types:common:v6}String1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VisaResultsType", propOrder = {
    "ps2000Qualification",
    "cardLevelResultsCode",
    "visaMultipleClearingSequenceNumber",
    "visaMultipleClearingSequenceCount",
    "requestedPaymentServices",
    "cavvCode"
})
public class VisaResultsType
    extends CardResultsType
{

    @XmlElement(name = "Ps2000Qualification")
    protected String ps2000Qualification;
    @XmlElement(name = "CardLevelResultsCode")
    protected String cardLevelResultsCode;
    @XmlElement(name = "VisaMultipleClearingSequenceNumber")
    protected Integer visaMultipleClearingSequenceNumber;
    @XmlElement(name = "VisaMultipleClearingSequenceCount")
    protected Integer visaMultipleClearingSequenceCount;
    @XmlElement(name = "RequestedPaymentServices")
    protected String requestedPaymentServices;
    @XmlElement(name = "CAVVCode")
    protected String cavvCode;

    /**
     * Gets the value of the ps2000Qualification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPs2000Qualification() {
        return ps2000Qualification;
    }

    /**
     * Sets the value of the ps2000Qualification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPs2000Qualification(String value) {
        this.ps2000Qualification = value;
    }

    /**
     * Gets the value of the cardLevelResultsCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardLevelResultsCode() {
        return cardLevelResultsCode;
    }

    /**
     * Sets the value of the cardLevelResultsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardLevelResultsCode(String value) {
        this.cardLevelResultsCode = value;
    }

    /**
     * Gets the value of the visaMultipleClearingSequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVisaMultipleClearingSequenceNumber() {
        return visaMultipleClearingSequenceNumber;
    }

    /**
     * Sets the value of the visaMultipleClearingSequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVisaMultipleClearingSequenceNumber(Integer value) {
        this.visaMultipleClearingSequenceNumber = value;
    }

    /**
     * Gets the value of the visaMultipleClearingSequenceCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVisaMultipleClearingSequenceCount() {
        return visaMultipleClearingSequenceCount;
    }

    /**
     * Sets the value of the visaMultipleClearingSequenceCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVisaMultipleClearingSequenceCount(Integer value) {
        this.visaMultipleClearingSequenceCount = value;
    }

    /**
     * Gets the value of the requestedPaymentServices property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedPaymentServices() {
        return requestedPaymentServices;
    }

    /**
     * Sets the value of the requestedPaymentServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedPaymentServices(String value) {
        this.requestedPaymentServices = value;
    }

    /**
     * Gets the value of the cavvCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAVVCode() {
        return cavvCode;
    }

    /**
     * Sets the value of the cavvCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAVVCode(String value) {
        this.cavvCode = value;
    }

}
