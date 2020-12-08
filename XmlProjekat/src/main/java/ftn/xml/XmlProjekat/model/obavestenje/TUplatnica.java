//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.12.07 at 10:53:02 PM CET 
//


package ftn.xml.XmlProjekat.model.obavestenje;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TUplatnica complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TUplatnica">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="podaci_o_duzniku" type="{http://www.ftn.uns.ac.rs/obavestenje}TFizicko_lice"/>
 *         &lt;element name="podaci_o_poveriocu" type="{http://www.ftn.uns.ac.rs/obavestenje}TPravno_lice"/>
 *         &lt;element name="svrha_placanja" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="podaci_o_uplati">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="sifra_placanja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="iznos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="podaci_o_zaduzenju" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="podaci_o_odobrenju" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "TUplatnica", propOrder = {
    "podaciODuzniku",
    "podaciOPoveriocu",
    "svrhaPlacanja",
    "podaciOUplati"
})
public class TUplatnica {

    @XmlElement(name = "podaci_o_duzniku", required = true)
    protected TFizickoLice podaciODuzniku;
    @XmlElement(name = "podaci_o_poveriocu", required = true)
    protected TPravnoLice podaciOPoveriocu;
    @XmlElement(name = "svrha_placanja", required = true)
    protected Object svrhaPlacanja;
    @XmlElement(name = "podaci_o_uplati", required = true)
    protected TUplatnica.PodaciOUplati podaciOUplati;

    /**
     * Gets the value of the podaciODuzniku property.
     * 
     * @return
     *     possible object is
     *     {@link TFizickoLice }
     *     
     */
    public TFizickoLice getPodaciODuzniku() {
        return podaciODuzniku;
    }

    /**
     * Sets the value of the podaciODuzniku property.
     * 
     * @param value
     *     allowed object is
     *     {@link TFizickoLice }
     *     
     */
    public void setPodaciODuzniku(TFizickoLice value) {
        this.podaciODuzniku = value;
    }

    /**
     * Gets the value of the podaciOPoveriocu property.
     * 
     * @return
     *     possible object is
     *     {@link TPravnoLice }
     *     
     */
    public TPravnoLice getPodaciOPoveriocu() {
        return podaciOPoveriocu;
    }

    /**
     * Sets the value of the podaciOPoveriocu property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPravnoLice }
     *     
     */
    public void setPodaciOPoveriocu(TPravnoLice value) {
        this.podaciOPoveriocu = value;
    }

    /**
     * Gets the value of the svrhaPlacanja property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSvrhaPlacanja() {
        return svrhaPlacanja;
    }

    /**
     * Sets the value of the svrhaPlacanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSvrhaPlacanja(Object value) {
        this.svrhaPlacanja = value;
    }

    /**
     * Gets the value of the podaciOUplati property.
     * 
     * @return
     *     possible object is
     *     {@link TUplatnica.PodaciOUplati }
     *     
     */
    public TUplatnica.PodaciOUplati getPodaciOUplati() {
        return podaciOUplati;
    }

    /**
     * Sets the value of the podaciOUplati property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUplatnica.PodaciOUplati }
     *     
     */
    public void setPodaciOUplati(TUplatnica.PodaciOUplati value) {
        this.podaciOUplati = value;
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
     *         &lt;element name="sifra_placanja" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="iznos" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="podaci_o_zaduzenju" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="podaci_o_odobrenju" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "sifraPlacanja",
        "iznos",
        "podaciOZaduzenju",
        "podaciOOdobrenju"
    })
    public static class PodaciOUplati {

        @XmlElement(name = "sifra_placanja")
        protected int sifraPlacanja;
        protected int iznos;
        @XmlElement(name = "podaci_o_zaduzenju", required = true)
        protected String podaciOZaduzenju;
        @XmlElement(name = "podaci_o_odobrenju", required = true)
        protected String podaciOOdobrenju;

        /**
         * Gets the value of the sifraPlacanja property.
         * 
         */
        public int getSifraPlacanja() {
            return sifraPlacanja;
        }

        /**
         * Sets the value of the sifraPlacanja property.
         * 
         */
        public void setSifraPlacanja(int value) {
            this.sifraPlacanja = value;
        }

        /**
         * Gets the value of the iznos property.
         * 
         */
        public int getIznos() {
            return iznos;
        }

        /**
         * Sets the value of the iznos property.
         * 
         */
        public void setIznos(int value) {
            this.iznos = value;
        }

        /**
         * Gets the value of the podaciOZaduzenju property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPodaciOZaduzenju() {
            return podaciOZaduzenju;
        }

        /**
         * Sets the value of the podaciOZaduzenju property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPodaciOZaduzenju(String value) {
            this.podaciOZaduzenju = value;
        }

        /**
         * Gets the value of the podaciOOdobrenju property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPodaciOOdobrenju() {
            return podaciOOdobrenju;
        }

        /**
         * Sets the value of the podaciOOdobrenju property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPodaciOOdobrenju(String value) {
            this.podaciOOdobrenju = value;
        }

    }

}
