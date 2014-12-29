
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BillPaymentPayeeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BillPaymentPayeeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PayeeName" type="{urn:com:vantiv:types:common:v6}String25" minOccurs="0"/>
 *         &lt;element name="PayeePhoneNumber" type="{urn:com:vantiv:types:common:v6}String25" minOccurs="0"/>
 *         &lt;element name="PayeeAccountNumber" type="{urn:com:vantiv:types:common:v6}String25" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillPaymentPayeeType", propOrder = {
    "payeeName",
    "payeePhoneNumber",
    "payeeAccountNumber"
})
public class BillPaymentPayeeType {

    @XmlElement(name = "PayeeName")
    protected String payeeName;
    @XmlElement(name = "PayeePhoneNumber")
    protected String payeePhoneNumber;
    @XmlElement(name = "PayeeAccountNumber")
    protected String payeeAccountNumber;

    /**
     * Gets the value of the payeeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayeeName() {
        return payeeName;
    }

    /**
     * Sets the value of the payeeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayeeName(String value) {
        this.payeeName = value;
    }

    /**
     * Gets the value of the payeePhoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayeePhoneNumber() {
        return payeePhoneNumber;
    }

    /**
     * Sets the value of the payeePhoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayeePhoneNumber(String value) {
        this.payeePhoneNumber = value;
    }

    /**
     * Gets the value of the payeeAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayeeAccountNumber() {
        return payeeAccountNumber;
    }

    /**
     * Sets the value of the payeeAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayeeAccountNumber(String value) {
        this.payeeAccountNumber = value;
    }

}
