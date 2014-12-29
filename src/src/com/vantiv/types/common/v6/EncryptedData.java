
package com.vantiv.types.common.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Encrypted Data Element
 * 
 * <p>Java class for EncryptedData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EncryptedData">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="encryption-type" use="required" type="{urn:com:vantiv:types:common:v6}EncryptionType" />
 *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EncryptedData", propOrder = {
    "value"
})
public class EncryptedData {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "encryption-type", required = true)
    protected EncryptionType encryptionType;
    @XmlAttribute(name = "key")
    protected String key;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the encryptionType property.
     * 
     * @return
     *     possible object is
     *     {@link EncryptionType }
     *     
     */
    public EncryptionType getEncryptionType() {
        return encryptionType;
    }

    /**
     * Sets the value of the encryptionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EncryptionType }
     *     
     */
    public void setEncryptionType(EncryptionType value) {
        this.encryptionType = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

}
