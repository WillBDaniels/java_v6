
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.vantiv.types.common.v6.EncryptedData;


/**
 * Track Data encoded on Card's magnetic stripe
 * 
 * <p>Java class for TrackDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrackDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="EncryptedTrackData" type="{urn:com:vantiv:types:common:v6}EncryptedData"/>
 *         &lt;element name="TrackData" type="{urn:com:vantiv:types:payment:instruments:v6}UnencryptedTrackDataType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackDataType", propOrder = {
    "encryptedTrackData",
    "trackData"
})
public class TrackDataType {

    @XmlElement(name = "EncryptedTrackData")
    protected EncryptedData encryptedTrackData;
    @XmlElement(name = "TrackData")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String trackData;

    /**
     * Gets the value of the encryptedTrackData property.
     * 
     * @return
     *     possible object is
     *     {@link EncryptedData }
     *     
     */
    public EncryptedData getEncryptedTrackData() {
        return encryptedTrackData;
    }

    /**
     * Sets the value of the encryptedTrackData property.
     * 
     * @param value
     *     allowed object is
     *     {@link EncryptedData }
     *     
     */
    public void setEncryptedTrackData(EncryptedData value) {
        this.encryptedTrackData = value;
    }

    /**
     * Gets the value of the trackData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackData() {
        return trackData;
    }

    /**
     * Sets the value of the trackData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackData(String value) {
        this.trackData = value;
    }

}
