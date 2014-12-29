
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DiscoverCardResultsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiscoverCardResultsType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}CardResultsType">
 *       &lt;sequence>
 *         &lt;element name="NetworkReferenceId" type="{urn:com:vantiv:types:common:v6}String15" minOccurs="0"/>
 *         &lt;element name="ProcessingCode" type="{urn:com:vantiv:types:common:v6}String6" minOccurs="0"/>
 *         &lt;element name="SystemTraceAuditNumber" type="{urn:com:vantiv:types:common:v6}String6" minOccurs="0"/>
 *         &lt;element name="POSEntryMode" type="{urn:com:vantiv:types:common:v6}String2" minOccurs="0"/>
 *         &lt;element name="PINCapability" type="{urn:com:vantiv:types:common:v6}String1" minOccurs="0"/>
 *         &lt;element name="TrackIIStatus" type="{urn:com:vantiv:types:common:v6}String2" minOccurs="0"/>
 *         &lt;element name="POSData" type="{urn:com:vantiv:types:common:v6}String13" minOccurs="0"/>
 *         &lt;element name="ResponseCode" type="{urn:com:vantiv:types:common:v6}String2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiscoverCardResultsType", propOrder = {
    "networkReferenceId",
    "processingCode",
    "systemTraceAuditNumber",
    "posEntryMode",
    "pinCapability",
    "trackIIStatus",
    "posData",
    "responseCode"
})
public class DiscoverCardResultsType
    extends CardResultsType
{

    @XmlElement(name = "NetworkReferenceId")
    protected String networkReferenceId;
    @XmlElement(name = "ProcessingCode")
    protected String processingCode;
    @XmlElement(name = "SystemTraceAuditNumber")
    protected String systemTraceAuditNumber;
    @XmlElement(name = "POSEntryMode")
    protected String posEntryMode;
    @XmlElement(name = "PINCapability")
    protected String pinCapability;
    @XmlElement(name = "TrackIIStatus")
    protected String trackIIStatus;
    @XmlElement(name = "POSData")
    protected String posData;
    @XmlElement(name = "ResponseCode")
    protected String responseCode;

    /**
     * Gets the value of the networkReferenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetworkReferenceId() {
        return networkReferenceId;
    }

    /**
     * Sets the value of the networkReferenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetworkReferenceId(String value) {
        this.networkReferenceId = value;
    }

    /**
     * Gets the value of the processingCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessingCode() {
        return processingCode;
    }

    /**
     * Sets the value of the processingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessingCode(String value) {
        this.processingCode = value;
    }

    /**
     * Gets the value of the systemTraceAuditNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemTraceAuditNumber() {
        return systemTraceAuditNumber;
    }

    /**
     * Sets the value of the systemTraceAuditNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemTraceAuditNumber(String value) {
        this.systemTraceAuditNumber = value;
    }

    /**
     * Gets the value of the posEntryMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSEntryMode() {
        return posEntryMode;
    }

    /**
     * Sets the value of the posEntryMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSEntryMode(String value) {
        this.posEntryMode = value;
    }

    /**
     * Gets the value of the pinCapability property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPINCapability() {
        return pinCapability;
    }

    /**
     * Sets the value of the pinCapability property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPINCapability(String value) {
        this.pinCapability = value;
    }

    /**
     * Gets the value of the trackIIStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackIIStatus() {
        return trackIIStatus;
    }

    /**
     * Sets the value of the trackIIStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackIIStatus(String value) {
        this.trackIIStatus = value;
    }

    /**
     * Gets the value of the posData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSData() {
        return posData;
    }

    /**
     * Sets the value of the posData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSData(String value) {
        this.posData = value;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCode(String value) {
        this.responseCode = value;
    }

}
