
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TokenType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TokenType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tokenId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tokenValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TokenType", propOrder = {
    "tokenId",
    "tokenValue"
})
public class TokenType {

    protected String tokenId;
    @XmlElement(required = true)
    protected String tokenValue;

    /**
     * Gets the value of the tokenId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenId() {
        return tokenId;
    }

    /**
     * Sets the value of the tokenId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenId(String value) {
        this.tokenId = value;
    }

    /**
     * Gets the value of the tokenValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenValue() {
        return tokenValue;
    }

    /**
     * Sets the value of the tokenValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenValue(String value) {
        this.tokenValue = value;
    }

}
