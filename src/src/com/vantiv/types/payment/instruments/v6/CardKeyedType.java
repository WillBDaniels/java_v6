
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.vantiv.types.common.v6.EncryptedData;


/**
 * Data Elements required for Card Not Present transactions
 * 
 * <p>Java class for CardKeyedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardKeyedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:com:vantiv:types:payment:instruments:v6}PanOrTokenGroup"/>
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" minOccurs="0"/>
 *         &lt;element name="CardSecurityCode" type="{urn:com:vantiv:types:payment:instruments:v6}CardSecurityCodeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardKeyedType", propOrder = {
    "primaryAccountNumber",
    "encryptedPrimaryAccountNumber",
    "token",
    "expirationDate",
    "cardSecurityCode"
})
@XmlSeeAlso({
    CreditOrDebitCardKeyedType.class,
    GiftCardKeyedType.class
})
public abstract class CardKeyedType {

    @XmlElement(name = "PrimaryAccountNumber")
    protected String primaryAccountNumber;
    @XmlElement(name = "EncryptedPrimaryAccountNumber")
    protected EncryptedData encryptedPrimaryAccountNumber;
    @XmlElement(name = "Token")
    protected TokenType token;
    @XmlElement(name = "ExpirationDate")
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar expirationDate;
    @XmlElement(name = "CardSecurityCode")
    protected String cardSecurityCode;

    /**
     * Gets the value of the primaryAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryAccountNumber() {
        return primaryAccountNumber;
    }

    /**
     * Sets the value of the primaryAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryAccountNumber(String value) {
        this.primaryAccountNumber = value;
    }

    /**
     * Gets the value of the encryptedPrimaryAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link EncryptedData }
     *     
     */
    public EncryptedData getEncryptedPrimaryAccountNumber() {
        return encryptedPrimaryAccountNumber;
    }

    /**
     * Sets the value of the encryptedPrimaryAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link EncryptedData }
     *     
     */
    public void setEncryptedPrimaryAccountNumber(EncryptedData value) {
        this.encryptedPrimaryAccountNumber = value;
    }

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link TokenType }
     *     
     */
    public TokenType getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenType }
     *     
     */
    public void setToken(TokenType value) {
        this.token = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the cardSecurityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardSecurityCode() {
        return cardSecurityCode;
    }

    /**
     * Sets the value of the cardSecurityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardSecurityCode(String value) {
        this.cardSecurityCode = value;
    }

}
