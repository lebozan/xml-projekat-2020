//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.11 at 11:35:49 AM CET 
//


package ftn.xml.ServisOrganVlasti.model.zahtev;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TInformacijeOZahtevu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TInformacijeOZahtevu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="opis_zahteva" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TInformacijeOZahtevu", propOrder = {
    "tekst",
    "opisZahteva"
})
public class TInformacijeOZahtevu {

    @XmlElement(required = true)
    protected String tekst;
    @XmlElement(name = "opis_zahteva", required = true)
    protected String opisZahteva;

    /**
     * Gets the value of the tekst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTekst() {
        return tekst;
    }

    /**
     * Sets the value of the tekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTekst(String value) {
        this.tekst = value;
    }

    /**
     * Gets the value of the opisZahteva property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpisZahteva() {
        return opisZahteva;
    }

    /**
     * Sets the value of the opisZahteva property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpisZahteva(String value) {
        this.opisZahteva = value;
    }

}