
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import com.vantiv.types.common.v6.AddressType;
import com.vantiv.types.common.v6.EncryptedData;


/**
 * Debit Card Payment Instrument
 * 
 * <p>Java class for DebitInstrumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DebitInstrumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardholderAddress" type="{urn:com:vantiv:types:common:v6}AddressType" minOccurs="0"/>
 *         &lt;element name="PartialApprovalCode" type="{urn:com:vantiv:types:payment:instruments:v6}PartialIndicatorType" minOccurs="0"/>
 *         &lt;element name="BenefitTransactionNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[0-9]{1,7}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="VoucherNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[0-9]{1,15}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PinData" type="{urn:com:vantiv:types:common:v6}EncryptedData" minOccurs="0"/>
 *         &lt;element name="AccountType" type="{urn:com:vantiv:types:payment:instruments:v6}AccountType" minOccurs="0"/>
 *         &lt;group ref="{urn:com:vantiv:types:payment:instruments:v6}CreditOrDebitCardGroup"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DebitInstrumentType", propOrder = {
    "cardholderAddress",
    "partialApprovalCode",
    "benefitTransactionNumber",
    "voucherNumber",
    "pinData",
    "accountType",
    "cardKeyed",
    "cardSwiped"
})
public class DebitInstrumentType {

    @XmlElement(name = "CardholderAddress")
    protected AddressType cardholderAddress;
    @XmlElement(name = "PartialApprovalCode")
    @XmlSchemaType(name = "string")
    protected PartialIndicatorType partialApprovalCode;
    @XmlElement(name = "BenefitTransactionNumber")
    protected String benefitTransactionNumber;
    @XmlElement(name = "VoucherNumber")
    protected String voucherNumber;
    @XmlElement(name = "PinData")
    protected EncryptedData pinData;
    @XmlElement(name = "AccountType")
    @XmlSchemaType(name = "string")
    protected AccountType accountType;
    @XmlElement(name = "CardKeyed")
    protected CreditOrDebitCardKeyedType cardKeyed;
    @XmlElement(name = "CardSwiped")
    protected CardSwipedType cardSwiped;

    /**
     * Gets the value of the cardholderAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getCardholderAddress() {
        return cardholderAddress;
    }

    /**
     * Sets the value of the cardholderAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setCardholderAddress(AddressType value) {
        this.cardholderAddress = value;
    }

    /**
     * Gets the value of the partialApprovalCode property.
     * 
     * @return
     *     possible object is
     *     {@link PartialIndicatorType }
     *     
     */
    public PartialIndicatorType getPartialApprovalCode() {
        return partialApprovalCode;
    }

    /**
     * Sets the value of the partialApprovalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartialIndicatorType }
     *     
     */
    public void setPartialApprovalCode(PartialIndicatorType value) {
        this.partialApprovalCode = value;
    }

    /**
     * Gets the value of the benefitTransactionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBenefitTransactionNumber() {
        return benefitTransactionNumber;
    }

    /**
     * Sets the value of the benefitTransactionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBenefitTransactionNumber(String value) {
        this.benefitTransactionNumber = value;
    }

    /**
     * Gets the value of the voucherNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherNumber() {
        return voucherNumber;
    }

    /**
     * Sets the value of the voucherNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherNumber(String value) {
        this.voucherNumber = value;
    }

    /**
     * Gets the value of the pinData property.
     * 
     * @return
     *     possible object is
     *     {@link EncryptedData }
     *     
     */
    public EncryptedData getPinData() {
        return pinData;
    }

    /**
     * Sets the value of the pinData property.
     * 
     * @param value
     *     allowed object is
     *     {@link EncryptedData }
     *     
     */
    public void setPinData(EncryptedData value) {
        this.pinData = value;
    }

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link AccountType }
     *     
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccountType }
     *     
     */
    public void setAccountType(AccountType value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the cardKeyed property.
     * 
     * @return
     *     possible object is
     *     {@link CreditOrDebitCardKeyedType }
     *     
     */
    public CreditOrDebitCardKeyedType getCardKeyed() {
        return cardKeyed;
    }

    /**
     * Sets the value of the cardKeyed property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditOrDebitCardKeyedType }
     *     
     */
    public void setCardKeyed(CreditOrDebitCardKeyedType value) {
        this.cardKeyed = value;
    }

    /**
     * Gets the value of the cardSwiped property.
     * 
     * @return
     *     possible object is
     *     {@link CardSwipedType }
     *     
     */
    public CardSwipedType getCardSwiped() {
        return cardSwiped;
    }

    /**
     * Sets the value of the cardSwiped property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardSwipedType }
     *     
     */
    public void setCardSwiped(CardSwipedType value) {
        this.cardSwiped = value;
    }

}
