
package com.vantiv.types.payment.transactions.v6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Used to test Connections
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="Response" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProjectVersion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BuildNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RevisionNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HostEnvironment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlRootElement(name = "EchoResponse")
public class EchoResponse {

    @XmlElement(name = "Response", required = true)
    protected String response;
    @XmlElement(name = "ProjectVersion", required = true)
    protected String projectVersion;
    @XmlElement(name = "BuildNumber", required = true)
    protected String buildNumber;
    @XmlElement(name = "RevisionNumber", required = true)
    protected String revisionNumber;
    @XmlElement(name = "HostEnvironment")
    protected String hostEnvironment;

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponse(String value) {
        this.response = value;
    }

    /**
     * Gets the value of the projectVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectVersion() {
        return projectVersion;
    }

    /**
     * Sets the value of the projectVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectVersion(String value) {
        this.projectVersion = value;
    }

    /**
     * Gets the value of the buildNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildNumber() {
        return buildNumber;
    }

    /**
     * Sets the value of the buildNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildNumber(String value) {
        this.buildNumber = value;
    }

    /**
     * Gets the value of the revisionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevisionNumber() {
        return revisionNumber;
    }

    /**
     * Sets the value of the revisionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevisionNumber(String value) {
        this.revisionNumber = value;
    }

    /**
     * Gets the value of the hostEnvironment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostEnvironment() {
        return hostEnvironment;
    }

    /**
     * Sets the value of the hostEnvironment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostEnvironment(String value) {
        this.hostEnvironment = value;
    }

}
