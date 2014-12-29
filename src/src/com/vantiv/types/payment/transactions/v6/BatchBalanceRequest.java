
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.vantiv.types.payment.instruments.v6.PaymentInstrumentType;


/**
 * Batch Balance Transaction Request
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}BatchRequestType">
 *       &lt;sequence>
 *         &lt;element name="PaymentInstrumentType" type="{urn:com:vantiv:types:payment:instruments:v6}PaymentInstrumentType"/>
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
    "paymentInstrumentType"
})
@XmlRootElement(name = "BatchBalanceRequest")
public class BatchBalanceRequest
    extends BatchRequestType
{

    @XmlElement(name = "PaymentInstrumentType", required = true)
    @XmlSchemaType(name = "string")
    protected PaymentInstrumentType paymentInstrumentType;

    /**
     * Gets the value of the paymentInstrumentType property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentInstrumentType }
     *     
     */
    public PaymentInstrumentType getPaymentInstrumentType() {
        return paymentInstrumentType;
    }

    /**
     * Sets the value of the paymentInstrumentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInstrumentType }
     *     
     */
    public void setPaymentInstrumentType(PaymentInstrumentType value) {
        this.paymentInstrumentType = value;
    }

}
