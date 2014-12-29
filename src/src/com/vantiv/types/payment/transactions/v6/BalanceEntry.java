
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.vantiv.types.common.v6.TotalsAmountType;


/**
 * <p>Java class for BalanceEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BalanceEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="SalesCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SalesAmount" type="{urn:com:vantiv:types:common:v6}TotalsAmountType" minOccurs="0"/>
 *         &lt;element name="ReturnsCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ReturnsAmount" type="{urn:com:vantiv:types:common:v6}TotalsAmountType" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceEntry", propOrder = {

})
public class BalanceEntry {

    @XmlElement(name = "SalesCount")
    protected Integer salesCount;
    @XmlElement(name = "SalesAmount")
    protected TotalsAmountType salesAmount;
    @XmlElement(name = "ReturnsCount")
    protected Integer returnsCount;
    @XmlElement(name = "ReturnsAmount")
    protected TotalsAmountType returnsAmount;

    /**
     * Gets the value of the salesCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSalesCount() {
        return salesCount;
    }

    /**
     * Sets the value of the salesCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSalesCount(Integer value) {
        this.salesCount = value;
    }

    /**
     * Gets the value of the salesAmount property.
     * 
     * @return
     *     possible object is
     *     {@link TotalsAmountType }
     *     
     */
    public TotalsAmountType getSalesAmount() {
        return salesAmount;
    }

    /**
     * Sets the value of the salesAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalsAmountType }
     *     
     */
    public void setSalesAmount(TotalsAmountType value) {
        this.salesAmount = value;
    }

    /**
     * Gets the value of the returnsCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReturnsCount() {
        return returnsCount;
    }

    /**
     * Sets the value of the returnsCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReturnsCount(Integer value) {
        this.returnsCount = value;
    }

    /**
     * Gets the value of the returnsAmount property.
     * 
     * @return
     *     possible object is
     *     {@link TotalsAmountType }
     *     
     */
    public TotalsAmountType getReturnsAmount() {
        return returnsAmount;
    }

    /**
     * Sets the value of the returnsAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link TotalsAmountType }
     *     
     */
    public void setReturnsAmount(TotalsAmountType value) {
        this.returnsAmount = value;
    }

}
