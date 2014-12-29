
package com.vantiv.types.payment.systems.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentApplicationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentApplicationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:com:vantiv:types:common:v6}IPAddressGroup" minOccurs="0"/>
 *         &lt;element name="TerminalID" type="{urn:com:vantiv:types:payment:systems:v6}TerminalIDType"/>
 *         &lt;element name="SequenceNumber" type="{urn:com:vantiv:types:payment:systems:v6}SequenceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentApplicationType", propOrder = {
    "iPv4Address",
    "iPv6Address",
    "terminalID",
    "sequenceNumber"
})
@XmlSeeAlso({
    PaymentDeviceType.class
})
public class PaymentApplicationType {

    @XmlElement(name = "IPv4Address", namespace = "urn:com:vantiv:types:common:v6")
    protected String iPv4Address;
    @XmlElement(name = "IPv6Address", namespace = "urn:com:vantiv:types:common:v6")
    protected String iPv6Address;
    @XmlElement(name = "TerminalID")
    protected int terminalID;
    @XmlElement(name = "SequenceNumber")
    protected String sequenceNumber;

    /**
     * Gets the value of the iPv4Address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPv4Address() {
        return iPv4Address;
    }

    /**
     * Sets the value of the iPv4Address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPv4Address(String value) {
        this.iPv4Address = value;
    }

    /**
     * Gets the value of the iPv6Address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPv6Address() {
        return iPv6Address;
    }

    /**
     * Sets the value of the iPv6Address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPv6Address(String value) {
        this.iPv6Address = value;
    }

    /**
     * Gets the value of the terminalID property.
     * 
     */
    public int getTerminalID() {
        return terminalID;
    }

    /**
     * Sets the value of the terminalID property.
     * 
     */
    public void setTerminalID(int value) {
        this.terminalID = value;
    }

    /**
     * Gets the value of the sequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the value of the sequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSequenceNumber(String value) {
        this.sequenceNumber = value;
    }

}
