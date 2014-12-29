
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreditNetworkResultsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditNetworkResultsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="CardResultsType" type="{urn:com:vantiv:types:payment:transactions:v6}CardResultsType"/>
 *           &lt;element name="PosaResults" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="MasterCardResults" type="{urn:com:vantiv:types:payment:transactions:v6}MasterCardResultsType"/>
 *           &lt;element name="VisaResults" type="{urn:com:vantiv:types:payment:transactions:v6}VisaResultsType"/>
 *           &lt;element name="DiscoverResults" type="{urn:com:vantiv:types:payment:transactions:v6}DiscoverCardResultsType"/>
 *           &lt;element name="AmericanExpressResults" type="{urn:com:vantiv:types:payment:transactions:v6}AmericanExpressResultsType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditNetworkResultsType", propOrder = {
    "cardResultsType",
    "posaResults",
    "masterCardResults",
    "visaResults",
    "discoverResults",
    "americanExpressResults"
})
public class CreditNetworkResultsType {

    @XmlElement(name = "CardResultsType")
    protected CardResultsType cardResultsType;
    @XmlElement(name = "PosaResults")
    protected String posaResults;
    @XmlElement(name = "MasterCardResults")
    protected MasterCardResultsType masterCardResults;
    @XmlElement(name = "VisaResults")
    protected VisaResultsType visaResults;
    @XmlElement(name = "DiscoverResults")
    protected DiscoverCardResultsType discoverResults;
    @XmlElement(name = "AmericanExpressResults")
    protected AmericanExpressResultsType americanExpressResults;

    /**
     * Gets the value of the cardResultsType property.
     * 
     * @return
     *     possible object is
     *     {@link CardResultsType }
     *     
     */
    public CardResultsType getCardResultsType() {
        return cardResultsType;
    }

    /**
     * Sets the value of the cardResultsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardResultsType }
     *     
     */
    public void setCardResultsType(CardResultsType value) {
        this.cardResultsType = value;
    }

    /**
     * Gets the value of the posaResults property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosaResults() {
        return posaResults;
    }

    /**
     * Sets the value of the posaResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosaResults(String value) {
        this.posaResults = value;
    }

    /**
     * Gets the value of the masterCardResults property.
     * 
     * @return
     *     possible object is
     *     {@link MasterCardResultsType }
     *     
     */
    public MasterCardResultsType getMasterCardResults() {
        return masterCardResults;
    }

    /**
     * Sets the value of the masterCardResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link MasterCardResultsType }
     *     
     */
    public void setMasterCardResults(MasterCardResultsType value) {
        this.masterCardResults = value;
    }

    /**
     * Gets the value of the visaResults property.
     * 
     * @return
     *     possible object is
     *     {@link VisaResultsType }
     *     
     */
    public VisaResultsType getVisaResults() {
        return visaResults;
    }

    /**
     * Sets the value of the visaResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link VisaResultsType }
     *     
     */
    public void setVisaResults(VisaResultsType value) {
        this.visaResults = value;
    }

    /**
     * Gets the value of the discoverResults property.
     * 
     * @return
     *     possible object is
     *     {@link DiscoverCardResultsType }
     *     
     */
    public DiscoverCardResultsType getDiscoverResults() {
        return discoverResults;
    }

    /**
     * Sets the value of the discoverResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscoverCardResultsType }
     *     
     */
    public void setDiscoverResults(DiscoverCardResultsType value) {
        this.discoverResults = value;
    }

    /**
     * Gets the value of the americanExpressResults property.
     * 
     * @return
     *     possible object is
     *     {@link AmericanExpressResultsType }
     *     
     */
    public AmericanExpressResultsType getAmericanExpressResults() {
        return americanExpressResults;
    }

    /**
     * Sets the value of the americanExpressResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmericanExpressResultsType }
     *     
     */
    public void setAmericanExpressResults(AmericanExpressResultsType value) {
        this.americanExpressResults = value;
    }

}
