
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.vantiv.types.payment.instruments.v6.CreditInstrumentType;


/**
 * Update Card Request
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}TransactionRequestType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="Credit" type="{urn:com:vantiv:types:payment:instruments:v6}CreditInstrumentType"/>
 *         &lt;/choice>
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
    "credit"
})
@XmlRootElement(name = "UpdateCardRequest")
public class UpdateCardRequest
    extends TransactionRequestType
{

    @XmlElement(name = "Credit")
    protected CreditInstrumentType credit;

    /**
     * Gets the value of the credit property.
     * 
     * @return
     *     possible object is
     *     {@link CreditInstrumentType }
     *     
     */
    public CreditInstrumentType getCredit() {
        return credit;
    }

    /**
     * Sets the value of the credit property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditInstrumentType }
     *     
     */
    public void setCredit(CreditInstrumentType value) {
        this.credit = value;
    }

}
