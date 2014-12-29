
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.vantiv.types.payment.instruments.v6.TokenType;


/**
 * Results from tokenization.
 * 
 * <p>
 * Java class for TokenizationResultType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="TokenizationResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="successful" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="tokenType" type="{urn:com:vantiv:types:payment:instruments:v6}TokenType"/>
 *         &lt;element name="Last4digit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TokenizationResultType", propOrder = {
    "successful",
		"tokenType", "Last4digit"
})
public class TokenizationResultType {

	protected String Last4digit;
    protected boolean successful;
    @XmlElement(required = true)
    protected TokenType tokenType;

    /**
     * Gets the value of the successful property.
     * 
     */
    public boolean isSuccessful() {
        return successful;
    }

	public String isLast4digit() {
		return Last4digit;
	}

	public void setLast4digits(String last4digit) {
		this.Last4digit = last4digit;
	}

	/**
	 * Sets the value of the successful property.
	 * 
	 */
    public void setSuccessful(boolean value) {
        this.successful = value;
    }

    /**
     * Gets the value of the tokenType property.
     * 
     * @return
     *     possible object is
     *     {@link TokenType }
     *     
     */
    public TokenType getTokenType() {
        return tokenType;
    }

    /**
     * Sets the value of the tokenType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenType }
     *     
     */
    public void setTokenType(TokenType value) {
        this.tokenType = value;
    }

}
