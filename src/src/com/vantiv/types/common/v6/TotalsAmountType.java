
package com.vantiv.types.common.v6;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Data Type for Batch Close total amounts
 * 
 * <p>Java class for TotalsAmountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TotalsAmountType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:com:vantiv:types:common:v6>Money12">
 *       &lt;attribute name="currency" type="{urn:com:vantiv:types:common:v6}ISO4217CurrencyCodeType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TotalsAmountType", propOrder = {
    "value"
})
public class TotalsAmountType {

    @XmlValue
    protected BigDecimal value;
    @XmlAttribute(name = "currency")
    protected ISO4217CurrencyCodeType currency;

    /**
     * decimal with 10 digits and 2 fractions
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link ISO4217CurrencyCodeType }
     *     
     */
    public ISO4217CurrencyCodeType getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link ISO4217CurrencyCodeType }
     *     
     */
    public void setCurrency(ISO4217CurrencyCodeType value) {
        this.currency = value;
    }

}
