
package ocpp.cs._2015._10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for IdTagInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdTagInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{urn://Ocpp/Cs/2015/10/}AuthorizationStatus"/>
 *         &lt;element name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="parentIdTag" type="{urn://Ocpp/Cs/2015/10/}IdToken" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IdTagInfo", propOrder = {
    "status",
    "expiryDate",
    "parentIdTag"
})
public class IdTagInfo {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected AuthorizationStatus status;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiryDate;
    protected String parentIdTag;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizationStatus }
     *     
     */
    public AuthorizationStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizationStatus }
     *     
     */
    public void setStatus(AuthorizationStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiryDate(XMLGregorianCalendar value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the parentIdTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentIdTag() {
        return parentIdTag;
    }

    /**
     * Sets the value of the parentIdTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentIdTag(String value) {
        this.parentIdTag = value;
    }

}
