
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Cancel Transaction Response
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}TransactionResponseType">
 *       &lt;sequence>
 *         &lt;element name="IncrementalAuthorization" type="{urn:com:vantiv:types:payment:transactions:v6}IncrementalAuthorizationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "incrementalAuthorization"
})
@XmlRootElement(name = "CancelResponse")
public class CancelResponse
    extends TransactionResponseType
{

    @XmlElement(name = "IncrementalAuthorization")
    protected IncrementalAuthorizationType incrementalAuthorization;

    /**
     * Gets the value of the incrementalAuthorization property.
     * 
     * @return
     *     possible object is
     *     {@link IncrementalAuthorizationType }
     *     
     */
    public IncrementalAuthorizationType getIncrementalAuthorization() {
        return incrementalAuthorization;
    }

    /**
     * Sets the value of the incrementalAuthorization property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncrementalAuthorizationType }
     *     
     */
    public void setIncrementalAuthorization(IncrementalAuthorizationType value) {
        this.incrementalAuthorization = value;
    }

}
