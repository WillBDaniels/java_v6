
package com.vantiv.types.payment.instruments.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Data Elements required for Card Present transactions
 * 
 * <p>Java class for CardSwipedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardSwipedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Track1" type="{urn:com:vantiv:types:payment:instruments:v6}TrackDataType"/>
 *         &lt;element name="Track2" type="{urn:com:vantiv:types:payment:instruments:v6}TrackDataType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardSwipedType", propOrder = {
    "track1",
    "track2"
})
@XmlSeeAlso({
    GiftCardSwipedType.class
})
public class CardSwipedType {

    @XmlElement(name = "Track1")
    protected TrackDataType track1;
    @XmlElement(name = "Track2")
    protected TrackDataType track2;

    /**
     * Gets the value of the track1 property.
     * 
     * @return
     *     possible object is
     *     {@link TrackDataType }
     *     
     */
    public TrackDataType getTrack1() {
        return track1;
    }

    /**
     * Sets the value of the track1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackDataType }
     *     
     */
    public void setTrack1(TrackDataType value) {
        this.track1 = value;
    }

    /**
     * Gets the value of the track2 property.
     * 
     * @return
     *     possible object is
     *     {@link TrackDataType }
     *     
     */
    public TrackDataType getTrack2() {
        return track2;
    }

    /**
     * Sets the value of the track2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrackDataType }
     *     
     */
    public void setTrack2(TrackDataType value) {
        this.track2 = value;
    }

}
