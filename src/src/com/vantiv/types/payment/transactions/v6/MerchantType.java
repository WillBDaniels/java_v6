
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.vantiv.types.payment.systems.v6.MobileDeviceType;
import com.vantiv.types.payment.systems.v6.PaymentDeviceType;


/**
 * <p>Java class for MerchantType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MerchantType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MerchantId" type="{urn:com:vantiv:types:payment:transactions:v6}MerchantIdType"/>
 *         &lt;element name="NetworkRouting" type="{urn:com:vantiv:types:payment:transactions:v6}NetworkRoutingType" minOccurs="0"/>
 *         &lt;element name="MerchantName" type="{urn:com:vantiv:types:common:v6}String20" minOccurs="0"/>
 *         &lt;element name="ClerkNumber" type="{urn:com:vantiv:types:payment:transactions:v6}ClerkType" minOccurs="0"/>
 *         &lt;element name="CashierNumber" type="{urn:com:vantiv:types:common:v6}Number8" minOccurs="0"/>
 *         &lt;element name="LaneNumber" type="{urn:com:vantiv:types:common:v6}AlphanumericStringType" minOccurs="0"/>
 *         &lt;element name="DivisionNumber" type="{urn:com:vantiv:types:common:v6}AlphanumericStringType" minOccurs="0"/>
 *         &lt;element name="ChainCode" type="{urn:com:vantiv:types:common:v6}AlphanumericStringType" minOccurs="0"/>
 *         &lt;element name="StoreNumber" type="{urn:com:vantiv:types:common:v6}AlphanumericStringType" minOccurs="0"/>
 *         &lt;group ref="{urn:com:vantiv:types:payment:systems:v6}PaymentSystemGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MerchantType", propOrder = {
    "merchantId",
    "networkRouting",
    "merchantName",
    "clerkNumber",
    "cashierNumber",
    "laneNumber",
    "divisionNumber",
    "chainCode",
    "storeNumber",
    "software",
    "mobile",
    "terminal"
})
public class MerchantType {

    @XmlElement(name = "MerchantId", required = true)
    protected String merchantId;
    @XmlElement(name = "NetworkRouting")
    protected String networkRouting;
    @XmlElement(name = "MerchantName")
    protected String merchantName;
    @XmlElement(name = "ClerkNumber")
    protected Integer clerkNumber;
    @XmlElement(name = "CashierNumber")
    protected Integer cashierNumber;
    @XmlElement(name = "LaneNumber")
    protected String laneNumber;
    @XmlElement(name = "DivisionNumber")
    protected String divisionNumber;
    @XmlElement(name = "ChainCode")
    protected String chainCode;
    @XmlElement(name = "StoreNumber")
    protected String storeNumber;
    @XmlElement(name = "Software", namespace = "urn:com:vantiv:types:payment:systems:v6")
    protected PaymentDeviceType software;
    @XmlElement(name = "Mobile", namespace = "urn:com:vantiv:types:payment:systems:v6")
    protected MobileDeviceType mobile;
    @XmlElement(name = "Terminal", namespace = "urn:com:vantiv:types:payment:systems:v6")
    protected PaymentDeviceType terminal;

    /**
     * Gets the value of the merchantId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Sets the value of the merchantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantId(String value) {
        this.merchantId = value;
    }

    /**
     * Gets the value of the networkRouting property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetworkRouting() {
        return networkRouting;
    }

    /**
     * Sets the value of the networkRouting property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetworkRouting(String value) {
        this.networkRouting = value;
    }

    /**
     * Gets the value of the merchantName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * Sets the value of the merchantName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantName(String value) {
        this.merchantName = value;
    }

    /**
     * Gets the value of the clerkNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getClerkNumber() {
        return clerkNumber;
    }

    /**
     * Sets the value of the clerkNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setClerkNumber(Integer value) {
        this.clerkNumber = value;
    }

    /**
     * Gets the value of the cashierNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCashierNumber() {
        return cashierNumber;
    }

    /**
     * Sets the value of the cashierNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCashierNumber(Integer value) {
        this.cashierNumber = value;
    }

    /**
     * Gets the value of the laneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaneNumber() {
        return laneNumber;
    }

    /**
     * Sets the value of the laneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaneNumber(String value) {
        this.laneNumber = value;
    }

    /**
     * Gets the value of the divisionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDivisionNumber() {
        return divisionNumber;
    }

    /**
     * Sets the value of the divisionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDivisionNumber(String value) {
        this.divisionNumber = value;
    }

    /**
     * Gets the value of the chainCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChainCode() {
        return chainCode;
    }

    /**
     * Sets the value of the chainCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChainCode(String value) {
        this.chainCode = value;
    }

    /**
     * Gets the value of the storeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoreNumber() {
        return storeNumber;
    }

    /**
     * Sets the value of the storeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoreNumber(String value) {
        this.storeNumber = value;
    }

    /**
     * Gets the value of the software property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentDeviceType }
     *     
     */
    public PaymentDeviceType getSoftware() {
        return software;
    }

    /**
     * Sets the value of the software property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDeviceType }
     *     
     */
    public void setSoftware(PaymentDeviceType value) {
        this.software = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link MobileDeviceType }
     *     
     */
    public MobileDeviceType getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link MobileDeviceType }
     *     
     */
    public void setMobile(MobileDeviceType value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the terminal property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentDeviceType }
     *     
     */
    public PaymentDeviceType getTerminal() {
        return terminal;
    }

    /**
     * Sets the value of the terminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDeviceType }
     *     
     */
    public void setTerminal(PaymentDeviceType value) {
        this.terminal = value;
    }



}
