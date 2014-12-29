
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Batch Balance Transaction Response
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}BatchResponseType">
 *       &lt;sequence>
 *         &lt;element name="Details">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="Activate" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
 *                   &lt;element name="Purchase" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
 *                   &lt;element name="Refund" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
 *                   &lt;element name="Reload" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
 *                   &lt;element name="Unload" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
 *                   &lt;element name="Close" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
 *                   &lt;element name="Inquiry" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "details"
})
@XmlRootElement(name = "BatchBalanceResponse")
public class BatchBalanceResponse
    extends BatchResponseType
{

    @XmlElement(name = "Details", required = true)
    protected BatchBalanceResponse.Details details;

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link BatchBalanceResponse.Details }
     *     
     */
    public BatchBalanceResponse.Details getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchBalanceResponse.Details }
     *     
     */
    public void setDetails(BatchBalanceResponse.Details value) {
        this.details = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="Activate" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
     *         &lt;element name="Purchase" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
     *         &lt;element name="Refund" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
     *         &lt;element name="Reload" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
     *         &lt;element name="Unload" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
     *         &lt;element name="Close" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
     *         &lt;element name="Inquiry" type="{urn:com:vantiv:types:payment:transactions:v6}BalanceEntry" minOccurs="0"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class Details {

        @XmlElement(name = "Activate")
        protected BalanceEntry activate;
        @XmlElement(name = "Purchase")
        protected BalanceEntry purchase;
        @XmlElement(name = "Refund")
        protected BalanceEntry refund;
        @XmlElement(name = "Reload")
        protected BalanceEntry reload;
        @XmlElement(name = "Unload")
        protected BalanceEntry unload;
        @XmlElement(name = "Close")
        protected BalanceEntry close;
        @XmlElement(name = "Inquiry")
        protected BalanceEntry inquiry;

        /**
         * Gets the value of the activate property.
         * 
         * @return
         *     possible object is
         *     {@link BalanceEntry }
         *     
         */
        public BalanceEntry getActivate() {
            return activate;
        }

        /**
         * Sets the value of the activate property.
         * 
         * @param value
         *     allowed object is
         *     {@link BalanceEntry }
         *     
         */
        public void setActivate(BalanceEntry value) {
            this.activate = value;
        }

        /**
         * Gets the value of the purchase property.
         * 
         * @return
         *     possible object is
         *     {@link BalanceEntry }
         *     
         */
        public BalanceEntry getPurchase() {
            return purchase;
        }

        /**
         * Sets the value of the purchase property.
         * 
         * @param value
         *     allowed object is
         *     {@link BalanceEntry }
         *     
         */
        public void setPurchase(BalanceEntry value) {
            this.purchase = value;
        }

        /**
         * Gets the value of the refund property.
         * 
         * @return
         *     possible object is
         *     {@link BalanceEntry }
         *     
         */
        public BalanceEntry getRefund() {
            return refund;
        }

        /**
         * Sets the value of the refund property.
         * 
         * @param value
         *     allowed object is
         *     {@link BalanceEntry }
         *     
         */
        public void setRefund(BalanceEntry value) {
            this.refund = value;
        }

        /**
         * Gets the value of the reload property.
         * 
         * @return
         *     possible object is
         *     {@link BalanceEntry }
         *     
         */
        public BalanceEntry getReload() {
            return reload;
        }

        /**
         * Sets the value of the reload property.
         * 
         * @param value
         *     allowed object is
         *     {@link BalanceEntry }
         *     
         */
        public void setReload(BalanceEntry value) {
            this.reload = value;
        }

        /**
         * Gets the value of the unload property.
         * 
         * @return
         *     possible object is
         *     {@link BalanceEntry }
         *     
         */
        public BalanceEntry getUnload() {
            return unload;
        }

        /**
         * Sets the value of the unload property.
         * 
         * @param value
         *     allowed object is
         *     {@link BalanceEntry }
         *     
         */
        public void setUnload(BalanceEntry value) {
            this.unload = value;
        }

        /**
         * Gets the value of the close property.
         * 
         * @return
         *     possible object is
         *     {@link BalanceEntry }
         *     
         */
        public BalanceEntry getClose() {
            return close;
        }

        /**
         * Sets the value of the close property.
         * 
         * @param value
         *     allowed object is
         *     {@link BalanceEntry }
         *     
         */
        public void setClose(BalanceEntry value) {
            this.close = value;
        }

        /**
         * Gets the value of the inquiry property.
         * 
         * @return
         *     possible object is
         *     {@link BalanceEntry }
         *     
         */
        public BalanceEntry getInquiry() {
            return inquiry;
        }

        /**
         * Sets the value of the inquiry property.
         * 
         * @param value
         *     allowed object is
         *     {@link BalanceEntry }
         *     
         */
        public void setInquiry(BalanceEntry value) {
            this.inquiry = value;
        }

    }

}
