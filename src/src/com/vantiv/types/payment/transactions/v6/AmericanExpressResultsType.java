
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AmericanExpressResultsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmericanExpressResultsType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:transactions:v6}CardResultsType">
 *       &lt;sequence>
 *         &lt;element name="AmexTransactionId" type="{urn:com:vantiv:types:common:v6}String15" minOccurs="0"/>
 *         &lt;element name="POSDataCodes" type="{urn:com:vantiv:types:common:v6}String12" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmericanExpressResultsType", propOrder = {
    "amexTransactionId",
    "posDataCodes"
})
public class AmericanExpressResultsType
    extends CardResultsType
{

    @XmlElement(name = "AmexTransactionId")
    protected String amexTransactionId;
    @XmlElement(name = "POSDataCodes")
    protected String posDataCodes;

    /**
     * Gets the value of the amexTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmexTransactionId() {
        return amexTransactionId;
    }

    /**
     * Sets the value of the amexTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmexTransactionId(String value) {
        this.amexTransactionId = value;
    }

    /**
     * Gets the value of the posDataCodes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSDataCodes() {
        return posDataCodes;
    }

    /**
     * Sets the value of the posDataCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSDataCodes(String value) {
        this.posDataCodes = value;
    }

}
