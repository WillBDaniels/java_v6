
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.vantiv.types.common.v6.BalanceAmountType;


/**
 * A list of Additional Amounts returned by the payment service
 *             
 * 
 * <p>Java class for BalanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BalanceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BeginningBalance" type="{urn:com:vantiv:types:common:v6}BalanceAmountType" minOccurs="0"/>
 *         &lt;element name="EndingBalance" type="{urn:com:vantiv:types:common:v6}BalanceAmountType" minOccurs="0"/>
 *         &lt;element name="AvailableBalance" type="{urn:com:vantiv:types:common:v6}BalanceAmountType" minOccurs="0"/>
 *         &lt;element name="Authorized" type="{urn:com:vantiv:types:common:v6}BalanceAmountType" minOccurs="0"/>
 *         &lt;element name="PreAuthorized" type="{urn:com:vantiv:types:common:v6}BalanceAmountType" minOccurs="0"/>
 *         &lt;element name="Cash" type="{urn:com:vantiv:types:common:v6}BalanceAmountType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceType", propOrder = {
    "beginningBalance",
    "endingBalance",
    "availableBalance",
    "authorized",
    "preAuthorized",
    "cash"
})
public class BalanceType {

    @XmlElement(name = "BeginningBalance")
    protected BalanceAmountType beginningBalance;
    @XmlElement(name = "EndingBalance")
    protected BalanceAmountType endingBalance;
    @XmlElement(name = "AvailableBalance")
    protected BalanceAmountType availableBalance;
    @XmlElement(name = "Authorized")
    protected BalanceAmountType authorized;
    @XmlElement(name = "PreAuthorized")
    protected BalanceAmountType preAuthorized;
    @XmlElement(name = "Cash")
    protected BalanceAmountType cash;

    /**
     * Gets the value of the beginningBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceAmountType }
     *     
     */
    public BalanceAmountType getBeginningBalance() {
        return beginningBalance;
    }

    /**
     * Sets the value of the beginningBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceAmountType }
     *     
     */
    public void setBeginningBalance(BalanceAmountType value) {
        this.beginningBalance = value;
    }

    /**
     * Gets the value of the endingBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceAmountType }
     *     
     */
    public BalanceAmountType getEndingBalance() {
        return endingBalance;
    }

    /**
     * Sets the value of the endingBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceAmountType }
     *     
     */
    public void setEndingBalance(BalanceAmountType value) {
        this.endingBalance = value;
    }

    /**
     * Gets the value of the availableBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceAmountType }
     *     
     */
    public BalanceAmountType getAvailableBalance() {
        return availableBalance;
    }

    /**
     * Sets the value of the availableBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceAmountType }
     *     
     */
    public void setAvailableBalance(BalanceAmountType value) {
        this.availableBalance = value;
    }

    /**
     * Gets the value of the authorized property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceAmountType }
     *     
     */
    public BalanceAmountType getAuthorized() {
        return authorized;
    }

    /**
     * Sets the value of the authorized property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceAmountType }
     *     
     */
    public void setAuthorized(BalanceAmountType value) {
        this.authorized = value;
    }

    /**
     * Gets the value of the preAuthorized property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceAmountType }
     *     
     */
    public BalanceAmountType getPreAuthorized() {
        return preAuthorized;
    }

    /**
     * Sets the value of the preAuthorized property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceAmountType }
     *     
     */
    public void setPreAuthorized(BalanceAmountType value) {
        this.preAuthorized = value;
    }

    /**
     * Gets the value of the cash property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceAmountType }
     *     
     */
    public BalanceAmountType getCash() {
        return cash;
    }

    /**
     * Sets the value of the cash property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceAmountType }
     *     
     */
    public void setCash(BalanceAmountType value) {
        this.cash = value;
    }

}
