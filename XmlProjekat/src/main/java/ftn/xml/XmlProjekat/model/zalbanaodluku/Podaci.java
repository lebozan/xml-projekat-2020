package ftn.xml.XmlProjekat.model.zalbanaodluku;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Podaci {

    private String ime;
    private String prezime;
    private String mesto;
    private TAdresa adresaMesta;
    private String danMesec;
    private String godina;
    private String drugiPodaciKontakt;
    private String potpis;

    public String getIme() {
        return ime;
    }

    @XmlElement(name = "ime")
    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    @XmlElement(name = "prezime")
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getMesto() {
        return mesto;
    }

    @XmlElement(name = "mesto")
    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public TAdresa getAdresaMesta() {
        return adresaMesta;
    }

    @XmlElement(name = "adresa_mesta")
    public void setAdresaMesta(TAdresa adresaMesta) {
        this.adresaMesta = adresaMesta;
    }

    public String getDanMesec() {
        return danMesec;
    }

    @XmlElement(name = "dan_mesec")
    public void setDanMesec(String danMesec) {
        this.danMesec = danMesec;
    }

    public String getGodina() {
        return godina;
    }

    @XmlElement(name = "godina")
    public void setGodina(String godina) {
        this.godina = godina;
    }

    public String getDrugiPodaciKontakt() {
        return drugiPodaciKontakt;
    }

    @XmlElement(name = "drugi_podaci_kontakt")
    public void setDrugiPodaciKontakt(String drugiPodaciKontakt) {
        this.drugiPodaciKontakt = drugiPodaciKontakt;
    }

    public String getPotpis() {
        return potpis;
    }

    @XmlElement(name = "potpis")
    public void setPotpis(String potpis) {
        this.potpis = potpis;
    }
}
