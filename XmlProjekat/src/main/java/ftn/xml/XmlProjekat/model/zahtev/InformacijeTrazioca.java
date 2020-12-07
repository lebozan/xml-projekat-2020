package ftn.xml.XmlProjekat.model.zahtev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlType(propOrder = {"ime", "prezime", "adresa", "kontaktPodaci", "potpis"})
public class InformacijeTrazioca {


    private String ime;
    private String prezime;
    private String adresa;
    private String kontaktPodaci;
    private String potpis;


    public String getIme() {
        return ime;
    }

    @XmlElement(name = "ime", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    @XmlElement(name = "prezime", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    @XmlElement(name = "adresa", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getKontaktPodaci() {
        return kontaktPodaci;
    }

    @XmlElement(name = "kontakt_podaci", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setKontaktPodaci(String kontaktPodaci) {
        this.kontaktPodaci = kontaktPodaci;
    }

    public String getPotpis() {
        return potpis;
    }

    @XmlElement(name = "potpis", namespace = "http://www.ftn.uns.ac.rs/zahtev")
    public void setPotpis(String potpis) {
        this.potpis = potpis;
    }
}
