package ftn.xml.ServisPoverenik.model.korisnik;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;


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
 *         &lt;element name="korisnicko_ime">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="lozinka">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tip_korisnika">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="fizicko lice"/>
 *               &lt;enumeration value="pravno lice"/>
 *               &lt;enumeration value="korisnik"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="uloga">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="gradjanin"/>
 *               &lt;enumeration value="sluzbenik"/>
 *               &lt;enumeration value="poverenik"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="id_korisnika" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "korisnickoIme",
    "lozinka",
    "ime",
    "tipKorisnika",
    "uloga"
})
@XmlRootElement(name = "korisnik")
public class Korisnik implements UserDetails {

    @XmlElement(name = "korisnicko_ime", required = true)
    protected String korisnickoIme;
    @XmlElement(required = true)
    protected String lozinka;
    @XmlElement(required = true)
    protected String ime;
    @XmlElement(name = "tip_korisnika", required = true, defaultValue = "korisnik")
    protected String tipKorisnika;
    @XmlElement(required = true, defaultValue = "gradjanin")
    protected String uloga;
    @XmlAttribute(name = "id_korisnika")
    @XmlSchemaType(name = "anyURI")
    protected String idKorisnika;

    /**
     * Gets the value of the korisnickoIme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * Sets the value of the korisnickoIme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKorisnickoIme(String value) {
        this.korisnickoIme = value;
    }

    /**
     * Gets the value of the lozinka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     * Sets the value of the lozinka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLozinka(String value) {
        this.lozinka = value;
    }

    /**
     * Gets the value of the ime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIme() {
        return ime;
    }

    /**
     * Sets the value of the ime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIme(String value) {
        this.ime = value;
    }

    /**
     * Gets the value of the tipKorisnika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipKorisnika() {
        return tipKorisnika;
    }

    /**
     * Sets the value of the tipKorisnika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipKorisnika(String value) {
        this.tipKorisnika = value;
    }

    /**
     * Gets the value of the uloga property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUloga() {
        return uloga;
    }

    /**
     * Sets the value of the uloga property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUloga(String value) {
        this.uloga = value;
    }

    /**
     * Gets the value of the idKorisnika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdKorisnika() {
        return idKorisnika;
    }

    /**
     * Sets the value of the idKorisnika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdKorisnika(String value) {
        this.idKorisnika = value;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(getTipKorisnika());
        ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(grantedAuthority);
        return authorities;
    }



    @Override
    public String getPassword() {
        return lozinka;
    }

    @Override
    public String getUsername() {
        return korisnickoIme;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
