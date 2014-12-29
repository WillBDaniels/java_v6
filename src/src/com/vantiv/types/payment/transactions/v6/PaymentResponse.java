
package com.vantiv.types.payment.transactions.v6;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.vantiv.types.common.v6.KeyValuePair;


/**
 * Base Type for Payment Responses
 * 
 * <p>Java class for PaymentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;group ref="{urn:com:vantiv:types:common:v6}AdditionalData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="system-trace-id" type="{urn:com:vantiv:types:payment:transactions:v6}SystemTraceType" />
 *       &lt;attribute name="merchant-ref-id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="report-group" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentResponse", propOrder = {
    "requestId",
    "additionalData"
})
@XmlSeeAlso({
    BatchResponseType.class,
    PaymentFault.class,
    TransactionResponseType.class
})
public abstract class PaymentResponse {

    @XmlElement(name = "RequestId", required = true)
    protected String requestId;
    @XmlElement(name = "keyValuePair", namespace = "urn:com:vantiv:types:common:v6")
    protected List<KeyValuePair> additionalData;
    @XmlAttribute(name = "system-trace-id")
    protected Long systemTraceId;
    @XmlAttribute(name = "merchant-ref-id")
    protected String merchantRefId;
    @XmlAttribute(name = "report-group")
    protected String reportGroup;

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the additionalData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValuePair }
     * 
     * 
     */
    public List<KeyValuePair> getAdditionalData() {
        if (additionalData == null) {
            additionalData = new ArrayList<KeyValuePair>();
        }
        return this.additionalData;
    }

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

    /**
     * Gets the value of the reportGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportGroup() {
        return reportGroup;
    }

    /**
     * Sets the value of the reportGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportGroup(String value) {
        this.reportGroup = value;
    }

}
