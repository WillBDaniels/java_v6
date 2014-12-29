
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.vantiv.types.common.v6.AmountType;
import com.vantiv.types.payment.instruments.v6.CreditInstrumentType;
import com.vantiv.types.payment.instruments.v6.GiftInstrumentType;


/**
 * Capture Transaction Request
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
 *         &lt;element name="AuthorizationCode" type="{urn:com:vantiv:types:payment:transactions:v6}AuthorizationCodeType" minOccurs="0"/>
 *         &lt;element name="OriginalAmount" type="{urn:com:vantiv:types:common:v6}AmountType" minOccurs="0"/>
 *         &lt;element name="CaptureAmount" type="{urn:com:vantiv:types:common:v6}AmountType"/>
 *         &lt;element name="OriginalTransactionTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="OriginalReferenceNumber" type="{urn:com:vantiv:types:payment:transactions:v6}ReferenceNumberType" minOccurs="0"/>
 *         &lt;element name="ForceCapture" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;sequence>
 *             &lt;element name="Credit" type="{urn:com:vantiv:types:payment:instruments:v6}CreditInstrumentType"/>
 *             &lt;element name="TipAmount" type="{urn:com:vantiv:types:common:v6}AmountType" minOccurs="0"/>
 *             &lt;element name="ConvenienceFee" type="{urn:com:vantiv:types:common:v6}AmountType" minOccurs="0"/>
 *             &lt;element name="Tax" type="{urn:com:vantiv:types:payment:transactions:v6}TaxAmountType" minOccurs="0"/>
 *             &lt;element name="PurchaseOrder" type="{urn:com:vantiv:types:payment:transactions:v6}PurchaseOrderType" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="Gift" type="{urn:com:vantiv:types:payment:instruments:v6}GiftInstrumentType"/>
 *           &lt;/sequence>
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
    "authorizationCode",
    "originalAmount",
    "captureAmount",
    "originalTransactionTimestamp",
    "originalReferenceNumber",
    "forceCapture",
    "credit",
    "tipAmount",
    "convenienceFee",
    "tax",
    "purchaseOrder",
    "gift"
})
@XmlRootElement(name = "CaptureRequest")
public class CaptureRequest
    extends TransactionRequestType
{

    @XmlElement(name = "AuthorizationCode")
    protected String authorizationCode;
    @XmlElement(name = "OriginalAmount")
    protected AmountType originalAmount;
    @XmlElement(name = "CaptureAmount", required = true)
    protected AmountType captureAmount;
    @XmlElement(name = "OriginalTransactionTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar originalTransactionTimestamp;
    @XmlElement(name = "OriginalReferenceNumber")
    protected String originalReferenceNumber;
    @XmlElement(name = "ForceCapture")
    protected Boolean forceCapture;
    @XmlElement(name = "Credit")
    protected CreditInstrumentType credit;
    @XmlElement(name = "TipAmount")
    protected AmountType tipAmount;
    @XmlElement(name = "ConvenienceFee")
    protected AmountType convenienceFee;
    @XmlElement(name = "Tax")
    protected TaxAmountType tax;
    @XmlElement(name = "PurchaseOrder")
    protected String purchaseOrder;
    @XmlElement(name = "Gift")
    protected GiftInstrumentType gift;

    /**
     * Gets the value of the authorizationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationCode() {
        return authorizationCode;
    }

    /**
     * Sets the value of the authorizationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationCode(String value) {
        this.authorizationCode = value;
    }

    /**
     * Gets the value of the originalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getOriginalAmount() {
        return originalAmount;
    }

    /**
     * Sets the value of the originalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setOriginalAmount(AmountType value) {
        this.originalAmount = value;
    }

    /**
     * Gets the value of the captureAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getCaptureAmount() {
        return captureAmount;
    }

    /**
     * Sets the value of the captureAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setCaptureAmount(AmountType value) {
        this.captureAmount = value;
    }

    /**
     * Gets the value of the originalTransactionTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOriginalTransactionTimestamp() {
        return originalTransactionTimestamp;
    }

    /**
     * Sets the value of the originalTransactionTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOriginalTransactionTimestamp(XMLGregorianCalendar value) {
        this.originalTransactionTimestamp = value;
    }

    /**
     * Gets the value of the originalReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalReferenceNumber() {
        return originalReferenceNumber;
    }

    /**
     * Sets the value of the originalReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalReferenceNumber(String value) {
        this.originalReferenceNumber = value;
    }

    /**
     * Gets the value of the forceCapture property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isForceCapture() {
        return forceCapture;
    }

    /**
     * Sets the value of the forceCapture property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForceCapture(Boolean value) {
        this.forceCapture = value;
    }

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

    /**
     * Gets the value of the tipAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getTipAmount() {
        return tipAmount;
    }

    /**
     * Sets the value of the tipAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setTipAmount(AmountType value) {
        this.tipAmount = value;
    }

    /**
     * Gets the value of the convenienceFee property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getConvenienceFee() {
        return convenienceFee;
    }

    /**
     * Sets the value of the convenienceFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setConvenienceFee(AmountType value) {
        this.convenienceFee = value;
    }

    /**
     * Gets the value of the tax property.
     * 
     * @return
     *     possible object is
     *     {@link TaxAmountType }
     *     
     */
    public TaxAmountType getTax() {
        return tax;
    }

    /**
     * Sets the value of the tax property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxAmountType }
     *     
     */
    public void setTax(TaxAmountType value) {
        this.tax = value;
    }

    /**
     * Gets the value of the purchaseOrder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseOrder() {
        return purchaseOrder;
    }

    /**
     * Sets the value of the purchaseOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseOrder(String value) {
        this.purchaseOrder = value;
    }

    /**
     * Gets the value of the gift property.
     * 
     * @return
     *     possible object is
     *     {@link GiftInstrumentType }
     *     
     */
    public GiftInstrumentType getGift() {
        return gift;
    }

    /**
     * Sets the value of the gift property.
     * 
     * @param value
     *     allowed object is
     *     {@link GiftInstrumentType }
     *     
     */
    public void setGift(GiftInstrumentType value) {
        this.gift = value;
    }

}
