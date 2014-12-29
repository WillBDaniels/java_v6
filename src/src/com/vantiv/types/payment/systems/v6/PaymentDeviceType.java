
package com.vantiv.types.payment.systems.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentDeviceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentDeviceType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:systems:v6}PaymentApplicationType">
 *       &lt;sequence>
 *         &lt;element name="Classification" type="{urn:com:vantiv:types:payment:systems:v6}TerminalClassificationType" minOccurs="0"/>
 *         &lt;element name="EntryMode" type="{urn:com:vantiv:types:payment:systems:v6}EntryModeType"/>
 *         &lt;element name="CardReader" type="{urn:com:vantiv:types:payment:systems:v6}CardReaderType" minOccurs="0"/>
 *         &lt;element name="PinEntry" type="{urn:com:vantiv:types:payment:systems:v6}PinEntryType" minOccurs="0"/>
 *         &lt;element name="BalanceInquiry" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="HostAdjustment" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentDeviceType", propOrder = {
    "classification",
    "entryMode",
    "cardReader",
    "pinEntry",
    "balanceInquiry",
    "hostAdjustment"
})
@XmlSeeAlso({
    MobileDeviceType.class
})
public class PaymentDeviceType
    extends PaymentApplicationType
{

    @XmlElement(name = "Classification")
    @XmlSchemaType(name = "string")
    protected TerminalClassificationType classification;
    @XmlElement(name = "EntryMode", required = true)
    @XmlSchemaType(name = "string")
    protected EntryModeType entryMode;
    @XmlElement(name = "CardReader")
    @XmlSchemaType(name = "string")
    protected CardReaderType cardReader;
    @XmlElement(name = "PinEntry")
    @XmlSchemaType(name = "string")
    protected PinEntryType pinEntry;
    @XmlElement(name = "BalanceInquiry")
    protected Boolean balanceInquiry;
    @XmlElement(name = "HostAdjustment")
    protected Boolean hostAdjustment;

    /**
     * Gets the value of the classification property.
     * 
     * @return
     *     possible object is
     *     {@link TerminalClassificationType }
     *     
     */
    public TerminalClassificationType getClassification() {
        return classification;
    }

    /**
     * Sets the value of the classification property.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminalClassificationType }
     *     
     */
    public void setClassification(TerminalClassificationType value) {
        this.classification = value;
    }

    /**
     * Gets the value of the entryMode property.
     * 
     * @return
     *     possible object is
     *     {@link EntryModeType }
     *     
     */
    public EntryModeType getEntryMode() {
        return entryMode;
    }

    /**
     * Sets the value of the entryMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntryModeType }
     *     
     */
    public void setEntryMode(EntryModeType value) {
        this.entryMode = value;
    }

    /**
     * Gets the value of the cardReader property.
     * 
     * @return
     *     possible object is
     *     {@link CardReaderType }
     *     
     */
    public CardReaderType getCardReader() {
        return cardReader;
    }

    /**
     * Sets the value of the cardReader property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardReaderType }
     *     
     */
    public void setCardReader(CardReaderType value) {
        this.cardReader = value;
    }

    /**
     * Gets the value of the pinEntry property.
     * 
     * @return
     *     possible object is
     *     {@link PinEntryType }
     *     
     */
    public PinEntryType getPinEntry() {
        return pinEntry;
    }

    /**
     * Sets the value of the pinEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link PinEntryType }
     *     
     */
    public void setPinEntry(PinEntryType value) {
        this.pinEntry = value;
    }

    /**
     * Gets the value of the balanceInquiry property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBalanceInquiry() {
        return balanceInquiry;
    }

    /**
     * Sets the value of the balanceInquiry property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBalanceInquiry(Boolean value) {
        this.balanceInquiry = value;
    }

    /**
     * Gets the value of the hostAdjustment property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHostAdjustment() {
        return hostAdjustment;
    }

    /**
     * Sets the value of the hostAdjustment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHostAdjustment(Boolean value) {
        this.hostAdjustment = value;
    }

}
