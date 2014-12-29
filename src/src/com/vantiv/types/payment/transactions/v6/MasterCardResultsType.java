
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for MasterCardResultsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MasterCardResultsType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}CardResultsType">
 *       &lt;sequence>
 *         &lt;element name="BanknetDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="BanknetReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BanknetErrorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CvcValidity" type="{urn:com:vantiv:types:payment:transactions:v6}MasterCardCvcValidityType" minOccurs="0"/>
 *         &lt;element name="Category" type="{urn:com:vantiv:types:payment:transactions:v6}MasterCardCategoryType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MasterCardResultsType", propOrder = {
    "banknetDate",
    "banknetReference",
    "banknetErrorCode",
    "cvcValidity",
    "category"
})
public class MasterCardResultsType
    extends CardResultsType
{

    @XmlElement(name = "BanknetDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar banknetDate;
    @XmlElement(name = "BanknetReference")
    protected String banknetReference;
    @XmlElement(name = "BanknetErrorCode")
    protected String banknetErrorCode;
    @XmlElement(name = "CvcValidity")
    @XmlSchemaType(name = "string")
    protected MasterCardCvcValidityType cvcValidity;
    @XmlElement(name = "Category")
    @XmlSchemaType(name = "string")
    protected MasterCardCategoryType category;

    /**
     * Gets the value of the banknetDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBanknetDate() {
        return banknetDate;
    }

    /**
     * Sets the value of the banknetDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBanknetDate(XMLGregorianCalendar value) {
        this.banknetDate = value;
    }

    /**
     * Gets the value of the banknetReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBanknetReference() {
        return banknetReference;
    }

    /**
     * Sets the value of the banknetReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBanknetReference(String value) {
        this.banknetReference = value;
    }

    /**
     * Gets the value of the banknetErrorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBanknetErrorCode() {
        return banknetErrorCode;
    }

    /**
     * Sets the value of the banknetErrorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBanknetErrorCode(String value) {
        this.banknetErrorCode = value;
    }

    /**
     * Gets the value of the cvcValidity property.
     * 
     * @return
     *     possible object is
     *     {@link MasterCardCvcValidityType }
     *     
     */
    public MasterCardCvcValidityType getCvcValidity() {
        return cvcValidity;
    }

    /**
     * Sets the value of the cvcValidity property.
     * 
     * @param value
     *     allowed object is
     *     {@link MasterCardCvcValidityType }
     *     
     */
    public void setCvcValidity(MasterCardCvcValidityType value) {
        this.cvcValidity = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link MasterCardCategoryType }
     *     
     */
    public MasterCardCategoryType getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link MasterCardCategoryType }
     *     
     */
    public void setCategory(MasterCardCategoryType value) {
        this.category = value;
    }

}
