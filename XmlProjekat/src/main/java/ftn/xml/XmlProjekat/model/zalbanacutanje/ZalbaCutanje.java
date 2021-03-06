//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.08 at 09:04:51 AM CET 
//


package ftn.xml.XmlProjekat.model.zalbanacutanje;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zaglavlje">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="primalac">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="naziv_primaoca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="adresa_primaoca" type="{http://www.ftn.uns.ac.rs/zalbanacutanje}TAdresa"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="sadrzaj">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="predmet">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="naziv_predmeta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="naziv_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="razlozi_podnsenja">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="tipovi_razloga" type="{http://www.ftn.uns.ac.rs/zalbanacutanje}TRazlog"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="izjava">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="datum_podnosenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="podaci_o_zahtevu" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="predlog" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="podnosilac" type="{http://www.ftn.uns.ac.rs/zalbanacutanje}TLice"/>
 *         &lt;element name="mesto_podnosenja">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="datum_zalbe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="dan" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="mesec" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="godina" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zaglavlje",
    "sadrzaj",
    "podnosilac",
    "mestoPodnosenja",
    "datumZalbe"
})
@XmlRootElement(name = "zalbaCutanje")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ZalbaCutanje {

    @XmlElement(required = true)
    protected ZalbaCutanje.Zaglavlje zaglavlje;
    @XmlElement(required = true)
    protected ZalbaCutanje.Sadrzaj sadrzaj;
    @XmlElement(required = true)
    protected TLice podnosilac;
    @XmlElement(name = "mesto_podnosenja", required = true)
    protected ZalbaCutanje.MestoPodnosenja mestoPodnosenja;
    @XmlElement(name = "datum_zalbe", required = true)
    protected ZalbaCutanje.DatumZalbe datumZalbe;

    /**
     * Gets the value of the zaglavlje property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaCutanje.Zaglavlje }
     *     
     */
    public ZalbaCutanje.Zaglavlje getZaglavlje() {
        return zaglavlje;
    }

    /**
     * Sets the value of the zaglavlje property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaCutanje.Zaglavlje }
     *     
     */
    public void setZaglavlje(ZalbaCutanje.Zaglavlje value) {
        this.zaglavlje = value;
    }

    /**
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaCutanje.Sadrzaj }
     *     
     */
    public ZalbaCutanje.Sadrzaj getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaCutanje.Sadrzaj }
     *     
     */
    public void setSadrzaj(ZalbaCutanje.Sadrzaj value) {
        this.sadrzaj = value;
    }

    /**
     * Gets the value of the podnosilac property.
     * 
     * @return
     *     possible object is
     *     {@link TLice }
     *     
     */
    public TLice getPodnosilac() {
        return podnosilac;
    }

    /**
     * Sets the value of the podnosilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link TLice }
     *     
     */
    public void setPodnosilac(TLice value) {
        this.podnosilac = value;
    }

    /**
     * Gets the value of the mestoPodnosenja property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaCutanje.MestoPodnosenja }
     *     
     */
    public ZalbaCutanje.MestoPodnosenja getMestoPodnosenja() {
        return mestoPodnosenja;
    }

    /**
     * Sets the value of the mestoPodnosenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaCutanje.MestoPodnosenja }
     *     
     */
    public void setMestoPodnosenja(ZalbaCutanje.MestoPodnosenja value) {
        this.mestoPodnosenja = value;
    }

    /**
     * Gets the value of the datumZalbe property.
     * 
     * @return
     *     possible object is
     *     {@link ZalbaCutanje.DatumZalbe }
     *     
     */
    public ZalbaCutanje.DatumZalbe getDatumZalbe() {
        return datumZalbe;
    }

    /**
     * Sets the value of the datumZalbe property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZalbaCutanje.DatumZalbe }
     *     
     */
    public void setDatumZalbe(ZalbaCutanje.DatumZalbe value) {
        this.datumZalbe = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="dan" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="mesec" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="godina" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dan",
        "mesec",
        "godina",
        "tekst"
    })
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class DatumZalbe {

        @XmlElement(required = true)
        protected String dan;
        @XmlElement(required = true)
        protected String mesec;
        @XmlElement(required = true)
        protected String godina;
        @XmlElement(required = true)
        protected String tekst;

        /**
         * Gets the value of the dan property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDan() {
            return dan;
        }

        /**
         * Sets the value of the dan property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDan(String value) {
            this.dan = value;
        }

        /**
         * Gets the value of the mesec property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMesec() {
            return mesec;
        }

        /**
         * Sets the value of the mesec property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMesec(String value) {
            this.mesec = value;
        }

        /**
         * Gets the value of the godina property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGodina() {
            return godina;
        }

        /**
         * Sets the value of the godina property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGodina(String value) {
            this.godina = value;
        }

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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "tekst",
        "mesto"
    })
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class MestoPodnosenja {

        @XmlElement(required = true)
        protected String tekst;
        @XmlElement(required = true)
        protected String mesto;

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
         * Gets the value of the mesto property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMesto() {
            return mesto;
        }

        /**
         * Sets the value of the mesto property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMesto(String value) {
            this.mesto = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="predmet">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="naziv_predmeta" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="naziv_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="razlozi_podnsenja">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="tipovi_razloga" type="{http://www.ftn.uns.ac.rs/zalbanacutanje}TRazlog"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="izjava">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="datum_podnosenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="podaci_o_zahtevu" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="predlog" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "predmet",
        "razloziPodnsenja",
        "izjava"
    })
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Sadrzaj {

        @XmlElement(required = true)
        protected ZalbaCutanje.Sadrzaj.Predmet predmet;
        @XmlElement(name = "razlozi_podnsenja", required = true)
        protected ZalbaCutanje.Sadrzaj.RazloziPodnsenja razloziPodnsenja;
        @XmlElement(required = true)
        protected ZalbaCutanje.Sadrzaj.Izjava izjava;

        /**
         * Gets the value of the predmet property.
         * 
         * @return
         *     possible object is
         *     {@link ZalbaCutanje.Sadrzaj.Predmet }
         *     
         */
        public ZalbaCutanje.Sadrzaj.Predmet getPredmet() {
            return predmet;
        }

        /**
         * Sets the value of the predmet property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZalbaCutanje.Sadrzaj.Predmet }
         *     
         */
        public void setPredmet(ZalbaCutanje.Sadrzaj.Predmet value) {
            this.predmet = value;
        }

        /**
         * Gets the value of the razloziPodnsenja property.
         * 
         * @return
         *     possible object is
         *     {@link ZalbaCutanje.Sadrzaj.RazloziPodnsenja }
         *     
         */
        public ZalbaCutanje.Sadrzaj.RazloziPodnsenja getRazloziPodnsenja() {
            return razloziPodnsenja;
        }

        /**
         * Sets the value of the razloziPodnsenja property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZalbaCutanje.Sadrzaj.RazloziPodnsenja }
         *     
         */
        public void setRazloziPodnsenja(ZalbaCutanje.Sadrzaj.RazloziPodnsenja value) {
            this.razloziPodnsenja = value;
        }

        /**
         * Gets the value of the izjava property.
         * 
         * @return
         *     possible object is
         *     {@link ZalbaCutanje.Sadrzaj.Izjava }
         *     
         */
        public ZalbaCutanje.Sadrzaj.Izjava getIzjava() {
            return izjava;
        }

        /**
         * Sets the value of the izjava property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZalbaCutanje.Sadrzaj.Izjava }
         *     
         */
        public void setIzjava(ZalbaCutanje.Sadrzaj.Izjava value) {
            this.izjava = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="datum_podnosenja" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="podaci_o_zahtevu" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="predlog" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "content"
        })
        @NoArgsConstructor
        @AllArgsConstructor
        @Data
        public static class Izjava {

            @XmlElementRefs({
                @XmlElementRef(name = "datum_podnosenja", namespace = "http://www.ftn.uns.ac.rs/zalbanacutanje", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "tekst", namespace = "http://www.ftn.uns.ac.rs/zalbanacutanje", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "podaci_o_zahtevu", namespace = "http://www.ftn.uns.ac.rs/zalbanacutanje", type = JAXBElement.class, required = false),
                @XmlElementRef(name = "predlog", namespace = "http://www.ftn.uns.ac.rs/zalbanacutanje", type = JAXBElement.class, required = false)
            })
            protected List<JAXBElement<?>> content;

            /**
             * Gets the rest of the content model. 
             * 
             * <p>
             * You are getting this "catch-all" property because of the following reason: 
             * The field name "Tekst" is used by two different parts of a schema. See: 
             * line 51 of file:/C:/Users/Hp%20Zbook%2015/Desktop/xml-projekat-2020/XmlProjekat/src/main/java/ftn/xml/XmlProjekat/model/zalbanacutanje/zalbanacutanje.xsd
             * line 49 of file:/C:/Users/Hp%20Zbook%2015/Desktop/xml-projekat-2020/XmlProjekat/src/main/java/ftn/xml/XmlProjekat/model/zalbanacutanje/zalbanacutanje.xsd
             * <p>
             * To get rid of this property, apply a property customization to one 
             * of both of the following declarations to change their names: 
             * Gets the value of the content property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the content property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContent().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * {@link JAXBElement }{@code <}{@link String }{@code >}
             * 
             * 
             */
            public List<JAXBElement<?>> getContent() {
                if (content == null) {
                    content = new ArrayList<JAXBElement<?>>();
                }
                return this.content;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="naziv_predmeta" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="naziv_organa" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "nazivPredmeta",
            "tekst",
            "nazivOrgana"
        })
        @NoArgsConstructor
        @AllArgsConstructor
        @Data
        public static class Predmet {

            @XmlElement(name = "naziv_predmeta", required = true)
            protected String nazivPredmeta;
            @XmlElement(required = true)
            protected String tekst;
            @XmlElement(name = "naziv_organa", required = true)
            protected String nazivOrgana;

            /**
             * Gets the value of the nazivPredmeta property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNazivPredmeta() {
                return nazivPredmeta;
            }

            /**
             * Sets the value of the nazivPredmeta property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNazivPredmeta(String value) {
                this.nazivPredmeta = value;
            }

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
             * Gets the value of the nazivOrgana property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNazivOrgana() {
                return nazivOrgana;
            }

            /**
             * Sets the value of the nazivOrgana property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNazivOrgana(String value) {
                this.nazivOrgana = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="tipovi_razloga" type="{http://www.ftn.uns.ac.rs/zalbanacutanje}TRazlog"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "tekst",
            "tipoviRazloga"
        })
        @NoArgsConstructor
        @AllArgsConstructor
        @Data
        public static class RazloziPodnsenja {

            @XmlElement(required = true)
            protected String tekst;
            @XmlElement(name = "tipovi_razloga", required = true)
            protected TRazlog tipoviRazloga;

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
             * Gets the value of the tipoviRazloga property.
             * 
             * @return
             *     possible object is
             *     {@link TRazlog }
             *     
             */
            public TRazlog getTipoviRazloga() {
                return tipoviRazloga;
            }

            /**
             * Sets the value of the tipoviRazloga property.
             * 
             * @param value
             *     allowed object is
             *     {@link TRazlog }
             *     
             */
            public void setTipoviRazloga(TRazlog value) {
                this.tipoviRazloga = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="primalac">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="naziv_primaoca" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="adresa_primaoca" type="{http://www.ftn.uns.ac.rs/zalbanacutanje}TAdresa"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "naslov",
        "primalac",
        "tekst"
    })
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Zaglavlje {

        @XmlElement(required = true)
        protected String naslov;
        @XmlElement(required = true)
        protected ZalbaCutanje.Zaglavlje.Primalac primalac;
        @XmlElement(required = true)
        protected String tekst;

        /**
         * Gets the value of the naslov property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNaslov() {
            return naslov;
        }

        /**
         * Sets the value of the naslov property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNaslov(String value) {
            this.naslov = value;
        }

        /**
         * Gets the value of the primalac property.
         * 
         * @return
         *     possible object is
         *     {@link ZalbaCutanje.Zaglavlje.Primalac }
         *     
         */
        public ZalbaCutanje.Zaglavlje.Primalac getPrimalac() {
            return primalac;
        }

        /**
         * Sets the value of the primalac property.
         * 
         * @param value
         *     allowed object is
         *     {@link ZalbaCutanje.Zaglavlje.Primalac }
         *     
         */
        public void setPrimalac(ZalbaCutanje.Zaglavlje.Primalac value) {
            this.primalac = value;
        }

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
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="naziv_primaoca" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="adresa_primaoca" type="{http://www.ftn.uns.ac.rs/zalbanacutanje}TAdresa"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "nazivPrimaoca",
            "adresaPrimaoca"
        })
        @NoArgsConstructor
        @AllArgsConstructor
        @Data
        public static class Primalac {

            @XmlElement(name = "naziv_primaoca", required = true)
            protected String nazivPrimaoca;
            @XmlElement(name = "adresa_primaoca", required = true)
            protected TAdresa adresaPrimaoca;

            /**
             * Gets the value of the nazivPrimaoca property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNazivPrimaoca() {
                return nazivPrimaoca;
            }

            /**
             * Sets the value of the nazivPrimaoca property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNazivPrimaoca(String value) {
                this.nazivPrimaoca = value;
            }

            /**
             * Gets the value of the adresaPrimaoca property.
             * 
             * @return
             *     possible object is
             *     {@link TAdresa }
             *     
             */
            public TAdresa getAdresaPrimaoca() {
                return adresaPrimaoca;
            }

            /**
             * Sets the value of the adresaPrimaoca property.
             * 
             * @param value
             *     allowed object is
             *     {@link TAdresa }
             *     
             */
            public void setAdresaPrimaoca(TAdresa value) {
                this.adresaPrimaoca = value;
            }

        }

    }

}
