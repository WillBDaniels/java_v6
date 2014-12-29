
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Base Type for Payment Requests
 * 
 * <p>Java class for PaymentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="system-trace-id" type="{urn:com:vantiv:types:payment:transactions:v6}SystemTraceType" />
 *       &lt;attribute name="merchant-ref-id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentRequest")
@XmlSeeAlso({
    BatchRequestType.class,
    TransactionRequestType.class
})
public abstract class PaymentRequest {

    @XmlAttribute(name = "system-trace-id")
    protected Long systemTraceId;
    @XmlAttribute(name = "merchant-ref-id")
    protected String merchantRefId;

    /**
     * Gets the value of the systemTraceId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSystemTraceId() {
        return systemTraceId;
    }

    /**
     * Sets the value of the systemTraceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSystemTraceId(Long value) {
        this.systemTraceId = value;
    }

    /**
     * Gets the value of the merchantRefId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantRefId() {
        return merchantRefId;
    }

    /**
     * Sets the value of the merchantRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantRefId(String value) {
        this.merchantRefId = value;
    }

}
