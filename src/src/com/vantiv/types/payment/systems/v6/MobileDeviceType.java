
package com.vantiv.types.payment.systems.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.vantiv.types.common.v6.GeolocationType;


/**
 * <p>Java class for MobileDeviceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MobileDeviceType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:com:vantiv:types:payment:systems:v6}PaymentDeviceType">
 *       &lt;sequence>
 *         &lt;element name="Location" type="{urn:com:vantiv:types:common:v6}GeolocationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MobileDeviceType", propOrder = {
    "location"
})
public class MobileDeviceType
    extends PaymentDeviceType
{

    @XmlElement(name = "Location")
    protected GeolocationType location;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link GeolocationType }
     *     
     */
    public GeolocationType getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeolocationType }
     *     
     */
    public void setLocation(GeolocationType value) {
        this.location = value;
    }

}
